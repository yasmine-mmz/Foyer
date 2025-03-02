package com.example.foyer.service;

import com.example.foyer.model.Chambre;
import java.util.List;

public interface IChambreService {
    List<Chambre> getAllChambres();
    Chambre getChambreById(Long id);
    Chambre addChambre(Chambre chambre);
    Chambre updateChambre(Chambre chambre);
    void deleteChambre(Long id);
}