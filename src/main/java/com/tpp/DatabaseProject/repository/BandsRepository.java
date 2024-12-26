package com.tpp.DatabaseProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tpp.DatabaseProject.models.Band;

@Repository
public interface BandsRepository extends JpaRepository<Band, Integer> {
}
