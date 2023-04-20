package com.example.provaSpringBoot.service;

import com.example.provaSpringBoot.model.entity.Fornecedor;
import com.example.provaSpringBoot.repository.ForncedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FornecedorService {

    private ForncedorRepository forncedorRepository;

    public List<Fornecedor> findAll() {
        return forncedorRepository.findAll();
    }

    public <S extends Fornecedor> S save(S entity) {
        return forncedorRepository.save(entity);
    }

    public Optional<Fornecedor> findById(Long aLong) {
        return forncedorRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return forncedorRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        forncedorRepository.deleteById(aLong);
    }
}
