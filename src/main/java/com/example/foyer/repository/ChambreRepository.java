package com.example.foyer.repository;

import com.example.foyer.model.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChambreRepository extends  JpaRepository<Chambre, Long> {}