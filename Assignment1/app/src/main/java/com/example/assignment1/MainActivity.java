/*
* Nathanael Selvaraj
* 2023-10-04
* 100783830
*/
package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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
//import androidx.navigation.fragment.NavHostFragment;
import androidx.fragment.app.Fragment;

public class MainActivity extends Activity {


    private EditText loanAmountEditText;
    private EditText interestRateEditText;
    private EditText tenureEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loanAmountEditText = findViewById(R.id.loanAmount);
        interestRateEditText = findViewById(R.id.interestRate);
        tenureEditText = findViewById(R.id.tenure);
        calculateButton = findViewById(R.id.calculate);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                double loanAmount = Double.parseDouble(loanAmountEditText.getText().toString());
                double interestRate = Double.parseDouble(interestRateEditText.getText().toString());
                double tenure = Double.parseDouble(tenureEditText.getText().toString());
                double CalculatedEMI = calculateEMI(loanAmount, interestRate, tenure);

                Intent intent = new Intent(MainActivity.this, EmiResult.class);
                intent.putExtra("loanAmount", loanAmount);
                intent.putExtra("interestRate", interestRate);
                intent.putExtra("tenure", tenure);
                intent.putExtra("calculatedEMI", CalculatedEMI);
                startActivity(intent);

            }

        });
    }

    private double calculateEMI(double loan, double interest, double tenure){
        double monthlyInterestRate = (interest / 12) / 100;
        double emi = (loan * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, tenure)) / (Math.pow(1 + monthlyInterestRate, tenure) - 1);
        return emi;
    }

}