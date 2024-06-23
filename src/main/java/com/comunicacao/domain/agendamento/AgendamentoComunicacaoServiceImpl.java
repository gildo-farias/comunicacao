package com.comunicacao.domain.agendamento;

import com.comunicacao.controllers.requisicoes.AgendamentoComunicacaoRequisicao;
import com.comunicacao.mappers.AgendamentoComunicaoEntidadeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
class AgendamentoComunicacaoServiceImpl implements AgendamentoComunicacaoService {

    private final AgendamentoComunicacaoRepository repository;

    @Override
    public String agendar(AgendamentoComunicacaoRequisicao requisicao) {
        AgendamentoComunicacaoEntidade agendamento = AgendamentoComunicaoEntidadeMapper.mapearEntidade(requisicao);
        return repository.saveAndFlush(agendamento).getCodigoRastreio();
    }

    @Override
    public Optional<AgendamentoStatus> visualizarStatus(String codigoRastreio) {
        return repository.buscarStatusPeloCodigoRastreio(codigoRastreio);
    }

    @Override
    public void apagar(String codigoRastreio) {
        repository.apagarPeloCodigoDeRastreio(codigoRastreio);
    }

}
