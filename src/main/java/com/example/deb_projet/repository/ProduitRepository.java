package com.example.deb_projet.repository;

import com.example.deb_projet.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer> {

    List<Produit> findByCategoryNotNull();

    // @Query("from Produit where lib like '%@req%'")
    // List<Produit> search(@Param("req") String req);

    List<Produit> findByLibIsContaining(String req);
}
