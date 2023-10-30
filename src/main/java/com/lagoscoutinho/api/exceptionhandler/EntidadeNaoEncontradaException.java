package com.lagoscoutinho.api.exceptionhandler;

import com.lagoscoutinho.api.domain.model.exception.NegocioException;

public class EntidadeNaoEncontradaException extends NegocioException {

    private static final long serialVersionUID = 1L;
    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }
}
