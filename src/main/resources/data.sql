INSERT INTO genre ( name) VALUES ('Grunge') ON CONFLICT DO NOTHING;
INSERT INTO genre (name) VALUES ('Nu metal') ON CONFLICT DO NOTHING;
INSERT INTO genre (name) VALUES ('Punk Rock') ON CONFLICT DO NOTHING;
INSERT INTO genre (name) VALUES ('Alternative Rock') ON CONFLICT DO NOTHING;
INSERT INTO genre (name) VALUES ('Metalcore') ON CONFLICT DO NOTHING;

INSERT INTO band (name, genre_id) VALUES ('Linkin Park', 2) ON CONFLICT DO NOTHING;
INSERT INTO band (name, genre_id) VALUES ('Deftones', 2) ON CONFLICT DO NOTHING;
INSERT INTO band (name, genre_id) VALUES ('Bullet for My Valentine', 5) ON CONFLICT DO NOTHING;
INSERT INTO band (name, genre_id) VALUES ('Black Veil Brides', 5) ON CONFLICT DO NOTHING;
INSERT INTO band (name, genre_id) VALUES ('Nirvana', 1) ON CONFLICT DO NOTHING;
INSERT INTO band (name, genre_id) VALUES ('Alice In Chains', 1) ON CONFLICT DO NOTHING;
INSERT INTO band (name, genre_id) VALUES ('Pearl Jam', 1) ON CONFLICT DO NOTHING;
INSERT INTO band (name, genre_id) VALUES ('30 Seconds To Mars', 4) ON CONFLICT DO NOTHING;
INSERT INTO band (name, genre_id) VALUES ('Radiohead', 4) ON CONFLICT DO NOTHING;
INSERT INTO band (name, genre_id) VALUES ('Muse', 4) ON CONFLICT DO NOTHING;
INSERT INTO band (name, genre_id) VALUES ('Green Day', 3) ON CONFLICT DO NOTHING;
INSERT INTO band (name, genre_id) VALUES ('Sam 41', 3) ON CONFLICT DO NOTHING;

INSERT INTO song (name, band_id) VALUES ('From The Inside', 1) ON CONFLICT DO NOTHING;
INSERT INTO song (name, band_id) VALUES ('New Divide', 1) ON CONFLICT DO NOTHING;
INSERT INTO song (name, band_id) VALUES ('Lost', 1) ON CONFLICT DO NOTHING;
INSERT INTO song (name, band_id) VALUES ('Rosemary', 2) ON CONFLICT DO NOTHING;
INSERT INTO song (name, band_id) VALUES ('Cherry Waves', 2) ON CONFLICT DO NOTHING;
INSERT INTO song (name, band_id) VALUES ('Your Betrayal', 3) ON CONFLICT DO NOTHING;
INSERT INTO song (name, band_id) VALUES ('Hearts Burst Into Fire', 3) ON CONFLICT DO NOTHING;
INSERT INTO song (name, band_id) VALUES ('In The End', 4) ON CONFLICT DO NOTHING;
INSERT INTO song (name, band_id) VALUES ('Goodbye Agony', 4) ON CONFLICT DO NOTHING;
INSERT INTO song (name, band_id) VALUES ('Heart-Shaped Box', 5) ON CONFLICT DO NOTHING;
INSERT INTO song (name, band_id) VALUES ('Lithium', 5) ON CONFLICT DO NOTHING;
INSERT INTO song (name, band_id) VALUES ('In Bloom', 5) ON CONFLICT DO NOTHING;
INSERT INTO song (name, band_id) VALUES ('Down in a Hole', 6) ON CONFLICT DO NOTHING;
INSERT INTO song (name, band_id) VALUES ('Nutshell', 6) ON CONFLICT DO NOTHING;
INSERT INTO song (name, band_id) VALUES ('Black', 7) ON CONFLICT DO NOTHING;
INSERT INTO song (name, band_id) VALUES ('Alive', 7) ON CONFLICT DO NOTHING;
INSERT INTO song (name, band_id) VALUES ('Capricorn', 8) ON CONFLICT DO NOTHING;
INSERT INTO song (name, band_id) VALUES ('Street Spirit', 9) ON CONFLICT DO NOTHING;
INSERT INTO song (name, band_id) VALUES ('True Love Waits', 9) ON CONFLICT DO NOTHING;
INSERT INTO song (name, band_id) VALUES ('New Born', 10) ON CONFLICT DO NOTHING;
INSERT INTO song (name, band_id) VALUES ('Wake Me Up When September Ends', 11) ON CONFLICT DO NOTHING;
INSERT INTO song (name, band_id) VALUES ('21 Guns', 11) ON CONFLICT DO NOTHING;
INSERT INTO song (name, band_id) VALUES ('Holiday', 11) ON CONFLICT DO NOTHING;
INSERT INTO song (name, band_id) VALUES ('With Me', 12) ON CONFLICT DO NOTHING;
INSERT INTO song (name, band_id) VALUES ('Still Waiting', 12) ON CONFLICT DO NOTHING;

INSERT INTO users (username, password, role) VALUES ('James Hetfield', '$2a$10$7Yq5vDuwnhXyTn./oI0P8eXsdyHcwDdKM4.uWo.caVqMXm7qXEK7q', 'ADMIN') ON CONFLICT DO NOTHING;
INSERT INTO users (username, password, role) VALUES ('Edward Elric', '$2a$10$7Yq5vDuwnhXyTn./oI0P8eXsdyHcwDdKM4.uWo.caVqMXm7qXEK7q', 'USER') ON CONFLICT DO NOTHING;

