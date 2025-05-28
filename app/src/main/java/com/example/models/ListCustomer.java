package com.example.models;

import java.util.ArrayList;

public class ListCustomer {
    private ArrayList<Customer> customers;

    public ListCustomer() {
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer c) {
        customers.add(c);
    }
    public ArrayList<Customer> getCustomers() {return customers;}
    public void setCustomers(ArrayList<Customer> customers) {this.customers = customers;}
    public void generate_sample_dataset_customer() {
        addCustomer(new Customer(1, "An", "An@gmail.com", "09123456", "anpt14", "2702"));
        addCustomer(new Customer(2, "Binh", "Binh@gmail.com", "0988888", "binhpt14", "2710"));
        addCustomer(new Customer(3, "Chi", "Chi@gmail.com", "012938435", "chipt14", "2709"));
        addCustomer(new Customer(4, "Dung", "Dung@gmail.com", "0912487245", "dungpt14", "2708"));
        addCustomer(new Customer(5, "Yen", "Yen@gmail.com", "0913487125", "yenpt14", "2707"));
        addCustomer(new Customer(6, "Phuong", "Phuong@gmail.com", "0912478443", "phuongpt14", "2706"));
        addCustomer(new Customer(7, "Hien", "Hien@gmail.com", "0913457144", "hienpt14", "2705"));
        addCustomer(new Customer(8, "Kien", "Kien@gmail.com", "09138880", "kienpt14", "2704"));
        addCustomer(new Customer(9, "Long", "Long@gmail.com", "09131118888", "longpt14", "2703"));
        addCustomer(new Customer(10, "Minh", "Minh@gmail.com", "09138822288", "minhpt14", "1410"));
    }
    public boolean isExisting(Customer c){
        for (Customer cus : customers) {
            if (cus.getId()==c.getId() ||
                    cus.getEmail().equals(c.getEmail()) ||
                    cus.getPhone().equals(c.getPhone()) ||
                    cus.getUsername().equals(c.getUsername()))
                return true;
        }
        return false;
    }
}
