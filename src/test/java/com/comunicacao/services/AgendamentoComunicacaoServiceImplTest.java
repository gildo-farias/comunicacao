package com.comunicacao.services;

import com.comunicacao.entidades.AgendamentoComunicacaoEntidade;
import com.comunicacao.repositories.AgendamentoComunicacaoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class AgendamentoComunicacaoServiceImplTest extends TesteAnotacaoMockito {

    @InjectMocks
    private AgendamentoComunicacaoServiceImpl service;

    @Mock
    private AgendamentoComunicacaoRepository repository;

    @Test
    public void criarAgendamento() {
        AgendamentoComunicacaoEntidade entidade = MocksMappers.mapearEntidade();
        Mockito.when(repository.saveAndFlush(entidade)).thenReturn(entidade);
        String codigoRastreio = service.agendar(entidade);
        Assertions.assertThat(codigoRastreio).isNotBlank();
    }

    @Test
    public void apagarAgendamento() {
        AgendamentoComunicacaoEntidade entidade = MocksMappers.mapearEntidade();
        String codigoRastreio = entidade.getCodigoRastreio();
        service.apagar(codigoRastreio);
        Mockito.verify(repository).apagarPeloCodigoDeRastreio(codigoRastreio);
    }

    @Test
    public void visualizarAgendamento() {
        AgendamentoComunicacaoEntidade entidade = MocksMappers.mapearEntidade();
        String codigoRastreio = entidade.getCodigoRastreio();
        service.visualizarStatus(codigoRastreio);
        Mockito.verify(repository).buscarStatusPeloCodigoRastreio(codigoRastreio);
    }

}