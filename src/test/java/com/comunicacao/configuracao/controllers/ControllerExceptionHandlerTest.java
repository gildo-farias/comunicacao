package com.comunicacao.configuracao.controllers;

import com.comunicacao.controllers.respostas.RespostaErro;
import com.comunicacao.services.TesteAnotacaoMockito;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.lang.reflect.Method;
import java.util.Collections;

import static com.comunicacao.configuracao.controllers.ControllerExceptionHandler.FORMATO_DE_DATA_HORA_INVALIDA;

class ControllerExceptionHandlerTest extends TesteAnotacaoMockito {

    @InjectMocks
    private ControllerExceptionHandler controllerExceptionHandler;

    @Mock
    private HttpInputMessage httpInputMessage;

    @Data
    @AllArgsConstructor
    private final static class Teste {
        private String field1;
    }

    private MethodArgumentNotValidException getMethodArgumentNotValidException(String erro) throws NoSuchMethodException {
        Method method = Teste.class.getMethod("setField1", String.class);
        MethodParameter methodParameter = new MethodParameter(method, 0);
        String field1 = "field1";
        Teste instanciaTeste = new Teste("teste");
        BindingResult bindResult = new BindException(instanciaTeste, field1).getBindingResult();
        bindResult.rejectValue(field1, "", erro);
        return new MethodArgumentNotValidException(methodParameter, bindResult);
    }

    @Test
    void validationExceptions() throws NoSuchMethodException {
        String erro = "Não pode ser vazio!";
        MethodArgumentNotValidException exception = getMethodArgumentNotValidException(erro);
        ResponseEntity<RespostaErro> response = controllerExceptionHandler.handlerValidationExceptions(exception);
        RespostaErro respostaErro = new RespostaErro(Collections.singleton(erro));
        Assertions.assertThat(response).isEqualTo(ResponseEntity.badRequest().body(respostaErro));
    }

    @Test
    void formatoDataInvalido() {
        HttpMessageNotReadableException exception = new HttpMessageNotReadableException("", httpInputMessage);
        ResponseEntity<RespostaErro> response = controllerExceptionHandler.handlerFormatoDateTime(exception);
        RespostaErro respostaErro = new RespostaErro(Collections.singleton(FORMATO_DE_DATA_HORA_INVALIDA));
        Assertions.assertThat(response).isEqualTo(ResponseEntity.badRequest().body(respostaErro));
    }

}