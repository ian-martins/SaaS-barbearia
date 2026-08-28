package com.tiblack.financas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiblack.financas.dto.agendamento.AgendamentoRequestDTO;
import com.tiblack.financas.service.AgendamentoService;

@Controller
@RestController
@RequestMapping("/agenda")
@CrossOrigin(origins = "http://localhost:5173/")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;


    public AgendamentoController(AgendamentoService agendamentoService ) {
        this.agendamentoService = agendamentoService;
 
    }

    @PostMapping("/save")
    public ResponseEntity<?> salvarAgendamento(@RequestBody AgendamentoRequestDTO dto) {

        return ResponseEntity.ok(agendamentoService.salvarAgendamento(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<?> listarAgendamentos() {
        return ResponseEntity.ok(agendamentoService.listarAgendamentos());
    }

    @PutMapping("/update")
    public ResponseEntity<?> atualizarAgendamento(@RequestBody AgendamentoRequestDTO dto) {
        return ResponseEntity.ok(agendamentoService.atualizarAgendamento(dto));
    }

}
