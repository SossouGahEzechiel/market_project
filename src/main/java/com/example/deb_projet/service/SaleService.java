package com.example.deb_projet.service;


import com.example.deb_projet.models.Sale;
import com.example.deb_projet.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    SaleRepository saleRepository;

    public List<Sale> all(){
        return saleRepository.findAll();
    }

    public void insert(Sale sale){
        saleRepository.save(sale);
    }

    public Sale get(int id){
        Optional<Sale> saleOptional = saleRepository.findById(id);
        if(saleOptional.isPresent()){
            Sale sale;
            sale = saleOptional.get();
            return sale;
        }

    throw new RuntimeException("An error occurred");
    }

    public void destroy(int id){
        Optional<Sale> saleOptional = saleRepository.findById(id);
        if(saleOptional.isPresent())
            saleRepository.deleteById(id);
    }
}
