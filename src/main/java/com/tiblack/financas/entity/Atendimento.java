package com.tiblack.financas.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "atendimento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Atendimento {
    
    // Colunas
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;

    @Column(name = "valor_cobrado", nullable = false)
    private float valorCobrado;

    @Column(name = "observacao", nullable = true)
    private String observacao;
    
    //Relacinameno com outras tabelas
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    private Servico servico;

    @OneToOne
    @JoinColumn(name = "agendamento_id")
    private Agendamento agendamento;


}
