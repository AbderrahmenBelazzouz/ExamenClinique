package com.esi.examenclinique.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "CERTIFICAT_TBL")
public class Certificat {
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
}
