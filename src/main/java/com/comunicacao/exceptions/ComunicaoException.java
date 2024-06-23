package com.comunicacao.exceptions;

public class ComunicaoException extends RuntimeException {
    public ComunicaoException(String causa) {
        super(causa);
    }
}
