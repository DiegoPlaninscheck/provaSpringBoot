package com.example.provaSpringBoot.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CartaoCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numero;
}
