package com.devsenior.amoreno;

/**
 * Hello world!
 *
 */
public class DemoDebug
{
    public static void main( String[] args ) {
        var inventory = new Inventory();
        inventory.addProduct(new Product("Laptop", 1200d, 10));
        inventory.addProduct(new Product("Smartphone", 800.33, 5));
        inventory.addProduct(new Product("Tablet", 300d, 20));

        inventory.sellProduct("Laptop", 2);
        inventory.sellProduct("Smartphone", 1);
        inventory.sellProduct("Tablet", 3);
        inventory.sellProduct("Smartwatch", 1); // Producto no existe

        var totalInventory = inventory.calculateTotalInventory();
        System.out.printf("Total value of inventory: $ %.2f%n", totalInventory);
    }
}
