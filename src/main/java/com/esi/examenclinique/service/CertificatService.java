package com.esi.examenclinique.service;

import com.esi.examenclinique.entity.Certificat;
import com.esi.examenclinique.entity.ExamenClinique;
import com.esi.examenclinique.repository.CertificatRepository;
import com.esi.examenclinique.repository.ExamenCliniqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificatService {
    @Autowired
    private CertificatRepository certificatRepository;
    @Autowired
    private ExamenCliniqueRepository examenCliniqueRepository;

    public ExamenClinique getECById(Long idEC){
        return examenCliniqueRepository.findById(idEC).orElse(null);
    }


    // POST
    public Certificat saveCertificat(Certificat certificat) {
        ExamenClinique ec =  getECById(certificat.getId());
        certificat.setExamenClinique(ec);
        ec.setCertificat(certificat);
        examenCliniqueRepository.save(ec);
        return certificatRepository.save(certificat);
    }

/*    public List<Certificat> saveCertificats(List<Certificat> certificats) {
        return certificatRepository.saveAll(certificats);
    }*/

    // GET
    public List<Certificat> getCertificats() {
        return certificatRepository.findAll();
    }

    public Certificat getCertificatById(Long id) {
        return certificatRepository.findById(id).orElse(null);
    }

    public Certificat getCertificatByTitre(String titre) {
        return certificatRepository.findByTitre(titre);
    }

    // PUT
    public Certificat updateCertificat(Certificat certificat) {
        Certificat existingCertificat = certificatRepository.findById(certificat.getId()).orElse(null);
        existingCertificat.setTitre(certificat.getTitre());
        existingCertificat.setZonetxt(certificat.getZonetxt());
        existingCertificat.setExamenClinique(certificat.getExamenClinique());
        return certificatRepository.save(existingCertificat);
    }

    // DELETE
    public String deleteCertificat(Long idCert) {
        ExamenClinique ec =  getECById(idCert);
        ec.setCertificat(null);
        certificatRepository.deleteById(idCert);
        return "Certificat " + idCert + " supprimé !! ";
    }

}
