package com.devsenior.amoreno;

public class ClienteNoEncontradoException extends RuntimeException{
    public ClienteNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
