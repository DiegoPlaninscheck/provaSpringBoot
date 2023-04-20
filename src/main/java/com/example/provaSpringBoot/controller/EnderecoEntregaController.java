package com.example.provaSpringBoot.controller;

import com.example.provaSpringBoot.model.dto.EnderecoEntregaDTO;
import com.example.provaSpringBoot.model.entity.EnderecoEntrega;
import com.example.provaSpringBoot.service.EnderecoEntregaService;
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
@RequestMapping("/prova/enderecoEntrega")
public class EnderecoEntregaController {

    private EnderecoEntregaService enderecoEntregaService;

    @GetMapping
    public ResponseEntity<List<EnderecoEntrega>> findAll() {
        return ResponseEntity.ok(enderecoEntregaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
        if (!enderecoEntregaService.existsById(id)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        return ResponseEntity.ok(enderecoEntregaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody EnderecoEntregaDTO enderecoEntregaDTO) {
        EnderecoEntrega enderecoEntrega = new EnderecoEntrega();
        BeanUtils.copyProperties(enderecoEntregaDTO, enderecoEntrega);
        return ResponseEntity.ok(enderecoEntregaService.save(enderecoEntrega));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@RequestBody EnderecoEntregaDTO enderecoEntregaDTO, @PathVariable(name = "id") Long id) {
        if (!enderecoEntregaService.existsById(id)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        EnderecoEntrega enderecoEntrega = enderecoEntregaService.findById(id).get();
        BeanUtils.copyProperties(enderecoEntregaDTO, enderecoEntrega);
        enderecoEntrega.setId(id);
        return ResponseEntity.ok(enderecoEntregaService.save(enderecoEntrega));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id) {
        if (!enderecoEntregaService.existsById(id)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        enderecoEntregaService.deleteById(id);
        return ResponseEntity.ok("Deletado com sucesso!");
    }

}
