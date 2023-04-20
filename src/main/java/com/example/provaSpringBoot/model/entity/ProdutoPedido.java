package com.example.provaSpringBoot.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProdutoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer quantidade;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    @JsonIgnore
    private Pedido pedido;
}
