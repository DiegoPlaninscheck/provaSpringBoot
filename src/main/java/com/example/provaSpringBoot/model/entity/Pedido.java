package com.example.provaSpringBoot.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Double valorTotal;

    @OneToMany(mappedBy = "pedido")
    private List<ProdutoPedido> produtos;

    @ManyToOne
    private Cliente cliente;

    @OneToOne
    private EnderecoEntrega endereco;
}
