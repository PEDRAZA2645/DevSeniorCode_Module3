package com.devsenior.amoreno;

public class Pedido {
    private String clienteId;
    private String producto;
    private int cantidad;
    public Pedido(String clienteId, String producto, int cantidad) {
        this.clienteId = clienteId;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    @Override
    public String toString() {
        return String.format("pedido{clienteId='%s', producto='%s', cantidad=%d}", clienteId, producto, cantidad);
    }
}
