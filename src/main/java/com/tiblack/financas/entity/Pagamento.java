package com.tiblack.financas.entity;

import java.time.LocalDateTime;

import com.tiblack.financas.entity.enuns.FormaPagamento;

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
@Table(name = "pagamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {

    //Colunas
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private float valor;
    private LocalDateTime dataPagamento;

    //Relacinameno com outras tabelas

    //Outros
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

}