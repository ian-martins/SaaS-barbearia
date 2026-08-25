package com.tiblack.financas.dto;

public record ServicoUpdateDTO(Long id, String descricao, float valor, String observacao, boolean disponivel, String tempoEstimado) {
    
}
