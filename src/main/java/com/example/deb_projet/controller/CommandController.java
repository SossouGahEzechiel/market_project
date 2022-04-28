package com.example.deb_projet.controller;

import com.example.deb_projet.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("command")
public class CommandController {

    // @Autowired
    // CommandService commandService;

    // @GetMapping("index")
    // public String index(Model model){
    //     model.addAttribute("commands", commandService.all());
    //     return "command/index";
    // }

    // @GetMapping("user/{id}/command")
    // public String userCommandList(Model model){
    //     return "";
    // }
}
