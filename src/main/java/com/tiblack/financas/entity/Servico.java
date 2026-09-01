package com.tiblack.financas.entity;

import java.util.List;

import com.tiblack.financas.dto.servico.ServicoResponseDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "servico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Servico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "valor")
    private float valor;

    @Column(name = "observacao", nullable = false)
    private String observacao;

    @Column(name = "disponivel")
    private boolean disponivel;

    @Column(name = "tempo_estimado", nullable = false)
    private String tempoEstimado;

    @OneToMany(mappedBy = "servico")
    private List<Agendamento> agendamentos;

    public ServicoResponseDTO response(){
        return new ServicoResponseDTO(id,descricao, valor,observacao,disponivel,tempoEstimado);
    }

}
