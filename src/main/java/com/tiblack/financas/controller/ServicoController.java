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

import com.tiblack.financas.dto.servico.ServicoRequestDTO;
import com.tiblack.financas.service.ServicoService;

@Controller
@RestController
@RequestMapping("/servico")
@CrossOrigin(origins = "http://localhost:5173/")
public class ServicoController {
    
    private final ServicoService servicoService;

    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> salvarServico(@RequestBody ServicoRequestDTO dto) {
        return ResponseEntity.ok(servicoService.salvarServico(dto));
    }
    
    @GetMapping("/all")
    public ResponseEntity<?> listarServicos() {
        return ResponseEntity.ok(servicoService.ListarServico());
    }

    @PutMapping("/update")
    public ResponseEntity<?> atualizarServico(@RequestBody ServicoRequestDTO dto) {
        return ResponseEntity.ok(servicoService.atualizaServico(dto));
    }
}
