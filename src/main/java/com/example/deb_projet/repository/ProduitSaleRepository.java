package com.example.deb_projet.repository;

import com.example.deb_projet.models.ProduitSale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ProduitSaleRepository extends JpaRepository<ProduitSale, Integer> {
  
}
