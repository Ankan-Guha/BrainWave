package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import com.example.fitnesstracker.MainPageMaterial.Bmi;
import com.example.fitnesstracker.MainPageMaterial.Exercises.MainExercise;
import com.example.fitnesstracker.MainPageMaterial.StepCounter;
import com.example.fitnesstracker.MainPageMaterial.meal_plans.MainMeal;
import com.example.fitnesstracker.MainPageMaterial.profile;

public class page1 extends AppCompatActivity {
    Button profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        //drop down menu
        profile=findViewById(R.id.dropdown_menu);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(page1.this, profile.class));
            }
        });

        //BMI
        CardView bmi=findViewById(R.id.bmi);
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(page1.this, Bmi.class));
            }
        });

        //STEP COUNTER
        CardView stepCounter=findViewById(R.id.StepCounter);
        stepCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(page1.this, StepCounter.class));
            }
        });

        //Meal plan
        CardView meal=findViewById(R.id.meal);
        meal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(page1.this, MainMeal.class));
            }
        });

        //Exercise
        CardView exercise=findViewById(R.id.exercise);
        exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(page1.this, MainExercise.class));
            }
        });


    }

}