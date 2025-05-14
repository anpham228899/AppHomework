package com.example.models;

import java.util.ArrayList;

public class ListProduct {
    private ArrayList<Product> products;

    public ListProduct() { products = new ArrayList<>();
    }
    public void addProduct(Product p){
        products.add(p);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    public void generate_sample_dataset_product() {
        addProduct(new Product(10, "Bottle", 12, 12000, 34));
        addProduct(new Product(11, "Cup", 13, 12000, 34));
        addProduct(new Product(12, "Vase", 14, 12000, 14));
        addProduct(new Product(13, "Laptop", 15, 12000, 34));
        addProduct(new Product(14, "Mouse", 16, 12000, 54));
        addProduct(new Product(15, "Pen", 16, 12000, 24));
        addProduct(new Product(16, "Pencil", 9, 12000, 12));
    }
}
