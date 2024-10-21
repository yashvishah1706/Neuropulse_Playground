package com.example.registerlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class autismResult extends AppCompatActivity {

    private TextView text;
    private Button aspergersyndrome1,kannersyndrome1,rettsyndrome1,pervasivedevelopmentaldisorder1,childhooddisintegrativedisorder1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autism_result);
        text=findViewById(R.id.textView);
        aspergersyndrome1 = findViewById(R.id.aspergersyndrome);
        kannersyndrome1 = findViewById(R.id.kannersyndrome);
        rettsyndrome1 = findViewById(R.id.rettsyndrome);
        pervasivedevelopmentaldisorder1 = findViewById(R.id.pervasivedevelopmentaldisorder);
        childhooddisintegrativedisorder1 = findViewById(R.id.childhooddisintegrativedisorder);

        // Retrieve scores from Intent extras
        int aspergersyndrome = getIntent().getIntExtra("aspergersyndromeScore", 0);
        int kannersyndrome = getIntent().getIntExtra("kannersyndromeScore", 0);
        int rettsyndrome = getIntent().getIntExtra("rettsyndromeScore", 0);
        int pervasivedevelopmentaldisorder = getIntent().getIntExtra("pervasivedevelopmentaldisorderScore", 0);
        int childhooddisintegrativedisorder = getIntent().getIntExtra("childhooddisintegrativedisorderScore", 0);

        // Display scores in TextViews
        if(aspergersyndrome>21){
            text.append("Your child is facing Asperger's Syndrome.");
            aspergersyndrome1.setVisibility(View.VISIBLE);
        }
        if(kannersyndrome>18){
            text.append("Your child is facing Kanner's Syndrome.");
            kannersyndrome1.setVisibility(View.VISIBLE);
        }
        if(rettsyndrome>15){
            text.append("Your child is facing Rett's Syndrome.");
            rettsyndrome1.setVisibility(View.VISIBLE);
        }
        if(pervasivedevelopmentaldisorder>15){
            text.append("Your child is facing Pervasive Development Disorder.");
            pervasivedevelopmentaldisorder1.setVisibility(View.VISIBLE);
        }
        if(childhooddisintegrativedisorder>9){
            text.append("Your child is facing Childhood Disintegrative Disorder.");
            childhooddisintegrativedisorder1.setVisibility(View.VISIBLE);
        }

    }
    public void home(View view) {
        Intent intent= new Intent(this, Success.class);
        startActivity(intent);
        finish();
    }

    public void aspergersyndrome(View view) {
        Intent intent= new Intent(this, Success.class);
        startActivity(intent);
        finish();
    }

    public void kannersyndrome(View view) {
        Intent intent=new Intent(this, Puzzle.class);
        startActivity(intent);
        finish();
    }

    public void rettsyndrome(View view) {
        Intent intent=new Intent(this, Anagram.class);
        startActivity(intent);
        finish();
    }

    public void pervasivedevelopmentaldisorder(View view) {
        Intent intent=new Intent(this, MemoryGame.class);
        startActivity(intent);
        finish();
    }

    public void childhooddisintegrativedisorder(View view) {
        Intent intent=new Intent(this, Success.class);
        startActivity(intent);
        finish();
    }
}
