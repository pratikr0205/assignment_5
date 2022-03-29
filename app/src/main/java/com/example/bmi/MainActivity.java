package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button submit = findViewById(R.id.submit);
        EditText kg = findViewById(R.id.kg);
        EditText ht = findViewById(R.id.ht);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),DisplayMessage.class);
                double bmi = Double.parseDouble(kg.getText().toString())/
                        (Double.parseDouble(ht.getText().toString()) * Double.parseDouble(ht.getText().toString())) ;
                String BMI = String.valueOf( (Math.round( bmi * 100) ) /100);
                      i.putExtra("BMI", BMI);

                if(bmi < 16 ){
                    i.putExtra("key","Underweight (Severe thinness)");
                }
                else if(bmi <= 16.9 && bmi >= 16){
                    i.putExtra("key","Underweight (Moderate thinness)");
                }
                else if (bmi>= 17 && bmi<= 18.4){
                    i.putExtra("key","Underweight (Mild thinness)");
                }
                else if(bmi>= 18.5 && bmi<= 24.9){
                    i.putExtra("key","Normal range");
                }
                else if(bmi>= 25 && bmi<= 29.9){
                    i.putExtra("key","Overweight (Pre-obese)");
                }
                else if(bmi>= 30 && bmi<= 34.9){
                    i.putExtra("key","Obese (Class I)");
                }
                else if(bmi>= 35 && bmi<= 39.9){
                    i.putExtra("key","Obese (Class II)");
                }

                else {
                    i.putExtra("key","Obese (Class III)");
                }

                startActivity(i);
            }
        });

    }
}