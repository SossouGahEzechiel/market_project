package com.example.deb_projet.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
// @ToString(exclude = "prod")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "lib",unique = true)
    private String cat_lib;

    @OneToMany(mappedBy = "category")
    List<Produit> produits;

    public int countProduit(){
        return this.getProduits().size();
    }
}
