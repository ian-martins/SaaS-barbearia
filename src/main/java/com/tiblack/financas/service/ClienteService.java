package com.tiblack.financas.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.tiblack.financas.entity.Cliente;
import com.tiblack.financas.repository.ClienteRepository;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente buscarCliente(UUID id) {
        return clienteRepository.findById(id).get();
    }
    
    public List<Cliente> ListarClientes() {
        return clienteRepository.findAll();
    }



}
