package com.example.deb_projet.service;

import com.example.deb_projet.models.Produit;
import com.example.deb_projet.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    @Autowired
    ProduitRepository produitRepository;

    public List<Produit> all() {
        return produitRepository.findByCategoryNotNull();
    }

    public void insert(Produit produit) {
        produitRepository.save(produit);
    }

    public Produit get(int id) {
        Optional<Produit> optional = produitRepository.findById(id);
        if(optional.isPresent()){
            Produit produit;
            produit = optional.get();
            return produit;
        }

        throw new RuntimeException("An error occurred");
    }

    public void destroy(int id) {
        Optional<Produit> produitOptional = produitRepository.findById(id);
        if(produitOptional.isPresent())
            produitRepository.deleteById(id);
    }

    public List<Produit> searcher(String req){
        return produitRepository.findByLibIsContaining(req);
    }

    public List<Produit> toProvide(){
        List<Produit> produit_list = new ArrayList<>();
        List<Produit> produits = produitRepository.findByCategoryNotNull();
        produits.forEach(produit -> {
            if(produit.getQteSeuil() >= produit.getQteStock())
            produit_list.add(produit);
        });
        return produit_list;
    }
    
    public List<Produit> MoreThanZero(){
        return produitRepository.findByQteStockGreaterThan(0);
    }

}
