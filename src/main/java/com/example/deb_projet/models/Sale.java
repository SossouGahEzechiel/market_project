package com.example.deb_projet.models;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate sale_date;
    private float total_amount;

    @ManyToOne
    @JoinColumn(name = "user_id",updatable = false, nullable = false)
    private User user;

    //@ManyToMany
}
