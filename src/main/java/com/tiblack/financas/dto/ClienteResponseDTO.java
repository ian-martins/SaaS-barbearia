package com.tiblack.financas.dto;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * ClienteResponseDTO
 */
public record ClienteResponseDTO(UUID id, String nome, String telefone, String observacao, LocalDateTime data_criacao) {
}