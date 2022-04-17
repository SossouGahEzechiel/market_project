package com.example.deb_projet.service;

import com.example.deb_projet.models.Category;
import com.example.deb_projet.models.Produit;
import com.example.deb_projet.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProduitService produitService;

    public List<Category> all(){
        return categoryRepository.findAll();
    }

    public void insert(Category category){
        categoryRepository.save(category);
    }

    public Category get(int id){
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isPresent()) {
            Category category;
            return category = categoryOptional.get();
        }
        throw new RuntimeException("An error occured");
    }

    public void destroy(int id){
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            Category category;
            category = categoryOptional.get();
            List<Produit> produitList = category.getProduits();
            //System.out.println(categoryOptional.get().getProduits().size());
            //System.out.println(produitList);
            for (Produit produit : produitList) {
                System.out.println("Je rentre dans la boucle");
                //System.out.println("+++++ Avant"+produit.getCategory().toString()+"++++++");
                produit.setCategory(null);
                produitService.insert(produit);
                //System.out.println("+++++ Après"+produit.getCategory().toString()+"++++++");
            }

            categoryRepository.deleteById(id);
            System.out.println("ok c'est fait");
        }
    }

    public long countAll(){
        return categoryRepository.count();
    }
}


