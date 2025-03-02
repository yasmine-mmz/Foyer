package com.example.foyer.repository;

import com.example.foyer.model.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoyerRepository extends CrudRepository<Foyer, Long> {}