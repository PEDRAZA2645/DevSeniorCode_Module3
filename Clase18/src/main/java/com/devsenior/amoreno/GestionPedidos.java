package com.devsenior.amoreno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GestionPedidos {

    private static final Logger LOG = LoggerFactory.getLogger(GestionPedidos.class);

    private List<Pedido> pedidos;
    private GestionClientes clientes;

    public GestionPedidos(GestionClientes clientes) {
        LOG.debug("Creando una instancia de pedidos");
        this.clientes = clientes;
        pedidos = new ArrayList<>();
    }
    public void crearPedidos(String clienteId, String producto, int cantidad) throws PedidoInvalidoException{
        LOG.trace("Creando una instancia de Gestion de pedidos");
        LOG.debug("Los parámetros recibidos son: {},{},{}", clienteId, producto, cantidad);
        try {
            var cliente = clientes.buscarCliente(clienteId);
            LOG.debug("El cliente del pedido es: {}", cliente);
        } catch (ClienteNoEncontradoException e) {
            LOG.warn("Cliente no encontrado: {}", clienteId);
            throw new PedidoInvalidoException("El cliente con id " + clienteId + ", no fue encontrado.");
        }

        // Producto nulo o vacío
        if (producto.isEmpty()) {
            LOG.warn("Producto no puede estar vacio");
            throw new PedidoInvalidoException("El producto no puede ser nulo o vacío.");
        }
            //Cantidad <=0
        if (cantidad<= 0) {
            LOG.warn("La cantidad debe ser mayor a cero");
            throw new PedidoInvalidoException("La cantidad debe ser mayor que cero.");
        }
        var pedido = new Pedido(clienteId, producto, cantidad);
        LOG.debug("Creando el pedido  {}", pedido);
        pedidos.add(pedido);
        LOG.info("Pedido creado correctamente: {}", pedido);
    }

    public Pedido buscarPedido(String clienteId, String producto){
        LOG.trace("Ingreso a buscar un pedido");
        LOG.debug("ingrsa con los datos: {}, {}", clienteId, producto);
        var cliente = clientes.buscarCliente(clienteId);
        for (var pedido : pedidos) {
            if (pedido.getClienteId().equals(clienteId)
                    && pedido.getProducto().equals(producto)) {
                return pedido;
            }
        }
        LOG.warn("El pedido no existe");
        return null;
    }
}
