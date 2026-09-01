package com.tiblack.financas.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tiblack.financas.entity.Agendamento;
import com.tiblack.financas.entity.MovimentacaoFinanceira;
import com.tiblack.financas.entity.enuns.StatusAgendamento;
import com.tiblack.financas.entity.enuns.TipoMovimentacao;
import com.tiblack.financas.repository.MovimentacaoFinanceiraRepository;

@Service
public class MovimentacaoFinanceiraService {

    private final MovimentacaoFinanceiraRepository movimentacaoFinanceiraRepository;
    private final AgendamentoService agendamentoService;

    public MovimentacaoFinanceiraService(MovimentacaoFinanceiraRepository movimentacaoFinanceiraRepository,
            AgendamentoService agendamentoService) {
        this.movimentacaoFinanceiraRepository = movimentacaoFinanceiraRepository;
        this.agendamentoService = agendamentoService;
    }

    public void fecharDia(LocalDate dia) {
        List<Agendamento> agendamentos = agendamentoService.agendamentosPeriodo(dia, dia);
        Agendamento agendamento = new Agendamento();
        MovimentacaoFinanceira mov_financeira = new MovimentacaoFinanceira();

        for (int i = 0; i < agendamentos.size(); i++) {
            agendamento = agendamentos.get(i);

            if (agendamento.getStatus() != StatusAgendamento.FALTOU &&
                    agendamento.getStatus() != StatusAgendamento.CANCELADO) {

                agendamento = agendamentoService.setConcluido(agendamento);

                
                mov_financeira = new MovimentacaoFinanceira(
                        null,
                        agendamento.getServico().getValor(),
                        null,
                        dia,
                        agendamento,
                        TipoMovimentacao.ENTRADA);

                movimentacaoFinanceiraRepository.save(mov_financeira);
            }
        }
    }

}
