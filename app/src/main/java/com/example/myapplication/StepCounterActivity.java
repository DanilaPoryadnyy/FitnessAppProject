package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class StepCounterActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private boolean running = false;
    private TextView stepsTV;
    private FloatingActionButton fab;
    float steps = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_counter);
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        stepsTV = findViewById(R.id.idTVSteps);
        fab = findViewById(R.id.idFAB);
        stepsTV.setText(String.valueOf(steps));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(running){
                    running = false;
                    fab.setImageResource(R.drawable.ic_play);
                    Toast.makeText(StepCounterActivity.this, "Счётчик остановлен...", Toast.LENGTH_SHORT).show();
                }else {
                    running = true;
                    fab.setImageResource(R.drawable.ic_pause);
                    Toast.makeText(StepCounterActivity.this, "Счётчик запущен...", Toast.LENGTH_SHORT).show();
                    startCounting();
                }
            }

            private void startCounting() {
                running = true;
                Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
                if(sensor!=null)
                {
                    Toast.makeText(StepCounterActivity.this, "Датчик запущен...", Toast.LENGTH_SHORT).show();
                    sensorManager.registerListener(StepCounterActivity.this, sensor, SensorManager.SENSOR_DELAY_FASTEST);
                }else {
                    Toast.makeText(StepCounterActivity.this, "Не найден датчик...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(running)
        {
            steps = steps + event.values[0];
            stepsTV.setText(String.valueOf(steps));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}