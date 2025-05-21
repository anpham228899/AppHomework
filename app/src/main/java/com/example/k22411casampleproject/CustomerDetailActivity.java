package com.example.k22411casampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.models.Customer;

public class CustomerDetailActivity extends AppCompatActivity {
    EditText edt_customer_id;
    EditText edt_customer_name;
    EditText edt_customer_email;
    EditText edt_customer_phone;
    EditText edt_customer_username;
    EditText edt_customer_password;
    Button btn_new;
    Button btn_save;
    Button btn_remove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_customer_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();

    }

    private void addViews() {
        edt_customer_id=findViewById(R.id.edtCustomerID);
        edt_customer_name=findViewById(R.id.edtCustomerName);
        edt_customer_email=findViewById(R.id.edtCustomerEmail);
        edt_customer_phone=findViewById(R.id.edtCustomerPhone);
        edt_customer_username=findViewById(R.id.edtCustomerUserName);
        edt_customer_password=findViewById(R.id.edtCustomerPassword);
        btn_new=findViewById(R.id.btnNew);
        btn_save=findViewById(R.id.btnSave);
        btn_remove=findViewById(R.id.btnRemove);
        display_customer_details();
    }

    private void display_customer_details() {
        Intent intent=getIntent();
        Customer c=(Customer) intent.getSerializableExtra("Selected_Customer");
        edt_customer_id.setText(c.getId()+"");
        edt_customer_name.setText(c.getName());
        edt_customer_email.setText(c.getEmail());
        edt_customer_phone.setText(c.getPhone());
        edt_customer_username.setText(c.getUsername());
        edt_customer_password.setText(c.getPassword());

    }
}