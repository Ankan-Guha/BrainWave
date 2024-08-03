package com.example.fitnesstracker.MainPageMaterial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fitnesstracker.R;
import com.example.fitnesstracker.page1;

public class Bmi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);


        EditText height = findViewById(R.id.height);
        EditText weight= findViewById(R.id.weight);
        Button cal=findViewById(R.id.calculate);
        EditText res=findViewById(R.id.result);

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heightText=height.getText().toString();
                String weightText=weight.getText().toString();
                double h=Double.parseDouble(heightText)/100;
                int w=Integer.parseInt(weightText);
                double r=w/(h*h);
                res.setText(String.format("BMI=%.2f", r));
            }
        });

    }

}