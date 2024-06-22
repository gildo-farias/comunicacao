package com.comunicacao.domain.agendamento;

import com.comunicacao.controllers.requisicoes.AgendamentoComunicacaoRequisicao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
@RequiredArgsConstructor
class AgendamentoComunicacaoServiceImpl implements AgendamentoComunicacaoService {

    private final AgendamentoComunicacaoRepository repository;

    @Override
    public String agendar(AgendamentoComunicacaoRequisicao requisicao) {
        AgendamentoComunicacaoEntidade agendamento = new AgendamentoComunicacaoEntidade();
        agendamento.setTipo(requisicao.tipo());
        agendamento.setDestino(requisicao.destino());
        agendamento.setConteudo(requisicao.conteudo());
        agendamento.setDataEnvio(requisicao.dataHora());
        agendamento.setCodigoRastreio(UUID.randomUUID().toString());
        agendamento.setStatus(AgendamentoStatus.AGUARDANDO);
        return repository.saveAndFlush(agendamento).getCodigoRastreio();
    }

    @Override
    public Optional<AgendamentoStatus> visualizarStatus(String codigoRastreio) {
        return isBlank(codigoRastreio) ? Optional.empty() :
                repository.buscarPeloCodigoRastreio(codigoRastreio).map(AgendamentoComunicacaoEntidade::getStatus);
    }

}
