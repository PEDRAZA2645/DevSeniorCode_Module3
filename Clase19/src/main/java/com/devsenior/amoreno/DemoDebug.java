package com.devsenior.amoreno;

import com.devsenior.amoreno.exception.InsufficientQuantityException;
import com.devsenior.amoreno.exception.NotFoundException;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class DemoDebug
{
    public static void main( String[] args ) {
        var log = LoggerFactory.getLogger(DemoDebug.class);
        var inventory = new Inventory();
        inventory.addProduct(new Product("Laptop", 1200d, 10));
        inventory.addProduct(new Product("Smartphone", 800.33, 5));
        inventory.addProduct(new Product("Tablet", 300d, 20));

        try{
            log.debug("Vendiendo el producto: 'laptop', cantidad: 5");
            inventory.sellProduct("laptop", 5);
            log.info("Se ha vendido 5 unidades de laptop");
        }catch (NotFoundException | InsufficientQuantityException e){
            log.error(e.getMessage(), e);
        }
        try {
            log.debug("Vendiendo el producto: 'phone', cantidad: 1");
            inventory.sellProduct("phone", 1);
            log.info("Se ha vendido 1 unidad de phone");
        } catch (NotFoundException | InsufficientQuantityException e) {
            log.error(e.getMessage(), e);
        }

        try {
            log.debug("Vendiendo el producto: 'tablet', cantidad: 2");
            inventory.sellProduct("tablet", 2);
            log.info("Se ha vendido 2 unidades de tablet");
        } catch (NotFoundException | InsufficientQuantityException e) {
            log.error(e.getMessage(), e);
        }

        try {
            log.debug("Vendiendo el producto: 'LAPTOP', cantidad: 6");
            inventory.sellProduct("LAPTOP", 6);
            log.info("Se ha vendido 6 unidades de LAPTOP");
        } catch (NotFoundException | InsufficientQuantityException e) {
            log.error(e.getMessage(), e);
        }
        try {
            inventory.sellProduct("Smartwatch", 1); // Producto no existe
        }catch (NotFoundException | InsufficientQuantityException e){
            log.error(e.getMessage(), e);
        }
        var totalInventory = inventory.calculateTotalInventory();
        System.out.printf("Total value of inventory: $ %.2f%n", totalInventory);
    }
}
