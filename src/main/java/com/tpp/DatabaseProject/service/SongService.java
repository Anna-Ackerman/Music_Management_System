package com.tpp.DatabaseProject.service;

import com.tpp.DatabaseProject.models.Song;
import com.tpp.DatabaseProject.repository.SongsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    @Autowired
    private SongsRepository songRepository;

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Optional<Song> findSongById(Integer id) {
        return songRepository.findById(id);
    }

    public void saveSong(Song song) {
        songRepository.save(song);
    }

    public void updateSong(Song updatedSong) {
        Song existingSong = songRepository.findById(updatedSong.getId())
                .orElseThrow(() -> new IllegalArgumentException("Song not found"));

        existingSong.setName(updatedSong.getName());
        existingSong.setBand(updatedSong.getBand());
        songRepository.save(existingSong);
    }

    public void deleteSongById(Integer id) {
        songRepository.deleteById(id);
    }
}
