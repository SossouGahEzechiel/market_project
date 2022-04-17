package com.example.deb_projet.service;

import com.example.deb_projet.models.Category;
import com.example.deb_projet.models.Produit;
import com.example.deb_projet.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    @Autowired
    ProduitRepository produitRepository;

    // Méthode de récupération d'un produit
    public List<Produit> all() {
        /*Produit produit = new Produit();
        Category category = new Category();
        category.setId(2);
        produit.setCategory(category);
        return produitRepository.findAll(Example.of(produit));*/
        return produitRepository.findByCategoryNotNull();
    }

    // Méthode d'insertion dans la base de donnée (Simple insertion et mise à jour de donneés)
    public void insert(Produit produit) {
        System.out.println(produit.getId());
        produitRepository.save(produit);
    }

    // Méthode de récupération d'une instance de la classe
    public Produit get(int id) {
        Optional<Produit> optional = produitRepository.findById(id);
        if(optional.isPresent()){
            Produit produit;
            produit = optional.get();
            return produit;
        }

        throw new RuntimeException("An error occurred");
    }

    // Méthode de suppression dans la base de données
    public void destroy(int id) {
        Optional<Produit> produitOptional = produitRepository.findById(id);
        if(produitOptional.isPresent())
            produitRepository.deleteById(id);
    }

}
