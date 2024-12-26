package com.tpp.DatabaseProject.service;

import com.tpp.DatabaseProject.models.Band;
import com.tpp.DatabaseProject.repository.BandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BandService {

    @Autowired
    private BandsRepository bandRepository;

    public List<Band> getAllBands() {
        return bandRepository.findAll();
    }

    public Optional<Band> findBandById(Integer id) {
        return bandRepository.findById(id);
    }

    public void saveBand(Band band) {
        bandRepository.save(band);
    }

    public void updateBand(Band updatedBand) {
        Band existingBand = bandRepository.findById(updatedBand.getId())
                .orElseThrow(() -> new IllegalArgumentException("Band not found"));

        existingBand.setName(updatedBand.getName());
        existingBand.setGenre(updatedBand.getGenre());
        bandRepository.save(existingBand);
    }

    public void deleteBandById(Integer id) {
        bandRepository.deleteById(id);
    }
}
