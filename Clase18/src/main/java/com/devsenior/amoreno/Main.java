package com.devsenior.amoreno;

public class Main
{
    public static void main( String[] args ) {
        var clientes = new GestionClientes();
        clientes.registrarCliente("1", "Juan Perez");
        clientes.registrarCliente("2", "Maria Lopez");
        clientes.registrarCliente("3", "Carlos Sanchez");

        var pedidos = new GestionPedidos(clientes);
        try {
           pedidos.crearPedidos("1", "Laptop", 2);
           pedidos.crearPedidos("2", "Smartphone", 1);
           pedidos.crearPedidos("4", "Tablet", 3);
        }catch (PedidoInvalidoException e){
           System.err.println("Ha ocurrido un error al crear el pedido: " + e.getMessage());
        }
        System.out.println("Gracias por usar nuestro sistema de gestión de pedidos.");
    }
}
