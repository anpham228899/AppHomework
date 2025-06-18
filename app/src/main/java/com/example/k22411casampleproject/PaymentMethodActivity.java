package com.example.k22411casampleproject;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.adapters.PaymentMethodAdapter;
import com.example.connectors.PaymentMethodConnector;
import com.example.connectors.SQLiteConnector;
import com.example.models.ListPaymentMethod;
import com.example.models.PaymentMethod;

import java.util.ArrayList;
import android.util.Log;


public class PaymentMethodActivity extends AppCompatActivity {

    ListView lvPaymentMethod;
    PaymentMethodAdapter adapter;
    ListPaymentMethod lpm;
    PaymentMethodConnector pmc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_payment_method);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
    }

    private void addViews() {
        lvPaymentMethod = findViewById(R.id.lvPaymentMethod);
        adapter = new PaymentMethodAdapter(this, R.layout.item_payment_method);
        lvPaymentMethod.setAdapter(adapter);

        SQLiteConnector connector = new SQLiteConnector(this);
        SQLiteDatabase db = connector.openDatabase();

        pmc = new PaymentMethodConnector();
        ArrayList<PaymentMethod> datasets = pmc.getAllPaymentMethods(db);
        adapter.addAll(datasets);
        Log.d("DEBUG", "Dataset size: " + datasets.size());
    }
}