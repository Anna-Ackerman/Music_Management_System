package com.tpp.DatabaseProject.controllers;

import com.tpp.DatabaseProject.models.Genre;
import com.tpp.DatabaseProject.service.GenreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    public String listGenres(Model model) {
        model.addAttribute("genres", genreService.getAllGenres());
        return "genres";
    }

    @GetMapping("/add")
    public String addGenreForm(Model model) {
        model.addAttribute("genre", new Genre());
        return "add-genre";
    }

    @PostMapping("/add")
    public String addGenre(@Valid @ModelAttribute("genre") Genre genre, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-genre";
        }
        genreService.saveGenre(genre);
        return "redirect:/genres";
    }

    @GetMapping("/edit/{id}")
    public String editGenreForm(@PathVariable("id") Integer id, Model model) {
        Genre genre = genreService.findGenreById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid genre ID: " + id));
        model.addAttribute("genre", genre);
        return "edit-genre";
    }

    @PostMapping("/edit/{id}")
    public String editGenre(@PathVariable("id") Integer id, @Valid @ModelAttribute("genre") Genre genre,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "edit-genre";
        }
        genreService.updateGenre(genre);
        return "redirect:/genres";
    }

    @GetMapping("/delete/{id}")
    public String deleteGenre(@PathVariable("id") Integer id) {
        genreService.deleteGenreById(id);
        return "redirect:/genres";
    }
}
