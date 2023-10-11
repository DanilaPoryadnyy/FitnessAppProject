package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BodyMassActivity extends AppCompatActivity {
    private EditText editTextWeight;
    private EditText editTextHeight;
    private Button buttonCalculateIMT;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_mass);

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        buttonCalculateIMT = findViewById(R.id.buttonCalculateIMT);
        textViewResult = findViewById(R.id.textViewResult);

        buttonCalculateIMT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateIMT();
            }
        });
    }

    private void calculateIMT() {
        String weightStr = editTextWeight.getText().toString();
        String heightStr = editTextHeight.getText().toString();

        if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
            float weight = Float.parseFloat(weightStr);
            float height = Float.parseFloat(heightStr) / 100;
            float imt = weight / (height * height);

            String val = "";
            if(imt<17)
            {
                val = "Выраженный дефицит массы тела.";
            }
            if(imt>17 && imt<18)
            {
                val = "Дефицит массы тела.";
            }
            if(imt<25 && imt>18)
            {
                val = "Норма массы тела.";
            }
            if(imt>25 && imt<30)
            {
                val = "Избыточная масса тела.";
            }
            if(imt>30 && imt<35)
            {
                val = "Ожирение 1 степени.";
            }
            if(imt>35 && imt<40)
            {
                val = "Ожирение 2 степени.";
            }
            if(imt>40)
            {
                val = "Ожирение 3 степени.";
            }
            String result = "Ваш ИМТ: " + imt + " - у вас " + val;

            textViewResult.setText(result);
        }
    }
}