package com.tiblack.financas.dto.agendamento;

import java.time.LocalDateTime;
import java.util.UUID;

import com.tiblack.financas.entity.enuns.StatusAgendamento;

public record AgendamentoResponseDTO(
        UUID id,
        LocalDateTime dataHora,
        String cliente,
        String servico,
        StatusAgendamento status) {

}
