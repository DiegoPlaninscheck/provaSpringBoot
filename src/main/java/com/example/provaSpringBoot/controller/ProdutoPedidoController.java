package com.example.provaSpringBoot.controller;

import com.example.provaSpringBoot.model.dto.ProdutoPedidoDTO;
import com.example.provaSpringBoot.model.entity.ProdutoPedido;
import com.example.provaSpringBoot.service.ProdutoPedidoService;
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
@RequestMapping("/prova/produtoPedido")
public class ProdutoPedidoController {

    private ProdutoPedidoService produtoPedidoService;

    @GetMapping
    public ResponseEntity<List<ProdutoPedido>> findAll() {
        return ResponseEntity.ok(produtoPedidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
        if (!produtoPedidoService.existsById(id)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        return ResponseEntity.ok(produtoPedidoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody ProdutoPedidoDTO produtoPedidoDTO) {
        ProdutoPedido produtoPedido = new ProdutoPedido();
        BeanUtils.copyProperties(produtoPedidoDTO, produtoPedido);
        return ResponseEntity.ok(produtoPedidoService.save(produtoPedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@Valid @RequestBody ProdutoPedidoDTO produtoPedidoDTO, @PathVariable(name = "id") Long id) {
        if (!produtoPedidoService.existsById(id)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        ProdutoPedido produtoPedido = produtoPedidoService.findById(id).get();
        BeanUtils.copyProperties(produtoPedidoDTO, produtoPedido);
        produtoPedido.setId(id);
        return ResponseEntity.ok(produtoPedidoService.save(produtoPedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id) {
        if (!produtoPedidoService.existsById(id)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        produtoPedidoService.deleteById(id);
        return ResponseEntity.ok("Deletado com sucesso!");
    }

}
