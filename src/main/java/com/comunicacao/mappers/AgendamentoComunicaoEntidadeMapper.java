package com.comunicacao.mappers;

import com.comunicacao.controllers.requisicoes.AgendamentoComunicacaoRequisicao;
import com.comunicacao.domain.agendamento.AgendamentoComunicacaoEntidade;
import com.comunicacao.domain.agendamento.AgendamentoStatus;
import com.comunicacao.exceptions.DataEnvioInvalida;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class AgendamentoComunicaoEntidadeMapper {

    public static AgendamentoComunicacaoEntidade mapearEntidade(AgendamentoComunicacaoRequisicao requisicao) {
        AgendamentoComunicacaoEntidade agendamento = new AgendamentoComunicacaoEntidade();
        agendamento.setTipo(requisicao.tipo());
        agendamento.setDestino(requisicao.destino());
        agendamento.setConteudo(requisicao.conteudo());
        LocalDateTime dataEnvio = requisicao.dataHoraEnvio();
        if (Objects.isNull(dataEnvio))
            throw new DataEnvioInvalida();
        agendamento.setDataEnvio(dataEnvio);
        agendamento.setCodigoRastreio(UUID.randomUUID().toString());
        agendamento.setStatus(AgendamentoStatus.AGUARDANDO);
        return agendamento;
    }

}
