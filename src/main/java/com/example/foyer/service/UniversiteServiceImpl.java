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
public class UniversiteServiceImpl implements com.example.foyer.service.IUniversiteService {

    @Autowired
    private UniversiteRepository universiteRepository;
    @Autowired
    private FoyerRepository foyerRepository;

    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite getUniversiteById(Long id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public void deleteUniversite(Long id) {
        universiteRepository.deleteById(id);
    }



        public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
            Optional<Foyer> foyerOpt = foyerRepository.findById(idFoyer);
            Universite universite = universiteRepository.findByNom(nomUniversite);

            if (foyerOpt.isPresent() && universite != null) {
                Foyer foyer = foyerOpt.get();
                universite.setFoyer(foyer);
                return universiteRepository.save(universite);
            }
            return null; // Gérer les erreurs
        }
    }

