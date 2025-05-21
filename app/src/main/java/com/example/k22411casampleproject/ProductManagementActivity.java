package com.example.k22411casampleproject;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.models.Category;
import com.example.models.ListCategory;
import com.example.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductManagementActivity extends AppCompatActivity {

    Spinner spinnerCategory;
    ListView lvProduct;

    ArrayAdapter<Category> adapterCategory;
    ArrayAdapter<Product> adapterProduct;

    ListCategory listCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_management);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addViews();
        addEvents();
    }

    private void addViews() {
        spinnerCategory = findViewById(R.id.spinnerCategory);
        lvProduct = findViewById(R.id.lvProduct);

        adapterCategory = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapterCategory);

        adapterProduct = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        lvProduct.setAdapter(adapterProduct);

        listCategory = new ListCategory();
        listCategory.generate_sample_dataset_category();

        adapterCategory.addAll(listCategory.getCategories());
        adapterCategory.notifyDataSetChanged();
    }

    private void addEvents() {
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Category selectedCategory = adapterCategory.getItem(position);
                displayProductByCategory(selectedCategory);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    private void displayProductByCategory(Category selectedCategory) {
        if (selectedCategory == null) return;

        List<Product> filtered = selectedCategory.getProducts();

        adapterProduct.clear();
        adapterProduct.addAll(filtered);
        adapterProduct.notifyDataSetChanged();
    }
}
