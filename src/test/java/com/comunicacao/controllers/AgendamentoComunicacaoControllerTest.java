package com.comunicacao.controllers;

import com.comunicacao.controllers.requisicoes.AgendamentoComunicacaoRequisicao;
import com.comunicacao.controllers.respostas.RespostaCodigoRastreio;
import com.comunicacao.controllers.respostas.RespostaStatus;
import com.comunicacao.domain.agendamento.AgendamentoStatus;
import com.comunicacao.services.AgendamentoComunicacaoService;
import com.comunicacao.services.MocksMappers;
import com.comunicacao.services.TesteAnotacaoMockito;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class AgendamentoComunicacaoControllerTest extends TesteAnotacaoMockito {

    @InjectMocks
    private AgendamentoComunicacaoController controller;

    @Mock
    private AgendamentoComunicacaoService service;

    @Test
    public void givenCodigoRastreioWhenDeletarAgendamentoThenDeveRetornar204() {
        String codigoRastreio = MocksMappers.CODIGO_RASTREIO;
        ResponseEntity<Void> response = controller.apagar(codigoRastreio);

        Mockito.verify(service).apagar(codigoRastreio);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    public void givenCodigoRastreioWhenVisualizarStatusAgendamentoThenDeveRetornar404() {
        String codigoRastreio = MocksMappers.CODIGO_RASTREIO;
        ResponseEntity<RespostaStatus> response = controller.visualizarStatus(codigoRastreio);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void givenCodigoRastreioWhenVisualizarStatusAgendamentoThenDeveRetornar200() {
        String codigoRastreio = MocksMappers.CODIGO_RASTREIO;
        AgendamentoStatus aguardando = AgendamentoStatus.AGUARDANDO;
        Mockito.when(service.visualizarStatus(codigoRastreio)).thenReturn(Optional.of(aguardando));

        RespostaStatus respostaStatus = new RespostaStatus(aguardando.name());
        ResponseEntity<RespostaStatus> response = controller.visualizarStatus(codigoRastreio);

        Assertions.assertThat(response.getBody()).isEqualTo(respostaStatus);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void givenDadosAgendamentoWhenCriarAgendamentoThenDeveRetornar202() {
        AgendamentoComunicacaoRequisicao requisicao = MocksMappers.mapearRequisicaoCompleta();
        ResponseEntity<RespostaCodigoRastreio> response = controller.agendar(requisicao);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
    }

}