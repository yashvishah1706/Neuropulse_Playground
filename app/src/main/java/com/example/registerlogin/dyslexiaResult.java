package com.example.registerlogin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class dyslexiaResult extends AppCompatActivity {

    private TextView text;
    private Button phonologicaldyslexia1,doubledeficitdyslexia1,surfacedyslexia1,rapidnamingdyslexia1,visualdyslexia1;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autism_result);
        text=findViewById(R.id.textView);
        phonologicaldyslexia1 = findViewById(R.id.phonologicaldyslexia);
        doubledeficitdyslexia1 = findViewById(R.id.doubledeficitdyslexia);
        surfacedyslexia1 = findViewById(R.id.surfacedyslexia);
        rapidnamingdyslexia1 = findViewById(R.id.rapidnamingdyslexia);
        visualdyslexia1 = findViewById(R.id.visualdyslexia);

        // Retrieve scores from Intent extras
        int phonologicaldyslexia = getIntent().getIntExtra("phonologicaldyslexiaScore", 0);
        int doubledeficitdyslexia = getIntent().getIntExtra("doubledeficitdyslexiaScore", 0);
        int surfacedyslexia = getIntent().getIntExtra("surfacedyslexiaScore", 0);
        int rapidnamingdyslexia = getIntent().getIntExtra("rapidnamingdyslexiaScore", 0);
        int visualdyslexia = getIntent().getIntExtra("visualdyslexiaScore", 0);

        // Display scores in TextViews
        if(phonologicaldyslexia>21){
            text.append("Your child is facing Phonological Dyslexia.");
            phonologicaldyslexia1.setVisibility(View.VISIBLE);
        }
        if(doubledeficitdyslexia>15){
            text.append("Your child is facing Double Deficit Dyslexia.");
            doubledeficitdyslexia1.setVisibility(View.VISIBLE);
        }
        if(surfacedyslexia>15){
            text.append("Your child is facing Surface Dyslexia.");
            surfacedyslexia1.setVisibility(View.VISIBLE);
        }
        if(rapidnamingdyslexia>15){
            text.append("Your child is facing Rapid Naming Dyslexia.");
            rapidnamingdyslexia1.setVisibility(View.VISIBLE);
        }
        if(visualdyslexia>12){
            text.append("Your child is facing Visual Dyslexia.");
            visualdyslexia1.setVisibility(View.VISIBLE);
        }

    }
    public void home(View view) {
        Intent intent= new Intent(this, Success.class);
        startActivity(intent);
        finish();
    }

    public void phonologicaldyslexia(View view) {
        Intent intent= new Intent(this, Success.class);
        startActivity(intent);
        finish();
    }

    public void doubledeficitdyslexia(View view) {
        Intent intent= new Intent(this, word_main_start.class);
        startActivity(intent);
        finish();
    }

    public void surfacedyslexia(View view) {
        Intent intent= new Intent(this, Success.class);
        startActivity(intent);
        finish();
    }

    public void rapidnamingdyslexia(View view) {
        Intent intent= new Intent(this, Success.class);
        startActivity(intent);
        finish();
    }

    public void visualdyslexia(View view) {
        Intent intent= new Intent(this, Success.class);
        startActivity(intent);
        finish();
    }
}
