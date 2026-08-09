package com.example.madd_lab2_it22253262;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BillCalculatorActivity extends AppCompatActivity {

    EditText etUnits;
    TextView txtBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_calculator);

        etUnits = findViewById(R.id.etUnits);
        txtBill = findViewById(R.id.txtBill);
        Button btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(v -> {
            String unitsStr = etUnits.getText().toString().trim();
            if (unitsStr.isEmpty()) {
                txtBill.setText("Electricity Bill: Please enter units");
                return;
            }

            try {
                int units = Integer.parseInt(unitsStr);

                double fixedCharge = 150;
                double unitCost = 29;

                double amount = fixedCharge + (units * unitCost);
                double vat = amount * 0.15;
                double total = amount + vat;

                txtBill.setText("Electricity Bill: LKR " + String.format("%.2f", total));
            } catch (NumberFormatException e) {
                txtBill.setText("Electricity Bill: Invalid units entered");
            }
        });
    }
}
