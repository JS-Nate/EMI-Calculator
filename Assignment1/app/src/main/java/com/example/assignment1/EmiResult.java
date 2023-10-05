/*
 * Nathanael Selvaraj
 * 2023-10-04
 * 100783830
 */
package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.app.Activity;
import android.view.View;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;

public class EmiResult extends AppCompatActivity{

    private Button backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emi);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            // variables to receive from MainActivity
            double loanAmount = extras.getDouble("loanAmount", 0.0);
            double interestRate = extras.getDouble("interestRate", 0.0);
            double tenure = extras.getDouble("tenure", 0.0);
            double calculatedNumber = extras.getDouble("calculatedEMI", 0.0);

            // formats the emi to 2 decimal places into a string
            DecimalFormat decimalFormat = new DecimalFormat("#.##"); // Define the format
            String calculatedEMI = decimalFormat.format(calculatedNumber);

            // TextView variables to display the above variables in the same views in the layout file
            TextView loanAmountTextView = findViewById(R.id.loanAmount);
            TextView interestRateTextView = findViewById(R.id.interestRate);
            TextView tenureTextView = findViewById(R.id.tenure);
            TextView calculatedNumberTextView = findViewById(R.id.result);

            // Display the inputs and emi result
            loanAmountTextView.setText("$" + loanAmount);
            interestRateTextView.setText(interestRate + "%");
            tenureTextView.setText(tenure + " months");
            calculatedNumberTextView.setText("$" + calculatedEMI + "/monthly");

        }

        // Back button to return to the main page
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(EmiResult.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

