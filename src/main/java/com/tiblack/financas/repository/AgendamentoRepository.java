package com.tiblack.financas.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiblack.financas.entity.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, UUID>{
    
}
