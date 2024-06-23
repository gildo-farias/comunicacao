package com.comunicacao.services;

import com.comunicacao.controllers.requisicoes.AgendamentoComunicacaoRequisicao;
import com.comunicacao.domain.agendamento.AgendamentoTipo;

import java.time.LocalDateTime;

public final class MockRequisicaoCompleta {
    public static AgendamentoComunicacaoRequisicao get() {
        return new AgendamentoComunicacaoRequisicao(
                LocalDateTime.now(),
                "Olá",
                "teste@gmail.com",
                AgendamentoTipo.EMAIL.name()
        );
    }
}
