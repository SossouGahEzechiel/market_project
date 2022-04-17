package com.example.deb_projet.controller;


import com.example.deb_projet.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RoleController {

    @Autowired
    RoleService roleService;
}
