package com.esi.examenclinique.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RAPPORT_TBL")
public class Rapport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String zonetxt;

    @JsonIgnore
    @OneToOne
    @MapsId
    // pk of emp tbl is used as pk for ord tbl
    private ExamenClinique examenClinique;

    public Rapport(Long id) {
        this.id = id;
    }

    public Rapport(Long id, String titre, String zonetxt ) {
        this.id = id;
        this.titre = titre;
        this.zonetxt = zonetxt;
    }
}
