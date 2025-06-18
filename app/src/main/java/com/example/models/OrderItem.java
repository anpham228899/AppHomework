package com.example.models;

public class OrderItem {
    private String productName;
    private int quantity;
    private int price;

    public OrderItem(String productName, int quantity, int price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public int getPrice() { return price; }

    public int getTotalValue() {
        return price * quantity;
    }
}

