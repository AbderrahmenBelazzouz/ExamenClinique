package com.esi.examenclinique.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EXAMEN_CLINIQUE_TBL")
public class ExamenClinique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(mappedBy = "examenClinique", cascade = CascadeType.ALL)
    // owner of relation is ordonnance tbl, it holds forign key
    // if we delete em , ord will be removed
    @PrimaryKeyJoinColumn
    // pk of em tbl will be used as fk for ord tbl
    private Ordonnance ordonnance;

    @OneToOne(mappedBy = "examenClinique", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Rapport rapport;

    @OneToOne(mappedBy = "examenClinique", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Certificat certificat;

    @OneToOne(mappedBy = "examenClinique", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Evacuation evacuation;

    @OneToOne(mappedBy = "examenClinique", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Orientation orientation;


    public ExamenClinique(Long id) {
        this.id = id;
    }
}
