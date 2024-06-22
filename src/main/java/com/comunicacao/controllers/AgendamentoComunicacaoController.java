package com.comunicacao.controllers;

import com.comunicacao.controllers.requisicoes.AgendamentoComunicacaoRequisicao;
import com.comunicacao.domain.agendamento.AgendamentoComunicacaoService;
import com.comunicacao.domain.agendamento.AgendamentoStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agendamento")
public class AgendamentoComunicacaoController {

    private final AgendamentoComunicacaoService service;

    @PostMapping
    public ResponseEntity<String> agendar(@RequestBody AgendamentoComunicacaoRequisicao requisicao) {
        String codigoRastreio = service.agendar(requisicao);
        return ResponseEntity.accepted().body(codigoRastreio);
    }

    @GetMapping("/status/{codigoRastreio}")
    public ResponseEntity<AgendamentoStatus> visualizarStatus(@PathVariable String codigoRastreio) {
        return service.visualizarStatus(codigoRastreio)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}