package com.example.deb_projet.controller;

import com.example.deb_projet.repository.SaleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sale")
public class SaleController {

    @Autowired
    SaleRepository saleRepository;
}
