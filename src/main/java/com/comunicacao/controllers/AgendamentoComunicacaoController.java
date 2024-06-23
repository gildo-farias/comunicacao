package com.comunicacao.controllers;

import com.comunicacao.controllers.mappers.AgendamentoComunicaoEntidadeMapper;
import com.comunicacao.controllers.requisicoes.AgendamentoComunicacaoRequisicao;
import com.comunicacao.controllers.respostas.RespostaCodigoRastreio;
import com.comunicacao.controllers.respostas.RespostaStatus;
import com.comunicacao.entidades.AgendamentoComunicacaoEntidade;
import com.comunicacao.services.AgendamentoComunicacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/agendamento", produces = APPLICATION_JSON_VALUE)
public class AgendamentoComunicacaoController {

    private final AgendamentoComunicacaoService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<RespostaCodigoRastreio> agendar(@RequestBody AgendamentoComunicacaoRequisicao requisicao) {
        AgendamentoComunicacaoEntidade entidade = AgendamentoComunicaoEntidadeMapper.mapear(requisicao);
        String codigoRastreio = service.agendar(entidade);
        return ResponseEntity.accepted().body(new RespostaCodigoRastreio(codigoRastreio));
    }

    @GetMapping("/status/{codigoRastreio}")
    public ResponseEntity<RespostaStatus> visualizarStatus(@PathVariable String codigoRastreio) {
        return service.visualizarStatus(codigoRastreio)
                .map(Enum::name)
                .map(RespostaStatus::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{codigoRastreio}")
    public ResponseEntity<Void> apagar(@PathVariable String codigoRastreio) {
        service.apagar(codigoRastreio);
        return ResponseEntity.noContent().build();
    }

}