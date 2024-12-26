package com.tpp.DatabaseProject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import java.util.Objects;

@Component
public class DatabaseInitializer {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @EventListener(ContextRefreshedEvent.class)
    public void initializeDatabase() {
        Integer bandCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM band", Integer.class);
        Integer userCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users", Integer.class);

        if (Objects.equals(bandCount, 0) && Objects.equals(userCount, 0)) {
            System.out.println("Database is empty. Initializing data...");

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(getClass().getResourceAsStream("/data.sql"), StandardCharsets.UTF_8))) {

                String sql = reader.lines().collect(Collectors.joining("\n"));
                jdbcTemplate.execute(sql);

                resetSequences();

                System.out.println("Database initialized successfully.");
            } catch (Exception e) {
                System.err.println("Failed to initialize database: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Database already contains data. Skipping initialization.");
        }
    }

    private void resetSequences() {
        try {
            jdbcTemplate.execute("SELECT setval('genre_id_seq', COALESCE((SELECT MAX(id) FROM genre), 1))");
            jdbcTemplate.execute("SELECT setval('band_id_seq', COALESCE((SELECT MAX(id) FROM band), 1))");
            jdbcTemplate.execute("SELECT setval('song_id_seq', COALESCE((SELECT MAX(id) FROM song), 1))");
            jdbcTemplate.execute("SELECT setval('users_id_seq', COALESCE((SELECT MAX(id) FROM users), 1))");
            System.out.println("Sequences reset successfully.");
        } catch (Exception e) {
            System.err.println("Failed to reset sequences: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
