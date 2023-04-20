package com.example.provaSpringBoot.repository;

import com.example.provaSpringBoot.model.entity.CartaoCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, Long> {
}
