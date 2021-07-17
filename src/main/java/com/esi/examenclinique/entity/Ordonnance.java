package com.esi.examenclinique.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor @Entity
@Table(name = "ORDONNANCE_TBL")
public class Ordonnance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //insuline par voie sous-cutanee
    @OneToMany
    private List<DoseJour> rapide;
    @OneToMany
    private List<DoseJour> lente;

    //aiguilles pour stylo a insuline
    private int aiguillesJ; // 4 a/j
    private int epaisseure; // 8 mm

    // auto-surveillance glycemique
    private int lancettesJ;   // 6 l/j
    private int bandelettesJ; // 4 b/j

    //Autre medications
    private String autre;

    @JsonIgnore
    @OneToOne
    @MapsId
    // pk of emp tbl is used as pk for ord tbl
    private ExamenClinique examenClinique;

    public Ordonnance(Long id) {
        this.id = id;
    }

    public Ordonnance(Long id, List<DoseJour> rapide, List<DoseJour> lente,
                      int aiguillesJ, int epaisseure, int lancettesJ, int bandelettesJ, String autre) {
        this.id = id;
        this.rapide = rapide;
        this.lente = lente;
        this.aiguillesJ = aiguillesJ;
        this.epaisseure = epaisseure;
        this.lancettesJ = lancettesJ;
        this.bandelettesJ = bandelettesJ;
        this.autre = autre;
    }
}
