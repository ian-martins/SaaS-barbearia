package com.tiblack.financas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiblack.financas.dto.movfin.FecharDiaRequestDTO;
import com.tiblack.financas.service.MovimentacaoFinanceiraService;

    
@Controller
@RestController
@RequestMapping("/fin")
@CrossOrigin(origins = "http://localhost:5173/")
public class MovimentacaoFinanceiraController {

    private final MovimentacaoFinanceiraService movimentacaoFinanceiraService;


    public MovimentacaoFinanceiraController(MovimentacaoFinanceiraService movimentacaoFinanceiraService ) {
        this.movimentacaoFinanceiraService = movimentacaoFinanceiraService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> salvarCliente(@RequestBody FecharDiaRequestDTO dto) {
        movimentacaoFinanceiraService.fecharDia(dto.dia());
        return ResponseEntity.ok().build();
    }

}
