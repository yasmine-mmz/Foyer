package com.example.foyer.repository;

import com.example.foyer.model.Chambre;
import com.example.foyer.model.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChambreRepository extends  JpaRepository<Chambre, Long> {
    @Query("SELECT c FROM Chambre c WHERE c.typeC = :type " +
            "AND c.bloc.foyer.universite.nomUniversite = :nomUniversite " +
            "AND c.idChambre NOT IN (SELECT r.chambre.idChambre FROM Reservation r WHERE r.anneeUniversitaire = :anneeUniversitaire)")
    List<Chambre> findNonReservedChambresByUniversiteAndType(@Param("nomUniversite") String nomUniversite,
                                                             @Param("type") TypeChambre type);
    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typeC = :typeC")
    List<Chambre> findByBlocAndTypeJPQL(@Param("idBloc") long idBloc, @Param("typeC") TypeChambre typeC);
    List<Chambre> findByBloc_IdBlocAndTypeC(long idBloc, TypeChambre typeC);
}
