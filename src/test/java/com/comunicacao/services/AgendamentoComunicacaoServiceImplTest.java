package com.comunicacao.services;

import com.comunicacao.controllers.mappers.AgendamentoComunicaoEntidadeMapper;
import com.comunicacao.entidades.AgendamentoComunicacaoEntidade;
import com.comunicacao.repositories.AgendamentoComunicacaoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class AgendamentoComunicacaoServiceImplTest extends TesteAnotacaoMockito {

    @InjectMocks
    private AgendamentoComunicacaoServiceImpl service;

    @Mock
    private AgendamentoComunicacaoRepository repository;

    @Test
    public void agendarSucesso() {
        AgendamentoComunicacaoEntidade entidade = AgendamentoComunicaoEntidadeMapper.mapear(MocksMappers.mapearRequisicaoCompleta());
        String codigoRastreio = service.agendar(entidade);
        Assertions.assertThat(codigoRastreio).isNotBlank();
    }

}