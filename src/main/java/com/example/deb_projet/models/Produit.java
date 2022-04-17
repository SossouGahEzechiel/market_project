package com.example.deb_projet.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "produits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String lib;
    private int prix;
    private int qte_seuil;
    private int qte_stock;
    private LocalDate date_creat;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @OneToMany
    List<Approvisionnement> approvisionnements;
}

