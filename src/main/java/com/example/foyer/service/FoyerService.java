package com.example.foyer.service;

import com.example.foyer.model.Foyer;

import java.util.Optional;

public interface FoyerService {
    public Foyer addFoyer(Foyer foyer);
    public Optional<Foyer> findFoyerById(Long id);
    public void deleteFoyer(Long id);
    public Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite);

}
