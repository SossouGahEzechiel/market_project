package com.example.deb_projet.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "produit_sale")
@NoArgsConstructor
@AllArgsConstructor
public class ProduitSale {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false)
  private int qte_produit;

  @Column(nullable = false)
  private LocalDate date_creat;

  @Column(nullable = true)
  private LocalDate date_vente;

  @ManyToOne
  @JoinColumn(name = "produit_id")
  Produit produit;

  @ManyToOne
  @JoinColumn(name = "sale_id")
  Sale sale;

  // @Transient
  // private int prix_total = this.qte_produit * this.getProduit().getPrix();
}
