package com.example.provaSpringBoot.controller;

import com.example.provaSpringBoot.model.dto.CartaoCreditoDTO;
import com.example.provaSpringBoot.model.entity.CartaoCredito;
import com.example.provaSpringBoot.service.CartaoCreditoService;
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
@RequestMapping("/prova/cartaocredito")
public class CartaoCreditoController {

    private CartaoCreditoService cartaoCreditoService;

    @GetMapping
    public ResponseEntity<List<CartaoCredito>> findAll() {
        return ResponseEntity.ok(cartaoCreditoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
        if (!cartaoCreditoService.existsById(id)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        return ResponseEntity.ok(cartaoCreditoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody CartaoCreditoDTO cartaoCreditoDTO) {
        CartaoCredito cartaoCredito = new CartaoCredito();
        BeanUtils.copyProperties(cartaoCreditoDTO, cartaoCredito);
        return ResponseEntity.ok(cartaoCreditoService.save(cartaoCredito));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@RequestBody CartaoCreditoDTO cartaoCreditoDTO, @PathVariable(name = "id") Long id) {
        if(!cartaoCreditoService.existsById(id)){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        CartaoCredito cartaoCredito = cartaoCreditoService.findById(id).get();

        BeanUtils.copyProperties(cartaoCreditoDTO, cartaoCredito);
        cartaoCredito.setId(id);
        return ResponseEntity.ok(cartaoCreditoService.save(cartaoCredito));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id) {
        if (!cartaoCreditoService.existsById(id)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        cartaoCreditoService.deleteById(id);
        return ResponseEntity.ok("Deletado com sucesso!");
    }
}
