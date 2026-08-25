package com.tiblack.financas.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiblack.financas.entity.MovimentacaoFinanceira;

public interface MovimentacaoFinanceiraRepository extends JpaRepository<MovimentacaoFinanceira, UUID> {

}
