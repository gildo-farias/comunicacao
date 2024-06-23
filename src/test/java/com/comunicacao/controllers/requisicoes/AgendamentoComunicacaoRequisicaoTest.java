package com.comunicacao.controllers.requisicoes;

import com.comunicacao.services.MocksMappers;
import com.comunicacao.services.TesteAnotacaoMockito;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Set;

import static com.comunicacao.controllers.requisicoes.AgendamentoComunicacaoRequisicao.*;

class AgendamentoComunicacaoRequisicaoTest extends TesteAnotacaoMockito {

    private static Validator validator;
    private static AgendamentoComunicacaoRequisicao requisicaoIncompleta;

    @BeforeAll
    static void iniciar() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        requisicaoIncompleta = MocksMappers.mapearRequisicaoIncompleta();
    }

    private static void assertViolations(Set<ConstraintViolation<AgendamentoComunicacaoRequisicao>> violations, String erroToAssert) {
        Assertions.assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals(erroToAssert)));
    }

    @Test
    void giveDataNulaWhenInstanciandoRequisicaoThenRetornaDataInvalida() {
        Set<ConstraintViolation<AgendamentoComunicacaoRequisicao>> violations = validator.validate(requisicaoIncompleta);
        assertViolations(violations, DATA_HORA_DE_ENVIO_INVALIDA);
    }

    @Test
    void giveConteudoNuloWhenInstanciandoRequisicaoThenRetornaConteudoInvalido() {
        Set<ConstraintViolation<AgendamentoComunicacaoRequisicao>> violations = validator.validate(requisicaoIncompleta);
        assertViolations(violations, CONTEUDO_INVALIDO);
    }

    @Test
    void giveDestinoNuloWhenInstanciandoRequisicaoThenRetornaDestinoInvalido() {
        Set<ConstraintViolation<AgendamentoComunicacaoRequisicao>> violations = validator.validate(requisicaoIncompleta);
        assertViolations(violations, DESTINO_INVALIDO);
    }

    @Test
    void giveTipoNuloWhenInstanciandoRequisicaoThenRetornaTipoNaoPodeSerVazio() {
        Set<ConstraintViolation<AgendamentoComunicacaoRequisicao>> violations = validator.validate(requisicaoIncompleta);
        assertViolations(violations, TIPO_NAO_PODE_SER_VAZIO);
    }

    @Test
    void giveTipoInvalidoWhenInstanciandoRequisicaoThenRetornaTipoInvalido() {
        AgendamentoComunicacaoRequisicao requisicao = new AgendamentoComunicacaoRequisicao(
                LocalDateTime.now(),
                "Olá Mundo",
                "teste@gmail.com",
                "TELEGRAM"
        );
        Set<ConstraintViolation<AgendamentoComunicacaoRequisicao>> violations = validator.validate(requisicao);
        assertViolations(violations, TIPO_INVALIDO);
    }

}