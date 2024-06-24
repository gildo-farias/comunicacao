package com.comunicacao.configuracao.controllers;

import com.comunicacao.controllers.respostas.RespostaErro;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerExceptionHandler {

    static final String FORMATO_DE_DATA_HORA_INVALIDA = "formato de data/hora inválida";

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RespostaErro> handlerValidationExceptions(MethodArgumentNotValidException ex) {
        Set<String> erros = ex.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toSet());
        return ResponseEntity.badRequest().body(new RespostaErro(erros));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<RespostaErro> handlerFormatoDateTime(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body(new RespostaErro(Collections.singleton(FORMATO_DE_DATA_HORA_INVALIDA)));
    }

}
