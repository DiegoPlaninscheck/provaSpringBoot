package com.example.provaSpringBoot.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Double preco;
    @Column(nullable = false)
    private Integer quantidade;

    @ManyToMany
    private List<Fornecedor> fornecedores;
}
