package com.example.foyer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    private String idReservation;
    private LocalDate anneeUniversitaire;
    private boolean estValide;

    @ManyToOne
    @JoinColumn(name = "idEtudiant")
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "idChambre")
    private Chambre chambre;

    public void setNumReservation(String s) {
    }
}
