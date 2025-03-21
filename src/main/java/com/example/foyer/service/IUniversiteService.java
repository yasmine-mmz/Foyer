package com.example.foyer.service;

import com.example.foyer.model.Universite;
import java.util.List;

public interface IUniversiteService {
    List<Universite> getAllUniversites();
    Universite getUniversiteById(Long id);
    Universite addUniversite(Universite universite);
    Universite updateUniversite(Universite universite);
    void deleteUniversite(Long id);
    public Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite);

}