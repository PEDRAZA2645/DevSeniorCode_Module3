package com.devsenior.amoreno;

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
        var product = getProductByName(name);
        //Hay cantidad suficiente
        if (product.getStock() < quantity){
            System.out.println("No hay suficiente stock para el producto: " + name);
            return;
        }
        product.setStock(product.getStock() - quantity);
    }

    public Double calculateTotalInventory(){
        var total = 0d;
        for (var product : products) {
            total += product.getStock() * product.getPrice();
        }
        return total;
    }


    private Product getProductByName(String name){
        for(var product : products){
            if(name.equals(product.getName())){
                return product;
            }
        }
        return null;
    }
}
