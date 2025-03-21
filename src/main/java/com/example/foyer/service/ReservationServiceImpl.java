package com.example.foyer.service;

import com.example.foyer.model.Bloc;
import com.example.foyer.model.Chambre;
import com.example.foyer.model.Etudiant;
import com.example.foyer.model.Reservation;
import com.example.foyer.repository.BlocRepository;
import com.example.foyer.repository.EtudiantRepository;
import com.example.foyer.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements IReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private BlocRepository blocRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(String id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(String id) {
        reservationRepository.deleteById(id);
    }

    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire, String nomUniversite) {
        return reservationRepository.findByAnneeUniversitaireAndUniversite(anneeUniversitaire, nomUniversite);
    }
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        Optional<Bloc> blocOpt = blocRepository.findById(idBloc);
        Optional<Etudiant> etudiantOpt = etudiantRepository.findByCin(cinEtudiant);

        if (blocOpt.isPresent() && etudiantOpt.isPresent()) {
            Bloc bloc = blocOpt.get();
            Etudiant etudiant = etudiantOpt.get();

            Chambre chambreDisponible = bloc.getChambres().stream()
                    .filter(ch -> ch.getReservations().size() < ch.getCapaciteMax())
                    .findFirst()
                    .orElse(null);

            if (chambreDisponible != null) {
                Reservation reservation = new Reservation();
                reservation.setNumReservation(chambreDisponible.getId() + "-" + bloc.getNom() + "-2025");
                reservation.setEstValide(true);
                reservation.setChambre(chambreDisponible);
                reservation.setEtudiant(etudiant);
                return reservationRepository.save(reservation);
            }
        }
        return null;
    }

}