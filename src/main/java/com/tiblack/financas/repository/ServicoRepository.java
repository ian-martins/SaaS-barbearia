package com.tiblack.financas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiblack.financas.entity.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
    
}
