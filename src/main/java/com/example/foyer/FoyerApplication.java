package com.example.foyer;

import com.example.foyer.model.Foyer;
import com.example.foyer.model.Universite;
import com.example.foyer.repository.FoyerRepository;
import com.example.foyer.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoyerApplication implements CommandLineRunner {

    @Autowired
    private UniversiteRepository universiteRepository;
    @Autowired
    private FoyerRepository foyerRepository;

    public static void main(String[] args) {
        SpringApplication.run(FoyerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Universite universite = new Universite();
        universite.setNomUniversite("Université de Tunis");
        universite.setAdresse("Tunis, Tunisie");

        universiteRepository.save(universite);

        Foyer foyer = new Foyer();
        foyer.setNomFoyer("Foyer Central");
        foyer.setCapaciteFoyer(500L);
        foyer.setUniversite(universite);

        foyerRepository.save(foyer);

        System.out.println("Données insérées avec succès !");
    }
}

