package com.example.deb_projet.controller;


import com.example.deb_projet.models.Role;
import com.example.deb_projet.models.User;
import com.example.deb_projet.service.RoleService;
import com.example.deb_projet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("users", userService.all());
        return "user/index";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("roles", roleService.all());
        return "user/create";
    }

    @PostMapping("store")
    public String store(User user,@ModelAttribute("role") Role role){
        user.setPswd(passwordEncoder.encode(user.getPswd()));
        user.setRole(role);
        // Controle supplémentaire au besoin
        userService.insert(user);
        return "redirect:/user/index";
    }

    @GetMapping("{id}/show")
    public String show(@PathVariable("id") int id,Model model){
        model.addAttribute("user", userService.get(id));
        return "user/show";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable("id") int id,Model model){
        model.addAttribute("user", userService.get(id));
        return "user/edit";
    }

    @PostMapping("{id}/update")
    public String update(@ModelAttribute("user") User user,RedirectAttributes attributes){
        userService.insert(user);
        // Controle supplémentaire au besoin
        attributes.addAttribute("id", user.getId());
        return "redirect:/user/{id}/show";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable("id") int id){
        userService.destroy(id);
        return "redirect:/user/index";
    }
}
