package com.comunicacao.mappers;

import com.comunicacao.controllers.requisicoes.AgendamentoComunicacaoRequisicao;
import com.comunicacao.domain.agendamento.AgendamentoComunicacaoEntidade;
import com.comunicacao.domain.agendamento.AgendamentoStatus;

import java.util.UUID;

public class AgendamentoComunicaoEntidadeMapper {

    public static AgendamentoComunicacaoEntidade mapearEntidade(AgendamentoComunicacaoRequisicao requisicao) {
        AgendamentoComunicacaoEntidade agendamento = new AgendamentoComunicacaoEntidade();
        agendamento.setTipo(requisicao.tipo());
        agendamento.setDestino(requisicao.destino());
        agendamento.setConteudo(requisicao.conteudo());
        agendamento.setDataEnvio(requisicao.dataHora());
        agendamento.setCodigoRastreio(UUID.randomUUID().toString());
        agendamento.setStatus(AgendamentoStatus.AGUARDANDO);
        return agendamento;
    }

}
