package com.example.foyer.repository;

import com.example.foyer.model.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Long> {
    Universite findByNom(String nomUniversite);
}