package com.comunicacao.domain.agendamento;

import com.comunicacao.controllers.requisicoes.AgendamentoComunicacaoRequisicao;

import java.util.Optional;

public interface AgendamentoComunicacaoService {

    String agendar(AgendamentoComunicacaoRequisicao requisicao);

    Optional<AgendamentoStatus> visualizarStatus(String codigoRastreio);

}
