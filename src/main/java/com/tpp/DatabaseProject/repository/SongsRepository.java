package com.tpp.DatabaseProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tpp.DatabaseProject.models.Song;

@Repository
public interface SongsRepository extends JpaRepository<Song, Integer> {
}
