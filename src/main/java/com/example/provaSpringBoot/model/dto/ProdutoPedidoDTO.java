package com.example.provaSpringBoot.model.dto;

import com.example.provaSpringBoot.model.entity.Pedido;
import com.example.provaSpringBoot.model.entity.Produto;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProdutoPedidoDTO {

    @Positive
    private Integer quatidade;

    private Produto produto;

    private Pedido pedido;
}
