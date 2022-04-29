package com.example.deb_projet.repository;

import java.util.List;

import com.example.deb_projet.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Integer> {

  public List<Sale> findBySaleDateNull();

}
