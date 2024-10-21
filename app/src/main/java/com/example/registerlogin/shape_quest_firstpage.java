package com.example.registerlogin;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
public class shape_quest_firstpage extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000; // 2 seconds
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shape_quest_firstpage);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
// This method will be executed once the timer is over
// Start your app's next activity
                Intent i = new Intent(shape_quest_firstpage.this, shapeQuest.class);
                startActivity(i);
// Close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}