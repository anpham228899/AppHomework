package com.example.k22411casampleproject;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.adapters.ProductAdapter;
import com.example.models.ListProduct;

public class AdvancedProductManagementActivity extends AppCompatActivity {
    ListView lvProduct;
    ProductAdapter adapter;
    ListProduct listProduct = new ListProduct();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_advanced_product_management);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.lvProduct), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addViews();
    }

    private void addViews() {
        lvProduct = findViewById(R.id.lvProduct);
        adapter = new ProductAdapter(this, R.layout.item_advanced_product);
        lvProduct.setAdapter(adapter);

        listProduct.generate_sample_products();
        adapter.addAll(listProduct.getProducts());
    }
}
