package com.tiblack.financas.dto.agendamento;

import java.time.LocalDateTime;
import java.util.UUID;

import com.tiblack.financas.entity.enuns.StatusAgendamento;

public record AgendamentoRequestDTO(UUID id, LocalDateTime datahora, Long servico, UUID cliente,
        StatusAgendamento status) {
}
