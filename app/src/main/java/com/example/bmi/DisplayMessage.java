package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        TextView bmi = findViewById(R.id.bmi);
        TextView msg = findViewById(R.id.msg);

        Intent intent = getIntent();
         String BMI = getIntent().getStringExtra("BMI");
         String bmiDetails = getIntent().getStringExtra("key");
        bmi.setText(BMI);
        msg.setText(bmiDetails);

    }
}