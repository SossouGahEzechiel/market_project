package com.example.deb_projet.controller;

import com.example.deb_projet.service.CommandService;
import com.example.deb_projet.service.ProduitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("command")
public class CommandController {

    @Autowired
    ProduitService produitService;

    @GetMapping("produits")
    public String index(Model model){
        model.addAttribute("produits", produitService.all());
        model.addAttribute("title", "Liste des articles");
        return "user/produit_interface/index";
    }

    
    
    
    @GetMapping("{id}/create")
    public String create(Model model, @PathVariable("id") int id){
        model.addAttribute("produit",produitService.get(id));
        return "user/self/command/create";
    }

    @GetMapping("user/{id}/command")
    public String userCommandList(Model model){
        return "";
    }
}
