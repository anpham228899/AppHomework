package com.example.k22411casampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.models.Category;
import com.example.models.ListCategory;
import com.example.models.Product;

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

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
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

        lvProduct.setOnItemClickListener((adapterView, view, i, l) -> {
            Product p = adapterProduct.getItem(i);
            openProductDetailActivity(p);
        });
    }

    private void displayProductByCategory(Category selectedCategory) {
        if (selectedCategory == null) return;

        List<Product> filtered = selectedCategory.getProducts();

        adapterProduct.clear();
        adapterProduct.addAll(filtered);
        adapterProduct.notifyDataSetChanged();
    }

    private void openProductDetailActivity(Product p) {
        Intent intent = new Intent(ProductManagementActivity.this, ProductDetailActivity.class);
        intent.putExtra("Selected_Product", p);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu_product, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_create_new_product) {
            Toast.makeText(this, "Create new product", Toast.LENGTH_LONG).show();
            openNewProductActivity();
        } else if (item.getItemId() == R.id.menu_edit_product_list) {
            Toast.makeText(this, "Edit product list", Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.menu_help) {
            Toast.makeText(this, "Help", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void openNewProductActivity() {

    }
}
