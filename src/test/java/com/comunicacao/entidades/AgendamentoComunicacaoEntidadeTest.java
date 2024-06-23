package com.comunicacao.entidades;

import com.comunicacao.domain.agendamento.AgendamentoStatus;
import com.comunicacao.services.MocksMappers;
import com.comunicacao.services.TesteAnotacaoMockito;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AgendamentoComunicacaoEntidadeTest extends TesteAnotacaoMockito {

    private static AgendamentoComunicacaoEntidade entidade;

    @BeforeAll
    static void iniciar() {
        entidade = MocksMappers.mapearEntidade();
    }

    @Test
    void agendamentoProcessando() {
        entidade.processando();
        Assertions.assertThat(entidade.getStatus()).isEqualTo(AgendamentoStatus.PROCESSANDO);
        Assertions.assertThat(entidade.getTentativas()).isEqualTo(1);
    }

    @Test
    void agendamentoEnviado() {
        entidade.enviado();
        Assertions.assertThat(entidade.getStatus()).isEqualTo(AgendamentoStatus.ENVIADO);
    }

    @Test
    void agendamentoDeuFalha() {
        String causa = "Servidor fora do ar!";
        entidade.falha(causa);
        Assertions.assertThat(entidade.getStatus()).isEqualTo(AgendamentoStatus.FALHA);
        Assertions.assertThat(entidade.getLogFalha()).isEqualTo(causa);
    }

}