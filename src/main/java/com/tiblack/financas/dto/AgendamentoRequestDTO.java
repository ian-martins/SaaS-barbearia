package com.tiblack.financas.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record AgendamentoRequestDTO(LocalDateTime datahora, Long idServico, UUID idCliente) {
}
