package com.example.provaSpringBoot.model.dto;

import com.example.provaSpringBoot.model.entity.CartaoCredito;
import com.example.provaSpringBoot.model.entity.Endereco;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.List;

@Data
public class ClienteDTO {

    private String nome;

    @Email
    private String email;

    private String telefone;

    private List<Endereco> enderecos;

    private CartaoCredito cartao;
}
