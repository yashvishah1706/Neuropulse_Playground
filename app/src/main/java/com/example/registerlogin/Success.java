package com.example.registerlogin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class Success extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success);
    }
    public void games(View view) {
        Intent intent = new Intent(this, games.class);
        startActivity(intent);
        finish();
    }


    public void detection(View view) {
        Intent intent = new Intent(this, disclaimer.class);
        startActivity(intent);
        finish();
    }

    public void community(View view) {
        Intent intent = new Intent(this, community.class);
        startActivity(intent);
        finish();
    }

    public void emergency(View view) {
        Intent intent = new Intent(this, mapbox.class);
        startActivity(intent);
        finish();
    }
    public void disclaimer(View view) {
        Intent intent = new Intent(this, disclaimer.class);
        startActivity(intent);
        finish();
    }

    public void aboutus(View view) {
        Intent intent = new Intent(this, Aboutus.class);
        startActivity(intent);
        finish();
    }

    public void home(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
