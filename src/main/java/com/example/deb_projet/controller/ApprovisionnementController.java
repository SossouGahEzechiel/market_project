package com.example.deb_projet.controller;

import com.example.deb_projet.models.Approvisionnement;
import com.example.deb_projet.models.Produit;
import com.example.deb_projet.service.ApprovisionnementService;

import com.example.deb_projet.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/approvisionnement")
public class ApprovisionnementController {

  @Autowired
  ApprovisionnementService approvisionnementService;
  @Autowired
  ProduitService produitService;

  @GetMapping("/index")
  public String index(Model model) {
    model.addAttribute("approvisionnements", approvisionnementService.all());
    model.addAttribute("title", "Liste des approvisionnements");
    return "approvisionnement/index";
  }

  // @GetMapping("create")
  // public String create(Model model){
  // model.addAttribute("title","Créer un nouveau produit");
  // model.addAttribute("produits",produitService.all());
  // return "approvisionnement/create";
  // }

  @PostMapping("store")
  public String store(Approvisionnement approvisionnement, RedirectAttributes attributes,
      @RequestParam("produit") int id) {
    approvisionnement.setDate_appr(LocalDate.now());
    Produit produit = produitService.get(id);
    produit.setQte_stock(produit.getQte_stock() + approvisionnement.getQte_appr());
    produitService.insert(produit);
    approvisionnement.setProduit(produit);
    approvisionnementService.insert(approvisionnement);
    attributes.addAttribute("id", produit.getId());
    // return "approvisionnement/{id}/show";
    return "redirect:/produit/{id}/approvisionnement/index";
  }

  // @GetMapping("{id}/show")
  // public String show(@PathVariable("id") int id, Model model){
  // model.addAttribute("approvisionnement",approvisionnementService.get(id));
  // model.addAttribute("title","Détails d'un approvisionnement");
  // return "approvisionnement/show";
  // }

  // @GetMapping("{id}/edit")
  // public String edit(@PathVariable("id") int id, Model model){
  // model.addAttribute("approvisionnement", approvisionnementService.get(id));
  // model.addAttribute("title","Modifier un approvisionnement");
  // return "approvisionnement/edit";
  // }

  @PostMapping("{id}/update")
  public String update(@ModelAttribute("approvisionnement") Approvisionnement approvisionnement,
      RedirectAttributes attributes) {
    approvisionnementService.insert(approvisionnement);
    attributes.addAttribute("id", approvisionnement.getId());
    return "redirect:/approvisionnement/{id}/show";
  }

  @GetMapping("{id}/delete")
  public String destroy(@PathVariable("id") int id) {
    approvisionnementService.destroy(id);
    return "redirect:/approvisionnement";
  }
}
