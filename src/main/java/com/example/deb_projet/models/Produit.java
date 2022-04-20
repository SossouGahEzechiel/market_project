package com.example.deb_projet.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "produits")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "category")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "lib")
    private String lib;
    private int prix;
    private int qte_seuil;
    private int qte_stock;

    @Column(updatable = false)
    private LocalDate date_creat;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @OneToMany(mappedBy = "produit")
    List<Approvisionnement> approvisionnements;
}