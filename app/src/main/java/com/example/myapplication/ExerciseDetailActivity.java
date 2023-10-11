package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class ExerciseDetailActivity extends AppCompatActivity {

    private TextView exerciseNameTV, caloriesTV, timeTV, descTV;
    private LottieAnimationView exerciseLAV;
    private String exerciseName, desc, imgUrl;
    private int calories,time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_detail);
        exerciseNameTV = findViewById(R.id.idTVExerciseName);
        caloriesTV = findViewById(R.id.idTVCalories);
        timeTV = findViewById(R.id.idTVTime);
        descTV = findViewById(R.id.idTVDescription);

        exerciseLAV = findViewById(R.id.idExerciseLAV);

        exerciseName = getIntent().getStringExtra("Название");
        desc = getIntent().getStringExtra("Описание");
        imgUrl = getIntent().getStringExtra("Изображение");
        calories = getIntent().getIntExtra("Калории",0);
        time = getIntent().getIntExtra("Время",0);

        exerciseNameTV.setText(exerciseName);
        caloriesTV.setText("Калории : " + calories);
        timeTV.setText("Время : " + time + " минут");
        descTV.setText(desc);
        exerciseLAV.setAnimationFromUrl(imgUrl);


    }
}