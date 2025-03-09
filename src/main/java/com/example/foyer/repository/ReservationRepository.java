package com.example.foyer.repository;

import com.example.foyer.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {
    @Query("SELECT r FROM Reservation r WHERE r.anneeUniversitaire = :anneeUniversitaire " +
            "AND r.chambre.bloc.foyer.universite.nomUniversite = :nomUniversite")
    List<Reservation> findByAnneeUniversitaireAndUniversite(@Param("anneeUniversitaire") Date anneeUniversitaire,
                                                            @Param("nomUniversite") String nomUniversite);

}