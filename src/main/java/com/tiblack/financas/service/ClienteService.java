package com.tiblack.financas.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.tiblack.financas.dto.cliente.ClienteRequestDTO;
import com.tiblack.financas.dto.cliente.ClienteResponseDTO;
import com.tiblack.financas.entity.Cliente;
import com.tiblack.financas.repository.ClienteRepository;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteResponseDTO salvarCliente(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente(null, dto.nome(), dto.telefone(), dto.observacao(), LocalDateTime.now(),
                null);
        return clienteRepository.save(cliente).response();
    }

    public Optional<Cliente> buscarCliente(UUID id) {
        return clienteRepository.findById(id);
    }

    public List<ClienteResponseDTO> ListarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteResponseDTO> response = new ArrayList<>();

        for (int i = 0; i < clientes.size(); i++) {
            response.add(clientes.get(i).response());
        }
        return response;
    }

    public ClienteResponseDTO atualizarClientes(ClienteRequestDTO dto) {
        Optional<Cliente> present = buscarCliente(dto.id());
        if (!present.isPresent())
            return null;
        Cliente cliente = present.get();

        if (!cliente.getNome().equals(dto.nome()) && !dto.nome().isEmpty())
            cliente.setNome(dto.nome());
        if (!cliente.getObservacao().equals(dto.observacao()) && !dto.observacao().isEmpty())
            cliente.setObservacao(dto.observacao());
        if (!cliente.getTelefone().equals(dto.telefone()) && !dto.telefone().isEmpty())
            cliente.setTelefone(dto.telefone());
        return clienteRepository.save(cliente).response();

    }
}
