package com.example.provaSpringBoot.repository;

import com.example.provaSpringBoot.model.entity.EnderecoEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoEntregaRepository extends JpaRepository<EnderecoEntrega, Long> {
}
