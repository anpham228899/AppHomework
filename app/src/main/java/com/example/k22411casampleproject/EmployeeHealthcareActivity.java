package com.example.k22411casampleproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.utils.BMIStatus;
import com.example.utils.HealthCare;

public class EmployeeHealthcareActivity extends AppCompatActivity {

    EditText edtHeight;
    EditText edtWeight;
    Button btnCalculate;
    Button btnClose;
    Button btnClear;
    TextView txtResult;

    View.OnClickListener myClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_healthcare);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void addEvents(){
        myClick=new View.OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v){
                if(v.equals(btnCalculate)){
                    double h=Double.parseDouble(edtHeight.getText().toString());
                    double w=Double.parseDouble(edtWeight.getText().toString());
                    BMIStatus bmiStatus= HealthCare.calculate_bmi(h,w);
                    txtResult.setText(bmiStatus.getBMI()+"=>"+bmiStatus.getDescription());
                }
                else if (v.equals(btnClear)) {
                    edtHeight.setText("");
                    edtWeight.setText("");
                    txtResult.setText("");
                    edtHeight.requestFocus();
                }
                else if (v.equals(btnClose)) {
                    finish();
                }
            }
        };

        btnCalculate.setOnClickListener(myClick);
        btnClose.setOnClickListener(myClick);
        btnClear.setOnClickListener(myClick);

    }

    private void addViews(){
        txtResult=findViewById(R.id.txtResult);
        edtHeight=findViewById(R.id.edtHeight);
        edtWeight=findViewById(R.id.edtWeight);
        btnCalculate=findViewById(R.id.btnCalculate);
        btnClear=findViewById(R.id.btnClear);
        btnClose=findViewById(R.id.btnClose);
    }
}