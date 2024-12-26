package com.tpp.DatabaseProject.controllers;

import com.tpp.DatabaseProject.models.Song;
import com.tpp.DatabaseProject.service.SongService;
import com.tpp.DatabaseProject.service.BandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private SongService songService;

    @Autowired
    private BandService bandService;

    @GetMapping
    public String listSongs(Model model) {
        model.addAttribute("songs", songService.getAllSongs());
        return "songs";
    }

    @GetMapping("/add")
    public String addSongForm(Model model, Authentication authentication) {
        checkAdminAccess(authentication);
        model.addAttribute("song", new Song());
        model.addAttribute("bands", bandService.getAllBands());
        return "add-song";
    }

    @PostMapping("/add")
    public String addSong(@Valid @ModelAttribute("song") Song song, BindingResult result,
            Model model, Authentication authentication) {
        checkAdminAccess(authentication);
        if (result.hasErrors()) {
            model.addAttribute("bands", bandService.getAllBands());
            return "add-song";
        }
        songService.saveSong(song);
        return "redirect:/songs";
    }

    @PostMapping("/update/{id}")
    public String updateSong(@PathVariable("id") Integer id, @Valid @ModelAttribute("song") Song song,
            BindingResult result, Model model, Authentication authentication) {
        checkAdminAccess(authentication);

        if (result.hasErrors()) {
            model.addAttribute("bands", bandService.getAllBands());
            return "edit-song";
        }

        Song existingSong = songService.findSongById(id).orElseThrow(
                () -> new IllegalArgumentException("Song not found with ID: " + id));

        existingSong.setName(song.getName());
        existingSong.setBand(song.getBand());
        songService.updateSong(existingSong);

        return "redirect:/songs";
    }

    @GetMapping("/edit/{id}")
    public String editSongForm(@PathVariable("id") Integer id, Model model, Authentication authentication) {
        checkAdminAccess(authentication);
        Song song = songService.findSongById(id).orElse(null);
        if (song != null) {
            model.addAttribute("song", song);
            model.addAttribute("bands", bandService.getAllBands());
            return "edit-song";
        } else {
            return "redirect:/songs";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable("id") Integer id, Authentication authentication) {
        checkAdminAccess(authentication);
        songService.deleteSongById(id);
        return "redirect:/songs";
    }

    private void checkAdminAccess(Authentication authentication) {
        if (authentication == null
                || !authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            throw new AccessDeniedException("Access denied");
        }
    }
}
