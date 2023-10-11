package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    private LinearLayout exerciseLL, stepCounterLL, bodymassLL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        exerciseLL = findViewById(R.id.idLLExercise);
        stepCounterLL = findViewById(R.id.idLLStepCounter);
        bodymassLL = findViewById(R.id.idLLBodyMass);

        exerciseLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ExerciseActivity.class);
                startActivity(i);
            }
        });

        stepCounterLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,StepCounterActivity.class);
                startActivity(i);
            }
        });
        bodymassLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,BodyMassActivity.class);
                startActivity(i);
            }
        });
    }
}