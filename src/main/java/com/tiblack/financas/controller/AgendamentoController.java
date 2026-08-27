package com.tiblack.financas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.tiblack.financas.dto.AgendamentoRequestDTO;
import com.tiblack.financas.entity.Agendamento;
import com.tiblack.financas.entity.enuns.StatusAgendamento;
import com.tiblack.financas.service.AgendamentoService;
import com.tiblack.financas.service.ClienteService;
import com.tiblack.financas.service.ServicoService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/agenda")
@CrossOrigin(origins = "http://localhost:5173/")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;
    private final ClienteService clienteService;
    private final ServicoService servicoService;

    public AgendamentoController(AgendamentoService agendamentoService, ClienteService clienteService,
            ServicoService servicoService) {
        this.agendamentoService = agendamentoService;
        this.clienteService = clienteService;
        this.servicoService = servicoService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> salvarAgendamento(@RequestBody AgendamentoRequestDTO dto) {
        Agendamento a = new Agendamento(null, dto.datahora(), clienteService.buscarCliente(dto.idCliente()),
                servicoService.buscarServico(dto.idServico()).get(), null, StatusAgendamento.AGENDADO);
        return ResponseEntity.ok(agendamentoService.salvarAgendamento(a));
    }

    @GetMapping("/all")
    public ResponseEntity<?> listarAgendamentos() {
        return ResponseEntity.ok(agendamentoService.listarAgendamentos());
    }

}
