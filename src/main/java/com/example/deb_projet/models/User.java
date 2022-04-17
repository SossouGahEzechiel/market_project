package com.example.deb_projet.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private char sexe;
    private int num_tel;
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id",nullable = false)
    private Role role;

    @OneToMany
    @JoinColumn()
    private List<Sale> purchases;
}
