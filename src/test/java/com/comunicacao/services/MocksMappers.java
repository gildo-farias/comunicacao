package com.comunicacao.services;

import com.comunicacao.controllers.mappers.AgendamentoComunicaoEntidadeMapper;
import com.comunicacao.controllers.requisicoes.AgendamentoComunicacaoRequisicao;
import com.comunicacao.domain.agendamento.AgendamentoTipo;
import com.comunicacao.entidades.AgendamentoComunicacaoEntidade;

import java.time.LocalDateTime;

public final class MocksMappers {
    public static final String CODIGO_RASTREIO = "5b421cf7-0ed2-47a9-916e-21c167b76173";

    public static AgendamentoComunicacaoRequisicao mapearRequisicaoCompleta() {
        return new AgendamentoComunicacaoRequisicao(
                LocalDateTime.now(),
                "Olá",
                "teste@gmail.com",
                AgendamentoTipo.EMAIL.name()
        );
    }

    public static AgendamentoComunicacaoEntidade mapearEntidade() {
        AgendamentoComunicacaoRequisicao requisicao = mapearRequisicaoCompleta();
        return AgendamentoComunicaoEntidadeMapper.mapear(requisicao);
    }

}
