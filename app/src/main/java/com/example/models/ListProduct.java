package com.example.models;

import com.example.k22411casampleproject.R;

import java.util.ArrayList;

public class ListProduct {
    ArrayList<Product> products;

    public ListProduct() {
        products = new ArrayList<>();
    }

    public void generate_sample_products() {
        Product p1 = new Product(1, "Coca Cola", 100, 10.0, 200, R.mipmap.coca);
        Product p2 = new Product(2, "Pepsi", 120, 9.5, 180,R.mipmap.coca);
        Product p3 = new Product(3, "7Up", 90, 8.0, 150,R.mipmap.coca);
        Product p4 = new Product(4, "Fanta", 85, 8.5, 160, R.mipmap.coca);
        Product p5 = new Product(5, "Sprite", 95, 9.0, 170, R.mipmap.coca);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
    }


    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}