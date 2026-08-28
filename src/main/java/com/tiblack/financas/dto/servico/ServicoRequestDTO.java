package com.tiblack.financas.dto.servico;

public record ServicoRequestDTO(Long id, String descricao, float valor, String observacao, boolean disponivel, String tempoEstimado) {
    
}
