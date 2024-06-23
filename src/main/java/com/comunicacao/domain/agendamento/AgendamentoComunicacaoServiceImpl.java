package com.comunicacao.domain.agendamento;

import com.comunicacao.controllers.requisicoes.AgendamentoComunicacaoRequisicao;
import com.comunicacao.exceptions.CodigoRastreioInvalido;
import com.comunicacao.mappers.AgendamentoComunicaoEntidadeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.isBlank;

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
        return isBlank(codigoRastreio) ? Optional.empty() :
                repository.buscarPeloCodigoRastreio(codigoRastreio).map(AgendamentoComunicacaoEntidade::getStatus);
    }

    @Override
    public void apagar(String codigoRastreio) {
        if (isBlank(codigoRastreio))
            throw new CodigoRastreioInvalido();
        repository.apagarPeloCodigoDeRastreio(codigoRastreio);
    }

}
