package com.comunicacao.mappers;

import com.comunicacao.controllers.requisicoes.AgendamentoComunicacaoRequisicao;
import com.comunicacao.domain.agendamento.AgendamentoComunicacaoEntidade;
import com.comunicacao.domain.agendamento.AgendamentoStatus;
import com.comunicacao.domain.agendamento.AgendamentoTipo;

import java.util.UUID;

public class AgendamentoComunicaoEntidadeMapper {

    public static AgendamentoComunicacaoEntidade mapearEntidade(AgendamentoComunicacaoRequisicao requisicao) {
        AgendamentoComunicacaoEntidade agendamento = new AgendamentoComunicacaoEntidade();
        agendamento.setTipo(AgendamentoTipo.valueOf(requisicao.tipo()));
        agendamento.setDestino(requisicao.destino());
        agendamento.setConteudo(requisicao.conteudo());
        agendamento.setDataEnvio(requisicao.dataHoraEnvio());
        agendamento.setCodigoRastreio(UUID.randomUUID().toString());
        agendamento.setStatus(AgendamentoStatus.AGUARDANDO);
        return agendamento;
    }

}
