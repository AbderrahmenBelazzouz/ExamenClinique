package com.esi.examenclinique.service;

import com.esi.examenclinique.entity.ExamenClinique;
import com.esi.examenclinique.entity.Ordonnance;
import com.esi.examenclinique.repository.ExamenCliniqueRepository;
import com.esi.examenclinique.repository.OrdonnanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdonnanceService {
    @Autowired
    private OrdonnanceRepository ordonnanceRepository;
    @Autowired
    private ExamenCliniqueRepository examenCliniqueRepository;

    public ExamenClinique getECById(Long idEC){
        return examenCliniqueRepository.findById(idEC).orElse(null);
    }

    //post methods
    public Ordonnance saveOrdonnance(Ordonnance ordonnance){

        // Set child reference(ordonnance) in parent entity(EC)
        ExamenClinique ec =  getECById(ordonnance.getId());
        // Set parent reference(EC) in child entity(ordonnance)
        ordonnance.setExamenClinique(ec);
        ec.setOrdonnance(ordonnance);
        // Save Parent Reference (which will save the child as well)
        examenCliniqueRepository.save(ec);
        return ordonnanceRepository.save(ordonnance);

    }

    public List<Ordonnance> saveOrdonnances(List<Ordonnance> ordonnances){
        return ordonnanceRepository.saveAll(ordonnances);
    }

    //get methods
    public List<Ordonnance> getOrdonnances(){
        return ordonnanceRepository.findAll();
    }

    public Ordonnance getOrdonnanceById(Long idEC){
        return ordonnanceRepository.findById(idEC).orElse(null);
    }

    //delete method
    public String deleteOrdonnance(Long idOrd){
        ExamenClinique ec =  getECById(idOrd);
        ec.setOrdonnance(null);
        ordonnanceRepository.deleteById(idOrd);
        return "Ordonnance Removed "+idOrd;
    }

    //update method
    public Ordonnance updateOrdonnance(Ordonnance ordonnance){
        Ordonnance exsistingOrd = ordonnanceRepository.findById(ordonnance.getId()).orElse(null);
        exsistingOrd.setLente(ordonnance.getLente());
        exsistingOrd.setRapide(ordonnance.getRapide());
        exsistingOrd.setEpaisseure(ordonnance.getEpaisseure());
        exsistingOrd.setAiguillesJ(ordonnance.getAiguillesJ());
        exsistingOrd.setBandelettesJ(ordonnance.getBandelettesJ());
        exsistingOrd.setLancettesJ(ordonnance.getLancettesJ());
        exsistingOrd.setAutre(ordonnance.getAutre());
        exsistingOrd.setExamenClinique(ordonnance.getExamenClinique());

        return ordonnanceRepository.save(exsistingOrd);
    }
}
