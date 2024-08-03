package com.example.fitnesstracker.MainPageMaterial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.fitnesstracker.HomeActivity;
import com.example.fitnesstracker.R;
import com.example.fitnesstracker.page1;

public class profile extends AppCompatActivity {

    TextView logout;
    TextView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        TextView logout=findViewById(R.id.logout);
        TextView back=  findViewById(R.id.back);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(profile.this, HomeActivity.class));
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(profile.this, page1.class));
            }
        });
    }
}