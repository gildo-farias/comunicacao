package com.comunicacao.controllers;

import com.comunicacao.controllers.respostas.RespostaStatus;
import com.comunicacao.services.AgendamentoComunicacaoService;
import com.comunicacao.services.TesteAnotacaoMockito;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AgendamentoComunicacaoControllerTest extends TesteAnotacaoMockito {

    @InjectMocks

    private AgendamentoComunicacaoController controller;

    @Mock
    private AgendamentoComunicacaoService service;

    @Test
    public void givenCodigoRastreioWhenDeletarAgendamentoThenDeveRetornar204() {
        String codigoRastreio = "5b421cf7-0ed2-47a9-916e-21c167b76173";
        ResponseEntity<Void> response = controller.apagar(codigoRastreio);

        Mockito.verify(service).apagar(codigoRastreio);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    public void givenCodigoRastreioWhenVisualizarStatusAgendamentoThenDeveRetornar404() {
        String codigoRastreio = "5b421cf7-0ed2-47a9-916e-21c167b76173";
        ResponseEntity<RespostaStatus> response = controller.visualizarStatus(codigoRastreio);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

}