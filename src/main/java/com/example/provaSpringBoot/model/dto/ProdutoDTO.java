package com.example.provaSpringBoot.model.dto;

import com.example.provaSpringBoot.model.entity.Fornecedor;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;

@Data
public class ProdutoDTO {

    private String nome;

    @Positive
    private Double preco;
    @Positive
    private Integer quantidade;

    private List<Fornecedor> fornecedores;
}
