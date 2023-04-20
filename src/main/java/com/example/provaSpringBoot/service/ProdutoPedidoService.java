package com.example.provaSpringBoot.service;

import com.example.provaSpringBoot.model.entity.ProdutoPedido;
import com.example.provaSpringBoot.repository.ProdutoPedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutoPedidoService {
    private ProdutoPedidoRepository pedidoRepository;

    public List<ProdutoPedido> findAll() {
        return pedidoRepository.findAll();
    }

    public <S extends ProdutoPedido> S save(S entity) {
        return pedidoRepository.save(entity);
    }

    public Optional<ProdutoPedido> findById(Long aLong) {
        return pedidoRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return pedidoRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        pedidoRepository.deleteById(aLong);
    }
}
