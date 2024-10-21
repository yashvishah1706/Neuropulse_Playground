package com.example.registerlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class detection extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detection);
    }

    public void adhd(View view) {
        Intent intent=new Intent(this, adhd.class);
        startActivity(intent);
        finish();
    }

    public void dyslexia(View view) {
        Intent intent=new Intent(this, dyslexia.class);
        startActivity(intent);
        finish();
    }

    public void autism(View view) {
        Intent intent=new Intent(this, autism.class);
        startActivity(intent);
        finish();
    }
    public void home(View view) {
        Intent intent=new Intent(this, Success.class);
        startActivity(intent);
        finish();
    }
}