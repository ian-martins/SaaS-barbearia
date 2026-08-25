package com.tiblack.financas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tiblack.financas.dto.ServicoUpdateDTO;
import com.tiblack.financas.entity.Servico;
import com.tiblack.financas.repository.ServicoRepository;

@Service
public class ServicoService {
    private final ServicoRepository servicoRepository;

    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    public Servico salvarServico(Servico servico) {
        return servicoRepository.save(servico);
    }

    public Optional<Servico> buscarServico(Long id) {
        return servicoRepository.findById(id);
    }
    
    public List<Servico> ListarServico() {
        return servicoRepository.findAll();
    }

    public Servico atualizaServico(ServicoUpdateDTO DTO) {
        Optional<Servico> present = buscarServico(DTO.id());
        if(!present.isPresent()) return null;
        Servico servico = present.get();
        if(DTO.descricao() != null && !DTO.descricao().isBlank()){

        }
        return servicoRepository.save(servico);
    }
 

}
