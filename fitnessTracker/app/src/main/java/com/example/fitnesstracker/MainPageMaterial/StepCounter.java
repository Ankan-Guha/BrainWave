package com.example.fitnesstracker.MainPageMaterial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.fitnesstracker.R;



public class StepCounter extends AppCompatActivity implements SensorEventListener {


    TextView step=findViewById(R.id.StepCounter);
    Button   start=findViewById(R.id.start);
    //EditText goal=findViewById(R.id.goal);
    private Sensor stepCounterSensor;
    private SensorManager sensorManager;
    private int steps=0;

    private boolean isSensorPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_counter);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sensorManager == null) {
                    sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
                }
                stepCounterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

                if (stepCounterSensor == null) {
                    // Handle sensor not available case (disable button, display message)
                    return;
                }

                // Start step counting logic (register listener, update button state)
                sensorManager.registerListener(StepCounter.this, stepCounterSensor, SensorManager.SENSOR_DELAY_NORMAL);
                start.setText("STOP");

            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor == stepCounterSensor)
        {
            steps=(int)event.values[0];
            step.setText(steps);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    @Override
    protected void onResume()
    {
        super.onResume();
        if(stepCounterSensor != null)
        {
            sensorManager.registerListener(this,stepCounterSensor,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        if(stepCounterSensor != null)
        {
            sensorManager.unregisterListener(this,stepCounterSensor);
        }
    }

}