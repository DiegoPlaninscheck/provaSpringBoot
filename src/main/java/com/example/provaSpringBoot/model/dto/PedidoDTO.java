package com.example.provaSpringBoot.model.dto;

import com.example.provaSpringBoot.model.entity.Cliente;
import com.example.provaSpringBoot.model.entity.EnderecoEntrega;
import com.example.provaSpringBoot.model.entity.ProdutoPedido;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;

@Data
public class PedidoDTO {

    @Positive
    private Double valorTotal;

    private List<ProdutoPedido> produtos;

    private Cliente cliente;

    private EnderecoEntrega endereco;
}
