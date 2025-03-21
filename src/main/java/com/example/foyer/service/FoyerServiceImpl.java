package com.example.foyer.service;

import com.example.foyer.model.Foyer;
import com.example.foyer.model.Universite;
import com.example.foyer.repository.FoyerRepository;
import com.example.foyer.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoyerServiceImpl {

    private final FoyerRepository foyerRepository;

    @Autowired
    public FoyerServiceImpl(FoyerRepository foyerRepository) {
        this.foyerRepository = foyerRepository;
    }
    @Autowired
    private UniversiteRepository universiteRepository;

    //Save (Add or Update) a Foyer
    public Foyer addFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    //Find a Foyer by ID
    public Optional<Foyer> findFoyerById(Long id) {
        return foyerRepository.findById(id);
    }
    //Delete a Foyer by ID
    public void deleteFoyer(Long id) {
        foyerRepository.deleteById(id);
    }
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Optional<Universite> universiteOpt = universiteRepository.findById(idUniversite);
        if (universiteOpt.isPresent()) {
            Universite universite = universiteOpt.get();
            foyer.setUniversite(universite);
            foyer.getBlocs().forEach(bloc -> bloc.setFoyer(foyer));
            return foyerRepository.save(foyer);
        }
        return null;
    }

}