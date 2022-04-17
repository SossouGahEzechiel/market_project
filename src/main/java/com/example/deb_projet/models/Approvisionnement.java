package com.example.deb_projet.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "approvionnements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Approvisionnement {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int qte_appr;
    private LocalDate date_appr;

    @ManyToOne
    @JoinColumn(name= "produit_id", insertable=false, updatable=false)
    private Produit produit;
    private int produit_id;
}
