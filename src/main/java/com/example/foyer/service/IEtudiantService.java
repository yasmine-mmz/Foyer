package com.example.foyer.service;

import com.example.foyer.model.Etudiant;
import java.util.List;

public interface IEtudiantService {
    List<Etudiant> getAllEtudiants();
    Etudiant getEtudiantById(Long id);
    Etudiant addEtudiant(Etudiant etudiant);
    Etudiant updateEtudiant(Etudiant etudiant);
    void deleteEtudiant(Long id);
}