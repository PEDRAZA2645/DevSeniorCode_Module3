package com.devsenior.amoreno.exception;

public class NotFoundException extends Exception {
    public NotFoundException(String name) {
        super("Producto no encontrado: " + name);
    }
}
