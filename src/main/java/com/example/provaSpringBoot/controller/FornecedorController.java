package com.example.provaSpringBoot.controller;

import com.example.provaSpringBoot.model.dto.FornecedorDTO;
import com.example.provaSpringBoot.model.entity.Fornecedor;
import com.example.provaSpringBoot.service.FornecedorService;
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
@RequestMapping("/fornecedor")
public class FornecedorController {

    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List<Fornecedor>> findAll() {
        return ResponseEntity.ok(fornecedorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
        if (!fornecedorService.existsById(id)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        return ResponseEntity.ok(fornecedorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> save(FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = new Fornecedor();
        BeanUtils.copyProperties(fornecedorDTO, fornecedor);
        return ResponseEntity.ok(fornecedorService.save(fornecedor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(FornecedorDTO fornecedorDTO, @PathVariable(name = "id") Long id) {
        if (!fornecedorService.existsById(id)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        Fornecedor fornecedor = fornecedorService.findById(id).get();
        BeanUtils.copyProperties(fornecedorDTO, fornecedor);
        fornecedor.setId(id);
        return ResponseEntity.ok(fornecedorService.save(fornecedor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id) {
        if (!fornecedorService.existsById(id)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        fornecedorService.deleteById(id);
        return ResponseEntity.ok("Deletado com sucesso!");
    }

}