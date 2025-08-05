package com.devsenior.amoreno;

import org.apache.logging.log4j.LogManager;

public class CleintesPedidos
{
    public static void main( String[] args ) {

        var log = LogManager.getLogger(CleintesPedidos.class);
        log.info("inicia la ejecución del programa");
        var clientes = new GestionClientes();
        log.debug("Regfistando el cliente (1. Juan Perez)");
        clientes.registrarCliente("1", "Juan Perez");
        log.info("se creó el cliente Juan Perez con el id 1");
        log.debug("Registrando el cliente (2. Maria Lopez)");
        clientes.registrarCliente("2", "Maria Lopez");
        log.info("se creó el cliente Maria Lopez con el id 2");
        log.debug("Registrando el cliente (3. Carlos Sanchez)");
        clientes.registrarCliente("3", "Carlos Sanchez");
        log.info("se creó el cliente Carlos Sanchez con el id 3");

        var pedidos = new GestionPedidos(clientes);
        try {
            log.debug("Creando  el pedido (1. Laptop, 2 unidades)");
            pedidos.crearPedidos("1", "Laptop", 2);
            log.info("Se creó el pedido 1 para el cliente con id 1 correctamente");
            log.debug("Creando  el pedido (2. Smartphone, 1 unidad)");
            pedidos.crearPedidos("2", "Smartphone", 1);
            log.info("Se creó el pedido 2 para el cliente con id 2 correctamente");
            log.debug("Creando  el pedido (3. Monitor, 5 unidades)");
            pedidos.crearPedidos("4", "Tablet", 3);
            log.info("Se creó el pedido 3 para el cliente con id 4 correctamente");
        }catch (PedidoInvalidoException e){
            log.warn("No se pudo cargar el pedido: " + e.getMessage());
            System.err.println("Ha ocurrido un error al crear el pedido: " + e.getMessage());
        }
        System.out.println("Gracias por usar nuestro sistema de gestión de pedidos.");
        log.info("Salió de la aplicacion");
    }
}
