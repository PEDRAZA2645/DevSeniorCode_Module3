package com.devsenior.amoreno;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String name) {
        super("Producto no encontrado: " + name);
    }
}
