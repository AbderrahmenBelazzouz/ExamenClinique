package com.esi.examenclinique.service;


import com.esi.examenclinique.entity.ExamenClinique;
import com.esi.examenclinique.repository.ExamenCliniqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamenCliniqueService {

    @Autowired
    private ExamenCliniqueRepository examenCliniqueRepository;

    //post methods
    public ExamenClinique saveExamenClinique(ExamenClinique examenClinique){
        return examenCliniqueRepository.save(examenClinique);
    }

    public List<ExamenClinique> saveExamensCliniques(List<ExamenClinique> examensCliniques){
        return examenCliniqueRepository.saveAll(examensCliniques);
    }

    //get methods
    public List<ExamenClinique> getExamensCliniques(){
        return examenCliniqueRepository.findAll();
    }

    public ExamenClinique getExamenCliniqueById(Long idEC){
        return examenCliniqueRepository.findById(idEC).orElse(null);
    }

    //delete method
    public String deleteExamenClinique(Long idEC){
        examenCliniqueRepository.deleteById(idEC);
        return "Examen Clinique Removed "+idEC;
    }

    //update method
    public ExamenClinique updateExamenClinique(ExamenClinique examenClinique){
        ExamenClinique exsistingEC = examenCliniqueRepository.findById(examenClinique.getId()).orElse(null);
        exsistingEC.setOrdonnance(examenClinique.getOrdonnance());
        return examenCliniqueRepository.save(exsistingEC);
    }
}
