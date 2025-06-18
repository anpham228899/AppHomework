package com.example.k22411casampleproject;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapters.OrderItemAdapter;
import com.example.connectors.OrderDetailConnector;
import com.example.connectors.SQLiteConnector;
import com.example.models.OrderItem;
import com.example.models.OrdersViewer;

import java.util.ArrayList;

public class OrderDetailActivity extends AppCompatActivity {
    TextView txtOrderCode, txtOrderDate, txtEmployeeName, txtCustomerName, txtTotalValue;
    RecyclerView rvOrderItems;
    OrderItemAdapter itemAdapter;
    ArrayList<OrderItem> itemList;

    OrdersViewer order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        addViews();

        order = (OrdersViewer) getIntent().getSerializableExtra("order_obj");
        if (order == null) {
            Toast.makeText(this, "Order data not found!", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        loadOrderData();
        loadOrderItems();
    }

    private void addViews() {
        txtOrderCode = findViewById(R.id.txtOrderCode);
        txtOrderDate = findViewById(R.id.txtOrderDate);
        txtEmployeeName = findViewById(R.id.txtEmployeeName);
        txtCustomerName = findViewById(R.id.txtCustomerName);
        txtTotalValue = findViewById(R.id.txtTotalValue);
        rvOrderItems = findViewById(R.id.rvOrderItems);
    }

    private void loadOrderData() {
        String orderCode = (order.getCode() != null) ? order.getCode().toString() : "N/A";
        txtOrderCode.setText("Order ID: " + orderCode);

        int orderDate = order.getOrderDate();
        txtOrderDate.setText("Order Date: " + (orderDate > 0 ? String.valueOf(orderDate) : "N/A"));

        txtEmployeeName.setText("Employee: " + (order.getEmployeeName() != null ? order.getEmployeeName() : "N/A"));
        txtCustomerName.setText("Customer: " + (order.getCustomerName() != null ? order.getCustomerName() : "N/A"));
    }

    private void loadOrderItems() {
        int orderId = getIntent().getIntExtra("order_id", -1);
        if (orderId == -1) {
            Log.e("DEBUG", "Invalid order_id received!");
            return;
        }

        SQLiteConnector connector = new SQLiteConnector(this);
        OrderDetailConnector odc = new OrderDetailConnector();
        itemList = odc.getOrderItemsByOrderId(connector.openDatabase(), orderId);

        itemAdapter = new OrderItemAdapter(this, itemList);
        rvOrderItems.setLayoutManager(new LinearLayoutManager(this));
        rvOrderItems.setAdapter(itemAdapter);

        int grandTotal = 0;
        for (OrderItem item : itemList) {

            grandTotal += item.getTotalValue();
        }
        txtTotalValue.setText("Total: " + grandTotal + " VND");
    }
}
