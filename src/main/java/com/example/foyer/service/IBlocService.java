package com.example.foyer.service;

import com.example.foyer.model.Bloc;
import java.util.List;

public interface IBlocService {
    List<Bloc> getAllBlocs();
    Bloc getBlocById(Long id);
    Bloc addBloc(Bloc bloc);
    Bloc updateBloc(Bloc bloc);
    void deleteBloc(Long id);
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc);

}