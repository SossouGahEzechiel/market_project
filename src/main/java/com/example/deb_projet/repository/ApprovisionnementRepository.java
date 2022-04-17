package com.example.deb_projet.repository;

import com.example.deb_projet.models.Approvisionnement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovisionnementRepository extends JpaRepository<Approvisionnement, Integer>{
  
}
