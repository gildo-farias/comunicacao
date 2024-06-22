package com.comunicacao.controllers.requisicoes;

import com.comunicacao.domain.agendamento.AgendamentoTipo;

import java.time.LocalDateTime;

public record AgendamentoComunicacaoRequisicao(
        LocalDateTime dataHora,
        String conteudo,
        String destino,
        AgendamentoTipo tipo
) {

}
