package com.comunicacao.services;

import com.comunicacao.domain.agendamento.AgendamentoStatus;
import com.comunicacao.entidades.AgendamentoComunicacaoEntidade;

import java.util.Optional;

public interface AgendamentoComunicacaoService {

    String agendar(AgendamentoComunicacaoEntidade entidade);

    Optional<AgendamentoStatus> visualizarStatus(String codigoRastreio);

    void apagar(String codigoRastreio);

}
