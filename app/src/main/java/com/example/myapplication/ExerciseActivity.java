package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ExerciseActivity extends AppCompatActivity implements ExerciseRVAdapter.ExerciseClickInterface{
    private RecyclerView exerciseRV;
    private ArrayList<ExerciseRVModal> exerciseRVModalArrayList;
    private ExerciseRVAdapter exerciseRVAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        exerciseRV = findViewById(R.id.idRVExercise);
        exerciseRVModalArrayList = new ArrayList<>();
        exerciseRVAdapter = new ExerciseRVAdapter(exerciseRVModalArrayList,this,this::onExerciseClick);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        exerciseRV.setLayoutManager(manager);
        exerciseRV.setAdapter(exerciseRVAdapter);
        addData();
    }

    private void addData()
    {
        exerciseRVModalArrayList.add(new ExerciseRVModal("Планка",getResources().getString(R.string.Планка),"https://assets3.lottiefiles.com/packages/lf20_EOXjkv.json",15,10));
        exerciseRVModalArrayList.add(new ExerciseRVModal("Выпады",getResources().getString(R.string.Выпады),"https://lottie.host/3d6e5689-5dce-4101-9f41-5d5349211f6b/PSsXiAusYw.json",20,10));
        exerciseRVModalArrayList.add(new ExerciseRVModal("Выпады на платформе",getResources().getString(R.string.Выпады),"https://lottie.host/9c6f179c-cdb8-43f6-8ee8-0ee44fbca348/3vrb6mqHpe.json",17,10));
        exerciseRVModalArrayList.add(new ExerciseRVModal("Пресс",getResources().getString(R.string.Пресс),"https://lottie.host/3d6e5689-5dce-4101-9f41-5d5349211f6b/PSsXiAusYw.json",14,10));
        exerciseRVModalArrayList.add(new ExerciseRVModal("Отжимания",getResources().getString(R.string.Отжимания),"https://lottie.host/c36786b0-d000-4c40-827d-d6ae933a114d/rZjIFwzauY.json",25,10));
        exerciseRVAdapter.notifyDataSetChanged();
    }
    @Override
    public void onExerciseClick(int position) {
        Intent i = new Intent(ExerciseActivity.this,ExerciseDetailActivity.class);
        i.putExtra("Название",exerciseRVModalArrayList.get(position).getExerciseName());
        i.putExtra("Изображение",exerciseRVModalArrayList.get(position).getImgUrl());
        i.putExtra("Время",exerciseRVModalArrayList.get(position).getTime());
        i.putExtra("Калории",exerciseRVModalArrayList.get(position).getCalories());
        i.putExtra("Описание",exerciseRVModalArrayList.get(position).getExerciseDescription());
        startActivity(i);

    }
}