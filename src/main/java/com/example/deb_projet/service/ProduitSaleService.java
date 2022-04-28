package com.example.deb_projet.service;

import com.example.deb_projet.models.ProduitSale;
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
}
