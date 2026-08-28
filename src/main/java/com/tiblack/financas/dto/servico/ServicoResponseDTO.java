package com.tiblack.financas.dto.servico;

public record ServicoResponseDTO(Long id, String descricao, float valor, String observacao, boolean disponivel, String tempoEstimado) {

}
