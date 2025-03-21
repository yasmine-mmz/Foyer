package com.example.foyer.service;

import com.example.foyer.model.Reservation;
import java.util.List;

public interface IReservationService {
    List<Reservation> getAllReservations();
    Reservation getReservationById(String id);
    Reservation addReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);
    void deleteReservation(String id);
    public Reservation ajouterReservation (long idBloc, long cinEtudiant);

}