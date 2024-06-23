package com.comunicacao.entidades;

import com.comunicacao.controllers.mappers.AgendamentoComunicaoEntidadeMapper;
import com.comunicacao.domain.agendamento.AgendamentoStatus;
import com.comunicacao.services.MockRequisicaoCompleta;
import com.comunicacao.services.TesteAnotacaoMockito;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AgendamentoComunicacaoEntidadeTest extends TesteAnotacaoMockito {

    private AgendamentoComunicacaoEntidade montarEntidade() {
        return AgendamentoComunicaoEntidadeMapper.mapear(MockRequisicaoCompleta.get());
    }

    @Test
    void agendamentoProcessando() {
        AgendamentoComunicacaoEntidade entidade = this.montarEntidade();
        entidade.processando();
        Assertions.assertThat(entidade.getStatus()).isEqualTo(AgendamentoStatus.PROCESSANDO);
        Assertions.assertThat(entidade.getTentativas()).isEqualTo(1);
    }

    @Test
    void agendamentoEnviado() {
        AgendamentoComunicacaoEntidade entidade = this.montarEntidade();
        entidade.enviado();
        Assertions.assertThat(entidade.getStatus()).isEqualTo(AgendamentoStatus.ENVIADO);
    }

    @Test
    void agendamentoDeuFalha() {
        AgendamentoComunicacaoEntidade entidade = this.montarEntidade();
        entidade.falha("Servidor fora do ar!");
        Assertions.assertThat(entidade.getStatus()).isEqualTo(AgendamentoStatus.FALHA);
        Assertions.assertThat(entidade.getLogFalha()).isNotBlank();
    }

}