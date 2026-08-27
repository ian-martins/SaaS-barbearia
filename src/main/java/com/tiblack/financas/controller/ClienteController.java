package com.tiblack.financas.controller;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiblack.financas.dto.ClienteRequestDTO;
import com.tiblack.financas.entity.Cliente;
import com.tiblack.financas.service.ClienteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:5173/")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> salvarCliente(@RequestBody ClienteRequestDTO dto) {
        return ResponseEntity.ok(clienteService.salvarCliente(new Cliente(null, dto.nome(), dto.telefone(), dto.observacao(), null, LocalDateTime.now(), null , null)));
    }
    
    @GetMapping("/all")
    public ResponseEntity<?> listarClientes() {
        return ResponseEntity.ok(clienteService.ListarClientes());
    }
    


}
