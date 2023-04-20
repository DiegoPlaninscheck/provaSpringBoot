package com.example.provaSpringBoot.controller;

import com.example.provaSpringBoot.model.dto.PedidoDTO;
import com.example.provaSpringBoot.model.entity.Pedido;
import com.example.provaSpringBoot.service.PedidoService;
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
@RequestMapping("/pedido")
public class PedidoController {

    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        return ResponseEntity.ok(pedidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
        if (!pedidoService.existsById(id)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        return ResponseEntity.ok(pedidoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> save(@Valid PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        BeanUtils.copyProperties(pedidoDTO, pedido);
        return ResponseEntity.ok(pedidoService.save(pedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@Valid PedidoDTO pedidoDTO, @PathVariable(name = "id") Long id) {
        if (!pedidoService.existsById(id)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        Pedido pedido = pedidoService.findById(id).get();
        BeanUtils.copyProperties(pedidoDTO, pedido);
        pedido.setId(id);
        return ResponseEntity.ok(pedidoService.save(pedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id) {
        if (!pedidoService.existsById(id)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        pedidoService.deleteById(id);
        return ResponseEntity.ok("Deletado com sucesso!");
    }
}
