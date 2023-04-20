package com.example.provaSpringBoot.controller;

import com.example.provaSpringBoot.model.dto.ClienteDTO;
import com.example.provaSpringBoot.model.entity.Cliente;
import com.example.provaSpringBoot.service.ClienteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/prova/cliente")
public class ClienteController {

    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
        if (!clienteService.existsById(id)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDTO, cliente);
        return ResponseEntity.ok(clienteService.save(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@Valid @RequestBody ClienteDTO clienteDTO, @PathVariable(name = "id") Long id) {
        if (!clienteService.existsById(id)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        Cliente cliente = clienteService.findById(id).get();

        clienteDTO.setEnderecos(cliente.getEnderecos());
        clienteDTO.setCartao(cliente.getCartao());

        BeanUtils.copyProperties(clienteDTO, cliente);
        cliente.setId(id);

        return ResponseEntity.ok(clienteService.save(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id) {
        if (!clienteService.existsById(id)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        clienteService.deleteById(id);
        return ResponseEntity.ok("Deletado com sucesso!");
    }

}
