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

    @Column(unique = true)
    private int num_tel;

    @Column(unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String pseudo;

    @Column(nullable = false,unique = true)
    private String pswd;

    @ManyToOne
    @JoinColumn(name = "role_id",nullable = false)
    private Role role;

    @OneToMany
    @JoinColumn()
    private List<Sale> purchases;

    public User(String email, String nom, int num_tel, String prenom, char sexe,Role role,String pswd, String pseudo){
        this.email = email;
        this.nom =  nom;
        this.num_tel =  num_tel;
        this.prenom =  prenom;
        this.sexe =  sexe;
        this.role =  role;
        this.pswd = pswd;
        this.pseudo = pseudo;

    }
}
