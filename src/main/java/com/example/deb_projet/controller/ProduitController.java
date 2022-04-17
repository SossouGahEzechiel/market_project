package com.example.deb_projet.controller;

import com.example.deb_projet.models.Category;
import com.example.deb_projet.models.Produit;
import com.example.deb_projet.service.CategoryService;
import com.example.deb_projet.service.ProduitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/produit")
public class ProduitController {

    @Autowired
    ProduitService produitService;
    @Autowired
    CategoryService categoryService;


    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("produits",produitService.all());
        return "produit/index";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("categories", categoryService.all());
        return  "produit/create";
    }

    @PostMapping("store")
    public String store(Produit produit, Model model,
         @ModelAttribute("category") Category category)
    {
        produit.setQte_stock(0);
        produit.setDate_creat(LocalDate.now());
        produit.setCategory(category);
        produitService.insert(produit);
        return "redirect:/produit/index";
    }

    @GetMapping("{id}/show")
    public String show(@PathVariable("id") int id,Model model){
        model.addAttribute("produit",produitService.get(id));
        return "produit/show";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable("id") int id,Model model){
        model.addAttribute("categories",categoryService.all());
        model.addAttribute("produit",produitService.get(id));
        // logger.info("\n\n+++++++++++++++++inside Update");
        return "produit/edit";
    }
    
    @PostMapping("{id}/update")
    public String update(@ModelAttribute("produit") Produit produit_updated, 
        RedirectAttributes attributes,
        //@PathVariable("id") int id,
        @ModelAttribute("category") Category category){
        System.out.println("JE suis ici");
        //Produit produit = produitService.get(id);
        //produit = produit_updated;
        produit_updated.setCategory(category);
        produitService.insert(produit_updated);
        attributes.addAttribute("id", produit_updated.getId());
        return "redirect:/produit/{id}/show";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable("id") int id){
        produitService.destroy(id);
        return "redirect:/produit/index";
    }

    @GetMapping("base")
    public String base(){
        return "base";
    }
}