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
            List<Produit> produitList = categoryOptional.get().getProduits();
            for (Produit produit : produitList) {
                produit.setCategory(null);
                produitService.insert(produit);
            }

            categoryRepository.deleteById(id);
        }
    }

    public long countAll(){
        return categoryRepository.count();
    }
}


