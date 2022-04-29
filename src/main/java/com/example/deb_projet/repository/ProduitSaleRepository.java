package com.example.deb_projet.repository;

import java.util.List;

import com.example.deb_projet.models.Produit;
import com.example.deb_projet.models.ProduitSale;
import com.example.deb_projet.models.Sale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ProduitSaleRepository extends JpaRepository<ProduitSale, Integer> {
  

  List<ProduitSale> findByProduit(Produit produit);
  
  List<ProduitSale> findBySale(Sale sale);

  // List<ProduitSale> findBySaleDate__enteNotNull(Sale sale);

}
