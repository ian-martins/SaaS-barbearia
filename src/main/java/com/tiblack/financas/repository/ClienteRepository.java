package com.tiblack.financas.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiblack.financas.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

}
