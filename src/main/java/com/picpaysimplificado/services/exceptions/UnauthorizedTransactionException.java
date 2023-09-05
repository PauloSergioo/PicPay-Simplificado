package com.picpaysimplificado.services.exceptions;

public class UnauthorizedTransactionException extends RuntimeException{

    public UnauthorizedTransactionException(String msg) {
        super(msg);
    }
}
