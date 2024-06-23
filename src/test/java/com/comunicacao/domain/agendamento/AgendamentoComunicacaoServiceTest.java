package com.comunicacao.domain.agendamento;

import com.comunicacao.EnvioDeComunicacaoApplication;
import com.comunicacao.controllers.requisicoes.AgendamentoComunicacaoRequisicao;
import com.comunicacao.exceptions.DataEnvioInvalida;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.platform.commons.util.StringUtils.isBlank;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EnvioDeComunicacaoApplication.class)
public class AgendamentoComunicacaoServiceTest {

    @Autowired
    private AgendamentoComunicacaoService service;

    @Test
    public void agendarSucesso() {
        AgendamentoComunicacaoRequisicao requisicao = new AgendamentoComunicacaoRequisicao(
                LocalDateTime.now(),
                "Olá",
                "gildo@gmail.com",
                AgendamentoTipo.EMAIL
        );
        String codigoRastreio = service.agendar(requisicao);
        Assert.assertFalse(isBlank(codigoRastreio));
    }

    @Test(expected = DataEnvioInvalida.class)
    public void agendarErroDataVazia() {
        AgendamentoComunicacaoRequisicao requisicao = new AgendamentoComunicacaoRequisicao(
                null,
                "Olá",
                "gildo@gmail.com",
                AgendamentoTipo.EMAIL
        );
        service.agendar(requisicao);
        Assert.fail();
    }


}