package com.example.deb_projet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProduitController {

    @GetMapping("/exemple")
    public String exString(Model model){
        model.addAttribute("title","Titre de la page");
        return "exemple";
    }
}
