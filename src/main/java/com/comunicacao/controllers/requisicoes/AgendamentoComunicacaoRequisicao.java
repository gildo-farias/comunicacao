package com.comunicacao.controllers.requisicoes;

import com.comunicacao.domain.agendamento.AgendamentoTipo;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record AgendamentoComunicacaoRequisicao(
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataHoraEnvio,
        String conteudo,
        String destino,
        AgendamentoTipo tipo
) {

}
