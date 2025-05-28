package com.example.k22411casampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.models.Product;

public class ProductDetailActivity extends AppCompatActivity {

    EditText edt_product_id;
    EditText edt_product_name;
    EditText edt_product_price;
    EditText edt_product_quantity;
    EditText edt_category_id;
    EditText edt_product_description;
    ImageView img_product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.lvProduct), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
    }

    private void addViews() {
        edt_product_id = findViewById(R.id.edtProductID);
        edt_product_name = findViewById(R.id.edtProductName);
        edt_product_price = findViewById(R.id.edtProductPrice);
        edt_product_quantity = findViewById(R.id.edtProductQuantity);
        edt_category_id = findViewById(R.id.edtProductCategoryID);
        edt_product_description = findViewById(R.id.edtProductDescription);
        img_product = findViewById(R.id.imgProductPreview);
        display_product_details();
    }

    private void display_product_details() {
        Intent intent = getIntent();
        Product p = (Product) intent.getSerializableExtra("Selected_Product");
        if (p != null) {
            edt_product_id.setText(String.valueOf(p.getId()));
            edt_product_name.setText(p.getName());
            edt_product_price.setText(String.valueOf(p.getPrice()));
            edt_product_quantity.setText(String.valueOf(p.getQuantity()));
            edt_category_id.setText(String.valueOf(p.getCateid()));
            edt_product_description.setText(p.getDescription());
            img_product.setImageResource(p.getImage_id());
        }
    }
}