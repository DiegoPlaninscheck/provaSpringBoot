package com.example.provaSpringBoot.controller;

import com.example.provaSpringBoot.model.dto.EnderecoDTO;
import com.example.provaSpringBoot.model.entity.Endereco;
import com.example.provaSpringBoot.service.EnderecoService;
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
@RequestMapping("/prova/endereco")
public class EnderecoController {

    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll() {
        return ResponseEntity.ok(enderecoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
        if (!enderecoService.existsById(id)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        return ResponseEntity.ok(enderecoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDTO, endereco);
        return ResponseEntity.ok(enderecoService.save(endereco));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@RequestBody EnderecoDTO enderecoDTO, @PathVariable(name = "id") Long id) {
        if (!enderecoService.existsById(id)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        Endereco endereco = enderecoService.findById(id).get();
        BeanUtils.copyProperties(enderecoDTO, endereco);
        endereco.setId(id);
        return ResponseEntity.ok(enderecoService.save(endereco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id) {
        if (!enderecoService.existsById(id)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        enderecoService.deleteById(id);
        return ResponseEntity.ok("Deletado com sucesso!");
    }
}
