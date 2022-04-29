package com.example.deb_projet.service;

import java.util.List;

import com.example.deb_projet.models.Produit;
import com.example.deb_projet.models.ProduitSale;
import com.example.deb_projet.models.Sale;
import com.example.deb_projet.repository.ProduitSaleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduitSaleService {
  
  @Autowired
  ProduitSaleRepository produitSaleRepository;

  public void insert(ProduitSale produitSale){
    produitSaleRepository.save(produitSale);
  }

  public List<ProduitSale> byProduits(Produit produit){
    return produitSaleRepository.findByProduit(produit);
  }

  public List<ProduitSale> bySales(Sale sale){
    return produitSaleRepository.findBySale(sale);
  }
}
