package com.example.provaSpringBoot.model.dto;

import com.example.provaSpringBoot.model.entity.Endereco;
import com.example.provaSpringBoot.model.entity.Pedido;
import lombok.Data;

@Data
public class EnderecoEntregaDTO {

    private Endereco endereco;

    private Pedido pedido;
}
