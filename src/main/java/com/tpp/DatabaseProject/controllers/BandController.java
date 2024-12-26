package com.tpp.DatabaseProject.controllers;

import com.tpp.DatabaseProject.models.Band;
import com.tpp.DatabaseProject.service.BandService;
import com.tpp.DatabaseProject.service.GenreService;
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
@RequestMapping("/bands")
public class BandController {
    @Autowired
    private BandService bandService;

    @Autowired
    private GenreService genreService;

    @GetMapping
    public String listBands(Model model) {
        model.addAttribute("bands", bandService.getAllBands());
        return "bands";
    }

    @GetMapping("/add")
    public String addBandForm(Model model, Authentication authentication) {
        checkAdminAccess(authentication);
        model.addAttribute("band", new Band());
        model.addAttribute("genres", genreService.getAllGenres());
        return "add-band";
    }

    @PostMapping("/add")
    public String addBand(@Valid @ModelAttribute("band") Band band, BindingResult result, Model model,
            Authentication authentication) {
        checkAdminAccess(authentication);
        if (result.hasErrors()) {
            model.addAttribute("genres", genreService.getAllGenres());
            return "add-band";
        }
        bandService.saveBand(band);
        return "redirect:/bands";
    }

    @PostMapping("/update/{id}")
    public String updateBand(@PathVariable("id") Integer id, @Valid @ModelAttribute("band") Band band,
            BindingResult result, Model model, Authentication authentication) {
        checkAdminAccess(authentication);
        if (result.hasErrors()) {
            model.addAttribute("genres", genreService.getAllGenres());
            return "edit-band";
        }
        band.setId(id);
        bandService.updateBand(band);
        return "redirect:/bands";
    }

    @GetMapping("/edit/{id}")
    public String editBandForm(@PathVariable("id") Integer id, Model model, Authentication authentication) {
        checkAdminAccess(authentication);
        Band band = bandService.findBandById(id).orElse(null);
        if (band != null) {
            model.addAttribute("band", band);
            model.addAttribute("genres", genreService.getAllGenres());
            return "edit-band";
        } else {
            return "redirect:/bands";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteBand(@PathVariable("id") Integer id, Authentication authentication) {
        checkAdminAccess(authentication);
        bandService.deleteBandById(id);
        return "redirect:/bands";
    }

    private void checkAdminAccess(Authentication authentication) {
        if (authentication == null
                || !authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            throw new AccessDeniedException("Access denied");
        }
    }
}
