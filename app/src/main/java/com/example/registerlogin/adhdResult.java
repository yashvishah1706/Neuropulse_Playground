package com.example.registerlogin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class adhdResult extends AppCompatActivity {

    private TextView text;
    private Button predominantlyinattentivepresentation1,predominantlyhyperactiveimpulsivepresentation1,difficultygettingalongwithothers1;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adhd_result);
        text=findViewById(R.id.textView);
        predominantlyinattentivepresentation1 = findViewById(R.id.predominantlyinattentivepresentation);
        predominantlyhyperactiveimpulsivepresentation1 = findViewById(R.id.predominantlyhyperactiveimpulsivepresentation);
        difficultygettingalongwithothers1 = findViewById(R.id.difficultygettingalongwithothers);
        // Retrieve scores from Intent extras
        int predominantlyinattentivepresentation = getIntent().getIntExtra("predominantlyinattentivepresentationScore", 0);
        int predominantlyhyperactiveimpulsivepresentation = getIntent().getIntExtra("predominantlyhyperactiveimpulsivepresentationScore", 0);
        int difficultygettingalongwithothers = getIntent().getIntExtra("difficultygettingalongwithothersScore", 0);

        // Display scores in TextViews
        if(predominantlyinattentivepresentation>21){
            text.append("Your child is facing Predominantly Inattentive Presentation.");
            predominantlyinattentivepresentation1.setVisibility(View.VISIBLE);
        }
        if(predominantlyhyperactiveimpulsivepresentation>18){
            text.append("Your child is facing Predominantly Hyperactive Impulsive Presentation.");
            predominantlyhyperactiveimpulsivepresentation1.setVisibility(View.VISIBLE);
        }
        if(difficultygettingalongwithothers>15){
            text.append("Your child is facing Difficulty Getting Along With Others.");
            difficultygettingalongwithothers1.setVisibility(View.VISIBLE);
        }
    }

    public void home(View view) {
        Intent intent= new Intent(this, Success.class);
        startActivity(intent);
        finish();
    }

    public void predominantlyinattentivepresentation(View view) {
        Intent intent= new Intent(this, shape_quest_firstpage.class);
        startActivity(intent);
        finish();
    }

    public void predominantlyhyperactiveimpulsivepresentation(View view) {
        Intent intent= new Intent(this, chessfrontpage.class);
        startActivity(intent);
        finish();
    }

    public void difficultygettingalongwithothers(View view) {
        Intent intent= new Intent(this, Success.class);
        startActivity(intent);
        finish();
    }
}
