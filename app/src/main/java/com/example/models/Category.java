package com.example.models;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Category implements Serializable {
    private int id;
    private String name;
    private int image_id;
    private ArrayList<Product> products;

    public Category() {
        products = new ArrayList<>();
    }
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Category(int id, String name, int image_id) {
        this.id = id;
        this.name = name;
        this.image_id = image_id;
        products = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public String toString() {
        return id + " - " + name + " (Image ID: " + image_id + ")";
    }

    public void addProduct(Product p) {
        products.add(p);
    }
    public void removeProduct(int id) {
        Product p = null;
        for (Product i : products) {
            if (i.getId() == id) {
                p = i;
                break;
            }
            if (p != null)
                products.remove(p);
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return id == category.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}