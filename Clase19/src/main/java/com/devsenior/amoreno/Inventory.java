package com.devsenior.amoreno;

import com.devsenior.amoreno.exception.InsufficientQuantityException;
import com.devsenior.amoreno.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Product> products;

    public Inventory(){
        products = new ArrayList<>();
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void sellProduct(String name, Integer quantity) {
        try {
            var product = getProductByName(name);

            if (product.getStock() < quantity){
                throw new InsufficientQuantityException("El Producto '" + name + "' no tiene stock suficiente");
            }
            product.setStock(product.getStock() - quantity);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    public Double calculateTotalInventory(){
        var total = 0d;
        for (var product : products) {
            total += product.getStock() * product.getPrice();
        }
        return total;
    }


    private Product getProductByName(String name) throws NotFoundException{
        for(var product : products){
            if(name.equalsIgnoreCase(product.getName())){
                return product;
            }
        }
        throw new NotFoundException("Producto '" + name + "' no encontrado");
    }
}
