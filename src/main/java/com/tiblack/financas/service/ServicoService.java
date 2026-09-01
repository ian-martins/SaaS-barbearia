package com.tiblack.financas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tiblack.financas.dto.servico.ServicoRequestDTO;
import com.tiblack.financas.dto.servico.ServicoResponseDTO;
import com.tiblack.financas.entity.Servico;
import com.tiblack.financas.repository.ServicoRepository;

@Service
public class ServicoService {
    private final ServicoRepository servicoRepository;

    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    public ServicoResponseDTO salvarServico(ServicoRequestDTO dto) {
        Servico servico = new Servico(null, dto.descricao(), dto.valor(), dto.observacao(), true, dto.tempoEstimado(),
                null);
        servico = servicoRepository.save(servico);
        return servico.response();
    }

    public Optional<Servico> buscarServico(Long id) {
        return servicoRepository.findById(id);
    }

    public List<ServicoResponseDTO> ListarServico() {
        List<Servico> servicos = servicoRepository.findAll();
        List<ServicoResponseDTO> response = new ArrayList<>();
        for (int i = 0; i < servicos.size(); i++) {
            response.add(servicos.get(i).response());
        }
        return response;
    }

    public ServicoResponseDTO atualizaServico(ServicoRequestDTO dto) {
        Optional<Servico> present = buscarServico(dto.id());

        if (!present.isPresent())
            return null;

        Servico servico = present.get();

        if (!servico.getDescricao().equals(dto.descricao()) && !dto.descricao().isEmpty())
            servico.setDescricao(dto.descricao());
        if (!(servico.getValor() == dto.valor()))
            servico.setValor(dto.valor());
        if (!servico.getObservacao().equals(dto.observacao()) && !dto.observacao().isEmpty())
            servico.setObservacao(dto.observacao());
        if (!servico.isDisponivel() == dto.disponivel())
            servico.setDisponivel(dto.disponivel());
        if (!servico.getTempoEstimado().equals(dto.tempoEstimado()) && !dto.tempoEstimado().isEmpty())
            servico.setTempoEstimado(dto.tempoEstimado());

        return servicoRepository.save(servico).response();
    }

}
