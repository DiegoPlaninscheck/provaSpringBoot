package com.example.provaSpringBoot.controller;

import com.example.provaSpringBoot.model.dto.ProdutoDTO;
import com.example.provaSpringBoot.model.entity.Produto;
import com.example.provaSpringBoot.service.ProdutoService;
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
@RequestMapping("/prova/produto")
public class ProdutoController {

    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
        if (!produtoService.existsById(id)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        return ResponseEntity.ok(produtoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        BeanUtils.copyProperties(produtoDTO, produto);
        return ResponseEntity.ok(produtoService.save(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@Valid @RequestBody ProdutoDTO produtoDTO, @PathVariable(name = "id") Long id) {
        if (!produtoService.existsById(id)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        Produto produto = produtoService.findById(id).get();
        BeanUtils.copyProperties(produtoDTO, produto);
        produto.setId(id);
        return ResponseEntity.ok(produtoService.save(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id) {
        if (!produtoService.existsById(id)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        produtoService.deleteById(id);
        return ResponseEntity.ok("Deletado com sucesso!");
    }

}
