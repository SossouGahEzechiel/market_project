package com.example.deb_projet.controller;

import com.example.deb_projet.models.Category;
import com.example.deb_projet.models.Produit;
import com.example.deb_projet.service.CategoryService;
import com.example.deb_projet.service.ProduitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("title","Liste des produits");
        model.addAttribute("produits",produitService.all());
        return "produit/index";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("title","Ajouter un nouveau produit");
        model.addAttribute("categories", categoryService.all());
        return  "produit/create";
    }

    @PostMapping(value = "store")
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
        model.addAttribute("title","Voir les détails d'un produit");
        model.addAttribute("produit",produitService.get(id));
        return "produit/show";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable("id") int id,Model model){
        model.addAttribute("title","Modifier les détails d'un produit");
        model.addAttribute("categories",categoryService.all());
        model.addAttribute("produit",produitService.get(id));
        return "produit/edit";
    }
    
    @PostMapping("{id}/update")
    public String update(@ModelAttribute("produit") Produit produit_updated){
        produitService.insert(produit_updated);
        return "redirect:/produit/index";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable("id") int id){
        produitService.destroy(id);
        return "redirect:/produit/index";
    }

    @GetMapping("{id}/approvisionnement/create")
    public String createApprovisionnement(@PathVariable("id") int id, Model model){
        model.addAttribute("produit",produitService.get(id));
        return "approvisionnement/create";
    }

    @GetMapping("{id}/approvisionnement/index")
    public String ListApprovisionnement(@PathVariable("id") int id, Model model){
        model.addAttribute("title","Liste des approvisionnements d'un produit");
        model.addAttribute("produit",produitService.get(id));
        model.addAttribute("approvisionnements",produitService.get(id).getApprovisionnements());
        return "approvisionnement/index_of_produit";
    }

    @GetMapping("")
    public String exemple(Model model){
        model.addAttribute("produits", produitService.all());
        return "commande";
    }

    @PostMapping("search")
    public String search(Model model,@RequestParam("research") String research){
        model.addAttribute("produits", produitService.searcher(research));
        model.addAttribute("title", "Resultat des recherche");
        return "produit/index";
    }
}