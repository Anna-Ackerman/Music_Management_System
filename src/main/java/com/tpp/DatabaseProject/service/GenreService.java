package com.tpp.DatabaseProject.service;

import com.tpp.DatabaseProject.models.Genre;
import com.tpp.DatabaseProject.repository.GenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    @Autowired
    private GenresRepository genreRepository;

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Optional<Genre> findGenreById(Integer id) {
        return genreRepository.findById(id);
    }

    public void saveGenre(Genre genre) {
        genreRepository.save(genre);
    }

    public void updateGenre(Genre updatedGenre) {
        Genre existingGenre = genreRepository.findById(updatedGenre.getId())
                .orElseThrow(() -> new IllegalArgumentException("Genre not found"));

        existingGenre.setName(updatedGenre.getName());
        genreRepository.save(existingGenre);
    }

    public void deleteGenreById(Integer id) {
        genreRepository.deleteById(id);
    }
}
