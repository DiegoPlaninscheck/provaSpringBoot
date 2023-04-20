package com.example.provaSpringBoot.controller;

import com.example.provaSpringBoot.model.dto.PedidoDTO;
import com.example.provaSpringBoot.model.entity.EnderecoEntrega;
import com.example.provaSpringBoot.model.entity.Pedido;
import com.example.provaSpringBoot.model.entity.ProdutoPedido;
import com.example.provaSpringBoot.service.EnderecoEntregaService;
import com.example.provaSpringBoot.service.PedidoService;
import com.example.provaSpringBoot.service.ProdutoPedidoService;
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
@RequestMapping("/prova/pedido")
public class PedidoController {

    private PedidoService pedidoService;
    private EnderecoEntregaService enderecoEntregaService;

    private ProdutoPedidoService produtoPedidoService;

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
    public ResponseEntity<Object> save(@Valid @RequestBody PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        BeanUtils.copyProperties(pedidoDTO, pedido);

        System.out.println(pedido);

        Pedido pedidoSalvo = pedidoService.save(pedido);

        for(ProdutoPedido produtoPedido : pedidoSalvo.getProdutos()){
            produtoPedido.setPedido(pedidoSalvo);

            produtoPedidoService.save(produtoPedido);
        }

        EnderecoEntrega enderecoEntrega = pedidoSalvo.getEndereco();

        enderecoEntrega.setPedido(pedidoSalvo);

        enderecoEntregaService.save(enderecoEntrega);

        return ResponseEntity.ok(pedidoService.save(pedidoSalvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@Valid @RequestBody PedidoDTO pedidoDTO, @PathVariable(name = "id") Long id) {
        if (!pedidoService.existsById(id)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        Pedido pedido = pedidoService.findById(id).get();

        pedidoDTO.setCliente(pedido.getCliente());

        pedidoDTO.setEndereco(pedido.getEndereco());

        pedidoDTO.setProdutos(pedido.getProdutos());

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
