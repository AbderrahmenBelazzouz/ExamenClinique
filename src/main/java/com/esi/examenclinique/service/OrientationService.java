package com.esi.examenclinique.service;

import com.esi.examenclinique.entity.ExamenClinique;
import com.esi.examenclinique.entity.Orientation;
import com.esi.examenclinique.repository.ExamenCliniqueRepository;
import com.esi.examenclinique.repository.OrientationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrientationService {
    @Autowired
    private OrientationRepository orientationRepository;

    @Autowired
    private ExamenCliniqueRepository examenCliniqueRepository;

    public ExamenClinique getECById(Long idEC){
        return examenCliniqueRepository.findById(idEC).orElse(null);
    }

    // POST
    public Orientation saveOrientation(Orientation orientation) {
        ExamenClinique ec =  getECById(orientation.getId());
        orientation.setExamenClinique(ec);
        ec.setOrientation(orientation);
        examenCliniqueRepository.save(ec);
        return orientationRepository.save(orientation);
    }

/*    public List<Orientation> saveOrientations(List<Orientation> orientations) {
        return orientationRepository.saveAll(orientations);
    }*/

    // GET
    public List<Orientation> getOrientations() {
        return orientationRepository.findAll();
    }

    public Orientation getOrientationById(Long id) {
        return orientationRepository.findById(id).orElse(null);
    }

    public Orientation getOrientationByTitre(String titre) {
        return orientationRepository.findByTitre(titre);
    }

    // PUT
    public Orientation updateOrientation(Orientation orientation) {
        Orientation existingOrientation = orientationRepository.findById(orientation.getId()).orElse(null);
        // existingOrientation.setTitre(orientation.getTitre());
        existingOrientation.setZonetxt(orientation.getZonetxt());
        existingOrientation.setExamenClinique(orientation.getExamenClinique());
        return orientationRepository.save(existingOrientation);
    }

    // DELETE
    public String deleteOrientation(Long idOrien) {
        ExamenClinique ec =  getECById(idOrien);
        ec.setOrientation(null);
        orientationRepository.deleteById(idOrien);
        return "Orientation " + idOrien + " supprimé !! ";
    }

}
