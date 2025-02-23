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
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;
    private String nomBloc;
    private Long capaciteBloc;

    @ManyToOne
    @JoinColumn(name = "idFoyer")
    private Foyer foyer;

    @OneToMany(mappedBy = "bloc", cascade = CascadeType.ALL)
    private List<Chambre> chambres;
}
