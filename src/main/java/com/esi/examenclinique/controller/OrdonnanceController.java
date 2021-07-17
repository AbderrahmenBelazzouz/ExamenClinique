package com.esi.examenclinique.controller;

import com.esi.examenclinique.entity.Ordonnance;
import com.esi.examenclinique.service.OrdonnanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdonnanceController {
    @Autowired
    private OrdonnanceService ordonnanceService;

    @PostMapping("/addOrd")
    public Ordonnance addOrdonnance(@RequestBody Ordonnance ordonnance){
        return ordonnanceService.saveOrdonnance(ordonnance);
    }
    @PostMapping("/addOrds")
    public List<Ordonnance> addOrdonnances(@RequestBody List<Ordonnance> ordonnances){
        return ordonnanceService.saveOrdonnances(ordonnances);
    }

    @GetMapping("/Ords")
    public List<Ordonnance> getOrdonnances(){
        return ordonnanceService.getOrdonnances();
    }
    @GetMapping("/Ord/{id}")
    public Ordonnance getOrdonnanceById(@PathVariable(name = "id") Long idOrd){
        return ordonnanceService.getOrdonnanceById(idOrd);
    }

    @PutMapping("/updateOrd")
    public Ordonnance updateOrdonnance(@RequestBody Ordonnance ordonnance){

        return ordonnanceService.updateOrdonnance(ordonnance);
    }

    @DeleteMapping("/deleteOrd/{id}")
    public String deleteOrdonnance(@PathVariable(name = "id") Long idOrd){
        return ordonnanceService.deleteOrdonnance(idOrd);
    }
}
