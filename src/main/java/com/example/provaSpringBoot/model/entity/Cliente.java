package com.example.provaSpringBoot.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String telefone;

    @OneToMany
    private List<Endereco> enderecos;

    @OneToOne
    private CartaoCredito cartao;
}
