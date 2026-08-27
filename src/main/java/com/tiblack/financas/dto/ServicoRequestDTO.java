package com.tiblack.financas.dto;

public record ServicoRequestDTO(String descricao, float valor, String observacao, boolean disponivel, String tempoEstimado) {
    
}
