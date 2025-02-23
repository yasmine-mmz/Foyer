package com.example.foyer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;
    private String nomFoyer;
    private Long capaciteFoyer;

    @ManyToOne
    @JoinColumn(name = "idUniversite")
    private Universite universite;

    @OneToMany(mappedBy = "foyer", cascade = CascadeType.ALL)
    private List<Bloc> blocs;
}
