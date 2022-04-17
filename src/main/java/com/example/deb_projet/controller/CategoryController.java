package com.example.deb_projet.controller;

import com.example.deb_projet.models.Category;
import com.example.deb_projet.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("categories",categoryService.all());
        model.addAttribute("total", categoryService.countAll());
        return "category/index";
    }

    @GetMapping("create")
    public String create(){
        return "category/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute("category") Category category, RedirectAttributes attributes){
        categoryService.insert(category);
        return "redirect:/category/index";
    }

    @GetMapping("{id}/show")
    public String show(Model model,@PathVariable("id") int id){
        model.addAttribute(categoryService.get(id));
        return "category/show";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("category",categoryService.get(id));
        return "category/edit";
    }

    @PostMapping("{id}/update")
    public String update(@ModelAttribute("category") Category category, RedirectAttributes attributes){
        categoryService.insert(category);
        attributes.addAttribute("id",category.getId());
        return "redirect:/category/index";
    }

    @GetMapping("{id}/destroy")
    public String destroy(@PathVariable("id") int id){
        categoryService.destroy(id);
        return "redirect:/category/index";
    }

}