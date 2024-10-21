package com.example.registerlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class puzzleSuccess extends AppCompatActivity {
//    private Button nextlevel = findViewById(R.id.nextlevel);
//    private Button home = findViewById(R.id.home);

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzle_success);
    }

    public void home (View view) {
        Intent intent = new Intent(this, games.class);
        startActivity(intent);
        finish();
    }

    public void puzzle(View view) {
        Intent intent = new Intent(this, Puzzle.class);
        startActivity(intent);
        finish();
    }
}