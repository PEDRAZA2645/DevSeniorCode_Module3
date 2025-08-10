package com.devsenior.amoreno;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryTest {

    private Inventory inventory;

    @BeforeEach
    void setup(){
        inventory = new Inventory();
    }

    @Test
    void testAddProductWhenProductIsEmpty() {
        //ESTANDAR (GIVEN - WHEN - THEN)
        //GIVEN
//        var inventory = new Inventory();
        var product = new Product("Laptop", 1200d, 10);
        var expectedTotal = 12000d; // 1200 * 10
        //WHEN
        inventory.addProduct(product);
        //THEN
        var calculatedTotal = inventory.calculateTotalInventory();
        assertEquals(expectedTotal, calculatedTotal);
    }

    @Test
    void testAddProductWhenProductAlreadyExistsWhitSamePrice() {
//        var inventory = new Inventory();
        // GIVEN
        var existingProduct = new Product("Laptop", 1200d, 10);
        inventory.addProduct(existingProduct);
        var newProduct = new Product("Laptop", 1200d, 5);
        var expectedTotal = 18000d; // (1200 * 10) + (1200 * 5)
        // WHEN
        inventory.addProduct(newProduct);
        // THEN
        var calculatedTotal = inventory.calculateTotalInventory();
        assertEquals(calculatedTotal, expectedTotal);
    }
}
