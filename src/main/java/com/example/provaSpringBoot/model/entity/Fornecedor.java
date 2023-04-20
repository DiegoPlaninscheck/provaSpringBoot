package com.example.provaSpringBoot.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cnpj;

    @ManyToMany(mappedBy = "fornecedores", cascade = CascadeType.ALL)
    private List<Produto> produtos;

    @ManyToMany
    private List<Cliente> clientes;
}
