package com.tiblack.financas.dto;

public record ServicoUpdateDTO(Long id, String descricao, String valor, String observacao, boolean disponivel, String tempoEstimado) {
    
}
