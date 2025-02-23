package com.example.foyer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;
    private String nomEtudiant;
    private String prenomEt;
    private Long cin;
    private String ecole;
    private LocalDate dateNaissance;

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
    private List<Reservation> reservations;
}

