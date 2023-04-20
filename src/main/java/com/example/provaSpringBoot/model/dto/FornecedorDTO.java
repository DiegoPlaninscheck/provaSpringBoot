package com.example.provaSpringBoot.model.dto;

import com.example.provaSpringBoot.model.entity.Cliente;
import com.example.provaSpringBoot.model.entity.Produto;
import lombok.Data;

import java.util.List;

@Data
public class FornecedorDTO {

    private String nome;

    private String cnpj;

    private List<Produto> produtos;

    private List<Cliente> clientes;
}
