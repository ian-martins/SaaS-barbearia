package com.tiblack.financas.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    
    // Colunas
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "telefone", nullable = true)
    private String telefone;

    @Column(name = "observacao", nullable = true)
    private String observacao;

    @Column(name = "historico_atendimento", nullable = true)
    private String histAtendimento;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    //Relacinameno com outras tabelas
    @OneToMany(mappedBy = "cliente")
    private List<Agendamento> agendamentos;
    
    @OneToMany(mappedBy = "cliente")
    private List<Atendimento> atendimento;
    
    // Outros
    @PrePersist
    public void prePersist() {
        dataCriacao = LocalDateTime.now();
    }

}
