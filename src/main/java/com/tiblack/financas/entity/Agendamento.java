package com.tiblack.financas.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.tiblack.financas.dto.agendamento.AgendamentoResponseDTO;
import com.tiblack.financas.entity.enuns.StatusAgendamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "agendamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = true)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    private Servico servico;

    @OneToOne(mappedBy = "agendamento")
    private Atendimento atendimento;

    @Enumerated(EnumType.STRING)
    private StatusAgendamento status;

    public AgendamentoResponseDTO response() {
        return new AgendamentoResponseDTO(id, dataHora, cliente.getNome(), servico.getDescricao(), status);
    }
}
