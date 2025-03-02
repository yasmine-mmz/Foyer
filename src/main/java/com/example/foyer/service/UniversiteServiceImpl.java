package com.example.foyer.service;

import com.example.foyer.model.Universite;
import com.example.foyer.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UniversiteServiceImpl implements com.example.foyer.service.IUniversiteService {

    @Autowired
    private UniversiteRepository universiteRepository;

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
}