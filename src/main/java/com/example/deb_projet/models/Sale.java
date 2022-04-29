package com.example.deb_projet.models;

import javax.persistence.*;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "sales")
@ToString(exclude = {"user","registrations"})
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate sale_date;
    private float total_amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
        @JoinTable(name = "produit_sale",
        joinColumns  = @JoinColumn(name = "sale_id"),
        inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
    List<Produit> produits;

    @OneToMany(mappedBy = "sale")
    List<ProduitSale> registrations;
}
