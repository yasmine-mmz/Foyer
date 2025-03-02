package com.example.foyer.controller;

import com.example.foyer.model.Foyer;
import com.example.foyer.service.FoyerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/foyers")
public class FoyerController {

    private final FoyerServiceImpl foyerService;

    @Autowired
    public FoyerController(FoyerServiceImpl foyerService) {
        this.foyerService = foyerService;
    }

    //Add a new Foyer
    @PostMapping("/add")
    public Foyer createFoyer(@RequestBody Foyer foyer) {
        return foyerService.addFoyer(foyer);
    }

    //Find a Foyer by ID
    @GetMapping("/find/{id}")
    public Optional<Foyer> getFoyerById(@PathVariable Long id) {
        return foyerService.findFoyerById(id);
    }

    //Delete a Foyer by ID
    @DeleteMapping("/delete/{id}")
    public String deleteFoyer(@PathVariable Long id) {
        foyerService.deleteFoyer(id);
        return "Foyer deleted successfully!";
    }
}
