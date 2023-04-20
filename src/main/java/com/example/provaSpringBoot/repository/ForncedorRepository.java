package com.example.provaSpringBoot.repository;

import com.example.provaSpringBoot.model.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForncedorRepository extends JpaRepository<Fornecedor, Long> {
}
