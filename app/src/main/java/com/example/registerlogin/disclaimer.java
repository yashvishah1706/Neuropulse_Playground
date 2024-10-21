package com.example.registerlogin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class disclaimer extends AppCompatActivity {
    Button accept,reject;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disclaimer);
        accept = findViewById(R.id.accept);
        reject = findViewById(R.id.reject);
}
    public void accept(View view) {
        Intent intent = new Intent(disclaimer.this, detection.class);
        startActivity(intent);
        finish();
    }
    public void reject(View view) {
        Intent intent = new Intent(disclaimer.this, Success.class);
        startActivity(intent);
        finish();
    }
}
