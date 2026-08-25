package com.tiblack.financas.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.tiblack.financas.entity.enuns.TipoMovimentacao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mov_financeira")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovimentacaoFinanceira {

    //Colunas
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private BigDecimal valor;
    private String descricao;
    private LocalDateTime dataHora;
    
    //Outros
    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipo;

}
