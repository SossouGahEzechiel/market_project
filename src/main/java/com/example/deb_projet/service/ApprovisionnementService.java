package com.example.deb_projet.service;

import java.util.List;
import java.util.Optional;

import com.example.deb_projet.models.Approvisionnement;
import com.example.deb_projet.repository.ApprovisionnementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprovisionnementService {

  @Autowired
  ApprovisionnementRepository approvisionnementRepository;

  public List<Approvisionnement> all(){
    return approvisionnementRepository.findAll();
  }

  public void insert(Approvisionnement approvisionnement){
    approvisionnementRepository.save(approvisionnement);
  }

  public Approvisionnement get(int id){
    Optional<Approvisionnement> approvisionnement_optional ;
    approvisionnement_optional = approvisionnementRepository.findById(id);

    if(approvisionnement_optional.isPresent()){
      Approvisionnement approvisionnement;
      approvisionnement = approvisionnement_optional.get();
      return approvisionnement;
    }
    throw new RuntimeException("An error occurred");
  }

  public void destroy(int id){
    Optional<Approvisionnement> approvisionnementOptional = approvisionnementRepository.findById(id);
    if(approvisionnementOptional.isPresent())
      approvisionnementRepository.deleteById(id);
  }
}
