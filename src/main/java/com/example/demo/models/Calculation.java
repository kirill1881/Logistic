package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Calculation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;

    @Column
    private String theme;

    @Column
    private double price;


}
