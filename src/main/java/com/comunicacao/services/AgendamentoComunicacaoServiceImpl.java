package com.comunicacao.services;

import com.comunicacao.domain.agendamento.AgendamentoStatus;
import com.comunicacao.entidades.AgendamentoComunicacaoEntidade;
import com.comunicacao.repositories.AgendamentoComunicacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
class AgendamentoComunicacaoServiceImpl implements AgendamentoComunicacaoService {

    private final AgendamentoComunicacaoRepository repository;

    @Override
    public String agendar(AgendamentoComunicacaoEntidade entidade) {
        return repository.saveAndFlush(entidade).getCodigoRastreio();
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
