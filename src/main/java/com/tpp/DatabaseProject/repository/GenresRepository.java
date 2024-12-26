package com.tpp.DatabaseProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tpp.DatabaseProject.models.Genre;

@Repository
public interface GenresRepository extends JpaRepository<Genre, Integer> {
}
