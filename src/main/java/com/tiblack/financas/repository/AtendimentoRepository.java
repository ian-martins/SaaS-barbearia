package com.tiblack.financas.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiblack.financas.entity.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, UUID> {

}
