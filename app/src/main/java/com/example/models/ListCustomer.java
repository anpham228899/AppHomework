package com.example.models;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class ListCustomer {
    private ArrayList<Customer> customers;

    public ListCustomer() {
        customers = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public boolean isExist(Customer c) {
        for (Customer existingCustomer : customers) {
            if (existingCustomer.getId() == c.getId() ||
                    existingCustomer.getPhone().equals(c.getPhone()) ||
                    existingCustomer.getEmail().equalsIgnoreCase(c.getEmail()) ||
                    existingCustomer.getUsername().equalsIgnoreCase(c.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public void getAllCustomers(SQLiteDatabase database) {
        customers.clear();

        // Step 1: Print all table names in the database
        Cursor tableCursor = database.rawQuery(
                "SELECT name FROM sqlite_master WHERE type='table'", null);
        ArrayList<String> tableNames = new ArrayList<>();
        if (tableCursor.moveToFirst()) {
            do {
                String tableName = tableCursor.getString(0);
                tableNames.add(tableName);
            } while (tableCursor.moveToNext());
        }
        tableCursor.close();
        Log.d("DB_TABLES", "Tables: " + tableNames);

        // Step 2: Check if "Customer" table exists
        if (!tableNames.contains("Customer")) {
            Log.e("DB_TABLES", "Table 'Customer' does NOT exist! Existing tables: " + tableNames);
            return;
        }

        // Step 3: Print columns of "Customer" table
        Cursor colCursor = database.rawQuery("PRAGMA table_info(Customer)", null);
        StringBuilder colInfo = new StringBuilder();
        while (colCursor.moveToNext()) {
            colInfo.append(colCursor.getString(colCursor.getColumnIndexOrThrow("name"))).append(", ");
        }
        colCursor.close();
        Log.d("CUSTOMER_COL", "Columns in Customer: " + colInfo.toString());

        // Step 4: Safe to query all customers
        Cursor cursor = database.rawQuery("SELECT * FROM Customers", null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String phone = cursor.getString(2);
            String email = cursor.getString(3);
            String username = cursor.getString(4);
            String password = cursor.getString(5);
            int saveInfor = cursor.getInt(6);

            Customer customer = new Customer();
            customer.setId(id);
            customer.setName(name);
            customer.setPhone(phone);
            customer.setEmail(email);
            customer.setUsername(username);
            customer.setPassword(password);
            // customer.setSaveInfor(saveInfor == 1);
            customers.add(customer);
        }
        cursor.close();
    }
}
