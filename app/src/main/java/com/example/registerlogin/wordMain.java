package com.example.registerlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class wordMain extends AppCompatActivity {

    private ImageView imageView;
    private Button option1, option2, option3, option4, home;
    private List<String> options;
    private String correctOption;

    private int correctCounter; // Counter for correct answers
    private int questionCounter; // Counter for total questions asked

    private TextView scoreTextView; // Declare the TextView variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_main);

        // Find the TextView by its ID
        scoreTextView = findViewById(R.id.scoreTextView);

        imageView = findViewById(R.id.imageView);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        home = findViewById(R.id.home);

        options = new ArrayList<>();
        options.add("Apple");
        options.add("Banana");
        options.add("Orange");
        options.add("Grapes");
        options.add("Strawberry");
        options.add("Tomato");
        options.add("Potato");
        options.add("Watermelon");
        options.add("Onion");
        options.add("Cabbage");

        setupGame();
    }

    private void setupGame() {

        // Shuffle the remaining options
        Collections.shuffle(options);
        correctOption = options.get(0);

        int resourceId = getResources().getIdentifier(correctOption.toLowerCase(), "drawable", getPackageName());
        imageView.setImageResource(resourceId);

        // Generate a random index to place the correct answer on one of the buttons
        int correctButtonIndex = new Random().nextInt(4);

        switch (correctButtonIndex) {
            case 0:
                option1.setText(correctOption);
                option2.setText(options.get(1));
                option3.setText(options.get(2));
                option4.setText(options.get(3));
                break;
            case 1:
                option1.setText(options.get(1));
                option2.setText(correctOption);
                option3.setText(options.get(2));
                option4.setText(options.get(3));
                break;
            case 2:
                option1.setText(options.get(1));
                option2.setText(options.get(2));
                option3.setText(correctOption);
                option4.setText(options.get(3));
                break;
            case 3:
                option1.setText(options.get(1));
                option2.setText(options.get(2));
                option3.setText(options.get(3));
                option4.setText(correctOption);
                break;
        }

    }

    public void checkAnswer(View view) {
        Button selectedOption = (Button) view;
        String selectedText = selectedOption.getText().toString();

        if (selectedText.equals(correctOption)) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            correctCounter++; // Increment correct answer counter
        } else {
            Toast.makeText(this, "Wrong/Try again", Toast.LENGTH_SHORT).show();
        }

        questionCounter++; // Increment question counter

        if (questionCounter < 10) {
            setupGame(); // If not all questions have been answered, set up the next question
        } else {
            endGame(); // If all questions have been answered, end the game
        }


    }
    private void endGame() {
        // Display the score in the TextView
        scoreTextView.setText("Score: " + correctCounter + "/10");

        // Change the visibility of the TextView to VISIBLE
        scoreTextView.setVisibility(View.VISIBLE);
        home.setVisibility(View.VISIBLE);

        // Reset counters for a new game
        correctCounter = 0;
        questionCounter = 0;

        // Disable further interaction with the options
        option1.setEnabled(false);
        option2.setEnabled(false);
        option3.setEnabled(false);
        option4.setEnabled(false);
    }

    public void Home(View view) {
        Intent intent=new Intent(this,games.class);
        startActivity(intent);
        finish();
    }
}