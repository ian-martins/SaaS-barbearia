package com.tiblack.financas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tiblack.financas.dto.agendamento.AgendamentoRequestDTO;
import com.tiblack.financas.dto.agendamento.AgendamentoResponseDTO;
import com.tiblack.financas.entity.Agendamento;
import com.tiblack.financas.entity.Cliente;
import com.tiblack.financas.entity.enuns.StatusAgendamento;
import com.tiblack.financas.repository.AgendamentoRepository;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final ClienteService clienteService;
    private final ServicoService servicoService;

    public AgendamentoService(AgendamentoRepository agendamentoRepository, ClienteService clienteService,
            ServicoService servicoService) {
        this.agendamentoRepository = agendamentoRepository;
        this.clienteService = clienteService;
        this.servicoService = servicoService;
    }

    public AgendamentoResponseDTO salvarAgendamento(AgendamentoRequestDTO dto) {

        Agendamento agendamento = new Agendamento(null, dto.datahora(), null,
                servicoService.buscarServico(dto.servico()).get(), null, StatusAgendamento.AGENDADO);
        try {
            Optional<Cliente> cliente = clienteService.buscarCliente(dto.cliente());
            agendamento.setCliente(cliente.get());
            return agendamentoRepository.save(agendamento).response();

        } catch (Exception e) {
            agendamento = agendamentoRepository.save(agendamento);
            return agendamento.response();
        }

    }

    public List<AgendamentoResponseDTO> listarAgendamentos() {
        List<Agendamento> agendamentos = agendamentoRepository.findAll();
        List<AgendamentoResponseDTO> response = new ArrayList<>();
        for (int i = 0; i < agendamentos.size(); i++) {
            response.add(agendamentos.get(i).response());
        }
        return response;
    }

    public AgendamentoResponseDTO atualizarAgendamento(AgendamentoRequestDTO dto) {
        Optional<Agendamento> present = agendamentoRepository.findById(dto.id());
        if (!present.isPresent())
            return null;
        Agendamento agendamento = present.get();

        if (!agendamento.getDataHora().isEqual(dto.datahora()))
            agendamento.setDataHora(dto.datahora());

        if ((agendamento.getServico().getId() - dto.servico()) != 0)
            agendamento.setServico(servicoService.buscarServico(dto.servico()).get());

        if (!agendamento.getCliente().getId().equals(dto.cliente()))
            agendamento.setCliente(clienteService.buscarCliente(dto.cliente()).get());

        if (!agendamento.getStatus().equals(dto.status()))
            agendamento.setStatus(dto.status());

        return agendamentoRepository.save(agendamento).response();
    }
}
