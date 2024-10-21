package com.example.registerlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class games extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.games);
    }

    public void chess(View view) {
        Intent intent=new Intent(this, chessfrontpage.class);
        startActivity(intent);
        finish();
    }

    public void word(View view) {
        Intent intent=new Intent(this, word_main_start.class);
        startActivity(intent);
        finish();
    }

    public void memory(View view) {
        Intent intent=new Intent(this, MemoryGame.class);
        startActivity(intent);
        finish();
    }

    public void anagram(View view) {
        Intent intent=new Intent(this, Anagram.class);
        startActivity(intent);
        finish();
    }

    public void puzzle(View view) {
        Intent intent=new Intent(this, Puzzle.class);
        startActivity(intent);
        finish();
    }

    public void shapequest(View view) {
        Intent intent=new Intent(this, shape_quest_firstpage.class);
        startActivity(intent);
        finish();
    }

    public void home(View view) {
        Intent intent=new Intent(this, Success.class);
        startActivity(intent);
        finish();
    }
}
