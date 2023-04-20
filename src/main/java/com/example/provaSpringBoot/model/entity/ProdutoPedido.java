package com.example.provaSpringBoot.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProdutoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer quatidade;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private Pedido pedido;
}
