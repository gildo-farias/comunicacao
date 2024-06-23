package com.comunicacao.services;

import com.comunicacao.controllers.requisicoes.AgendamentoComunicacaoRequisicao;
import com.comunicacao.domain.agendamento.AgendamentoStatus;

import java.util.Optional;

public interface AgendamentoComunicacaoService {

    String agendar(AgendamentoComunicacaoRequisicao requisicao);

    Optional<AgendamentoStatus> visualizarStatus(String codigoRastreio);

    void apagar(String codigoRastreio);

}
