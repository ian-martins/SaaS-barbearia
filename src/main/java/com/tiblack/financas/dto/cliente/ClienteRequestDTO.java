package com.tiblack.financas.dto.cliente;

import java.util.UUID;

public record ClienteRequestDTO(UUID id, String nome, String telefone, String observacao) {
    
}
