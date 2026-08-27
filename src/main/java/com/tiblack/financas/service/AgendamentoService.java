package com.tiblack.financas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tiblack.financas.entity.Agendamento;
import com.tiblack.financas.repository.AgendamentoRepository;

@Service
public class AgendamentoService {
    
    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository){
        this.agendamentoRepository = agendamentoRepository;
    }

    public Agendamento salvarAgendamento(Agendamento agendamento){
        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> listarAgendamentos(){
        return agendamentoRepository.findAll();
    }
    
    
}
