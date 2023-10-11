package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        exerciseRVModalArrayList.add(new ExerciseRVModal("Планка",getResources().getString(R.string.Планка),"https://assets3.lottiefiles.com/packages/lf20_EOXjkv.json",20,10));
        exerciseRVModalArrayList.add(new ExerciseRVModal("Планка",getResources().getString(R.string.Планка),"https://assets3.lottiefiles.com/packages/lf20_EOXjkv.json",20,10));
        exerciseRVModalArrayList.add(new ExerciseRVModal("Планка",getResources().getString(R.string.Планка),"https://assets3.lottiefiles.com/packages/lf20_EOXjkv.json",20,10));
        exerciseRVModalArrayList.add(new ExerciseRVModal("Планка",getResources().getString(R.string.Планка),"https://assets3.lottiefiles.com/packages/lf20_EOXjkv.json",20,10));
        exerciseRVModalArrayList.add(new ExerciseRVModal("Планка",getResources().getString(R.string.Планка),"https://assets3.lottiefiles.com/packages/lf20_EOXjkv.json",20,10));
        exerciseRVAdapter.notifyDataSetChanged();
    }
    @Override
    public void onExerciseClick(int position) {

    }
}