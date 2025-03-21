package com.example.foyer.service;


import com.example.foyer.model.Bloc;
import com.example.foyer.model.Chambre;
import com.example.foyer.repository.BlocRepository;
import com.example.foyer.repository.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BlocServiceImpl implements IBlocService {

    @Autowired
    private BlocRepository blocRepository;
    @Autowired
    private ChambreRepository chambreRepository;

    @Override
    public List<Bloc> getAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc getBlocById(Long id) {
        return blocRepository.findById(id).orElse(null);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBloc(Long id) {
        blocRepository.deleteById(id);
    }
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Optional<Bloc> blocOpt = blocRepository.findById(idBloc);
        List<Chambre> chambres = chambreRepository.findAllById(numChambre);

        if (blocOpt.isPresent() && !chambres.isEmpty()) {
            Bloc bloc = blocOpt.get();
            for (Chambre chambre : chambres) {
                chambre.setBloc(bloc);
            }
            chambreRepository.saveAll(chambres);
            return bloc;
        }
        return null;
    }

}