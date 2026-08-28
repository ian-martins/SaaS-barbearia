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

import com.tiblack.financas.dto.cliente.ClienteRequestDTO;
import com.tiblack.financas.service.ClienteService;

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
        return ResponseEntity.ok(clienteService.salvarCliente(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<?> listarClientes() {
        return ResponseEntity.ok(clienteService.ListarClientes());
    }

    @PutMapping("/update")
    public ResponseEntity<?> atualizarCliente(@RequestBody ClienteRequestDTO dto) {
        return ResponseEntity.ok(clienteService.atualizarClientes(dto));
    }

}
