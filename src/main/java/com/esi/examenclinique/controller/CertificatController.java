package com.esi.examenclinique.controller;

import com.esi.examenclinique.entity.Certificat;
import com.esi.examenclinique.service.CertificatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CertificatController {

    @Autowired
    private CertificatService certificatService;

    // POST
    @PostMapping("/addCertificat")
    public Certificat addCertificat(@RequestBody Certificat certificat) {
        return certificatService.saveCertificat(certificat);
    }

/*    @PostMapping("/addCertificats")
    public List<Certificat> addCertificats(@RequestBody List<Certificat> certificats) {
        return certificatService.saveCertificats(certificats);
    }*/

    // GET
    @GetMapping("/certificats")
    public List<Certificat> findAllCertificats() {
        return certificatService.getCertificats();
    }

    @GetMapping("/certificatById/{id}")
    public Certificat findCertificatById(@PathVariable Long id) {
        return certificatService.getCertificatById(id);
    }

    @GetMapping("/certificat/{titre}")
    public Certificat findCertificatByTitre(@PathVariable String titre) {
        return certificatService.getCertificatByTitre(titre);
    }

    // PUT
    @PutMapping("/updateCert")
    public Certificat updateCertificat(@RequestBody Certificat certificat) {
        return certificatService.updateCertificat(certificat);
    }

    // DELETE
    @DeleteMapping("/deleteCert/{id}")
    public String deleteCertificat(@PathVariable Long id) {
        return certificatService.deleteCertificat(id);
    }

}
