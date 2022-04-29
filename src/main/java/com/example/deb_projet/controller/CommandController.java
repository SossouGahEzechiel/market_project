package com.example.deb_projet.controller;

import java.time.LocalDate;

import com.example.deb_projet.models.Command;
import com.example.deb_projet.models.CommandLine;
import com.example.deb_projet.models.Produit;
import com.example.deb_projet.models.ProduitSale;
import com.example.deb_projet.models.Sale;
import com.example.deb_projet.service.CommandService;
import com.example.deb_projet.service.ProduitSaleService;
import com.example.deb_projet.service.ProduitService;
import com.example.deb_projet.service.SaleService;
import com.example.deb_projet.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("command")
public class CommandController {

    @Autowired
    ProduitService produitService;

    @Autowired
    UserService userService;

    @Autowired
    SaleService saleService;

    @Autowired
    ProduitSaleService produitSaleService;

    @GetMapping("produits")
    public String index(Model model) {
        model.addAttribute("produits", produitService.all());
        model.addAttribute("title", "Liste des articles");
        return "user/produit_interface/index";
    }

    // Action qui retourne la vue de création d'une commande à plusieurs produits
    @GetMapping("create")
    public String create(Model model) {
        return "user/produit_interface/shopping";
    }

    // Action qui retourne la vue de création d'une commande à un seul produit
    @GetMapping("{id}/create")
    public String create(Model model, @PathVariable("id") int id) {
        model.addAttribute("produit", produitService.get(id));
        return "user/self/command/create";
    }

    @PostMapping("{id}/store-one")
    public String store(CommandLine commandLine, @PathVariable("id") int id) {

        Produit produit = produitService.get(id);
        ProduitSale produitSale = new ProduitSale();
        Sale sale = new Sale();

        sale.setUser(userService.get(1));
        sale.setSale_date(LocalDate.now());
        sale.setTotal_amount(commandLine.getQte_produit() * produit.getPrix());
        saleService.insert(sale);

        produitSale.setDate_creat(LocalDate.now());
        produitSale.setQte_produit(commandLine.getQte_produit());
        produitSale.setProduit(produit);
        produitSale.setSale(sale);
        produitSaleService.insert(produitSale);

        produit.setQte_stock(produit.getQte_stock() - commandLine.getQte_produit());
        produitService.insert(produit);

        return "redirect:/command/produits";
    }

    @PostMapping("store-many")
    public void store(){

    }

    @GetMapping("user/{id}/command")
    public String userCommandList(Model model) {
        return "";
    }
}
