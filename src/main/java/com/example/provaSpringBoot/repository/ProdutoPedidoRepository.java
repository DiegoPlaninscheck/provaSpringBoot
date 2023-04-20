package com.example.provaSpringBoot.repository;

import com.example.provaSpringBoot.model.entity.ProdutoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoPedidoRepository extends JpaRepository<ProdutoPedido, Long> {
}
