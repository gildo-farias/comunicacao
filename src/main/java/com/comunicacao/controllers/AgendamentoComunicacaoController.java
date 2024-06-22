package com.comunicacao.controllers;

import com.comunicacao.controllers.requisicoes.AgendamentoComunicacaoRequisicao;
import com.comunicacao.domain.agendamento.AgendamentoComunicacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}