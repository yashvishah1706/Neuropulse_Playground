package com.example.registerlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class dyslexia extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private Button submitBtn;

    // Array of questions and their options
    private String[][] questions = {
            {"Question 1 Do your eyes get tired if you read for a long time (at least 30 minutes)? ", "1", "2", "3", "4"},
            {"Question 2 In general, how would you rate your mental health, including your mood and your ability to think?", "1", "2", "3", "4"},
            {"Question 3 Do you sometimes have a hard time using the right words for objects?", "1", "2", "3", "4"},
            {"Question 4 Do you have a hard time reading maps or orienting yourself in a new place? ", "1", "2", "3", "4"},
            {"Question 5 Do you frequently use a computer mouse?  ", "1", "2", "3", "4"},
            {"Question 6 Do you read slowly and make mistakes when you read? ", "1", "2", "3", "4"},
            {"Question 7 How would you rate your satisfaction with your social activities and relationships? ", "1", "2", "3", "4"},
            {"Question 8 Do you skip words when you read? ", "1", "2", "3", "4"},
            {"Question 9 Do you remember a person's face better than you remember a name? ", "1", "2", "3", "4"},
            {"Question 10 Do these reading difficulties affect your daily life? ", "1", "2", "3", "4"},
            {"Question 11 Do these reading difficulties affect your work or studies? ", "1", "2", "3", "4"},
            {"Question 12 Do you confuse left and right? ", "1", "2", "3", "4"},
            {"Question 13 Do you wear glasses or contact lenses when reading on your computer or mobile device? ", "1", "2", "3", "4"},
            {"Question 14 Do you get tired or bored easily when you read? ", "1", "2", "3", "4"},
            {"Question 15 Have you noticed this reading problem since childhood? ", "1", "2", "3", "4"},
            {"Question 16 Please indicate whether you are using a touchpad, a mouse, or a touchscreen device.", "1", "2", "3", "4"},
            {"Question 17 Do you have trouble with spelling and punctuation? Do you make mistakes when spelling words like 'absence' and 'field'? ", "1", "2", "3", "4"},
            {"Question 18 Do you get nervous and anxious when you take tests? ", "1", "2", "3", "4"},
            {"Question 19 Did you have a hard time learning to read in school?", "1", "2", "3", "4"},
            {"Question 20 Do you skip lines when you read?", "1", "2", "3", "4"},
            {"Question 21 Do you prefer to type on a keyboard rather than write with a pen or pencil? ", "1", "2", "3", "4"},
            {"Question 22 Do you feel uncomfortable reading and writing in public in case you make a mistake?", "1", "2", "3", "4"},
            {"Question 23 Do you have to read something multiple times to understand what it's saying?", "1", "2", "3", "4"},
            {"Question 24 Do you have trouble measuring and organizing time? ", "1", "2", "3", "4"},
            {"Question 25 Have these reading/writing difficulties always been present?", "1", "2", "3", "4"},
            {"Question 26 Are you more intuitive and creative than analytical when you solve problems? ", "1", "2", "3", "4"},

    };

    // Index to keep track of the current question
    private int currentQuestionIndex = 0;

    // Array to store selected options for each question
    private String[] selectedOptions = new String[questions.length];
    public static int phonologicaldyslexia ;
    public static int doubledeficitdyslexia;
    public static int surfacedyslexia;
    public static int rapidnamingdyslexia;
    public static int visualdyslexia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dyslexia);

        // Initialize UI elements
        questionTextView = findViewById(R.id.questionTextView);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        submitBtn = findViewById(R.id.submitBtn);

        // Display initial question and options
        displayQuestion();

        // Set listener for submit button
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get selected radio button id
                int selectedRadioButtonId = optionsRadioGroup.getCheckedRadioButtonId();
                // Find selected radio button
                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);

                // Check if any option is selected
                if (selectedRadioButton != null) {
                    String selectedOption = selectedRadioButton.getText().toString();
                    // Store the selected option in the array
                    selectedOptions[currentQuestionIndex] = selectedOption;
                    // Display a toast message showing the selected option
                    Toast.makeText(dyslexia.this, "Selected Option: " + selectedOption, Toast.LENGTH_SHORT).show();
                    // Move to the next question
                    currentQuestionIndex++;
                    if (currentQuestionIndex < questions.length) {
                        // Display the next question
                        displayQuestion();

                    } else {
                        // End of questions
                        Toast.makeText(dyslexia.this, "End of questions", Toast.LENGTH_SHORT).show();
                        totalAnswer();
                        Intent intent = new Intent(dyslexia.this, dyslexiaResult.class);
                        intent.putExtra("phonologicaldyslexiaScore", phonologicaldyslexia);
                        intent.putExtra("doubledeficitdyslexiaScore", doubledeficitdyslexia);
                        intent.putExtra("surfacedyslexiaScore", surfacedyslexia);
                        intent.putExtra("rapidnamingdyslexiaScore", rapidnamingdyslexia);
                        intent.putExtra("visualdyslexiaScore", visualdyslexia);
                        startActivity(intent);
                        finish();
                        // You can perform any action here, like displaying a dyslexiaResult
                    }
                } else {
                    Toast.makeText(dyslexia.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void totalAnswer(){
        phonologicaldyslexia = 0;
        doubledeficitdyslexia  = 0;
        surfacedyslexia = 0;
        rapidnamingdyslexia=0;
        visualdyslexia=0;

        Integer answer1 = Integer.valueOf(selectedOptions[0]);
        Integer answer2 = Integer.valueOf(selectedOptions[1]);
        Integer answer3 = Integer.valueOf(selectedOptions[2]);
        Integer answer4 = Integer.valueOf(selectedOptions[3]);
        Integer answer5 = Integer.valueOf(selectedOptions[4]);
        Integer answer6 = Integer.valueOf(selectedOptions[5]);
        Integer answer7 = Integer.valueOf(selectedOptions[6]);
        Integer answer8 = Integer.valueOf(selectedOptions[7]);
        Integer answer9 = Integer.valueOf(selectedOptions[8]);
        Integer answer10 = Integer.valueOf(selectedOptions[9]);
        Integer answer11 = Integer.valueOf(selectedOptions[10]);
        Integer answer12 = Integer.valueOf(selectedOptions[11]);
        Integer answer13 = Integer.valueOf(selectedOptions[12]);
        Integer answer14 = Integer.valueOf(selectedOptions[13]);
        Integer answer15 = Integer.valueOf(selectedOptions[14]);
        Integer answer16 = Integer.valueOf(selectedOptions[15]);
        Integer answer17 = Integer.valueOf(selectedOptions[16]);
        Integer answer18 = Integer.valueOf(selectedOptions[17]);
        Integer answer19 = Integer.valueOf(selectedOptions[18]);
        Integer answer20 = Integer.valueOf(selectedOptions[19]);
        Integer answer21 = Integer.valueOf(selectedOptions[20]);
        Integer answer22 = Integer.valueOf(selectedOptions[21]);
        Integer answer23 = Integer.valueOf(selectedOptions[22]);
        Integer answer24 = Integer.valueOf(selectedOptions[23]);
        Integer answer25 = Integer.valueOf(selectedOptions[24]);
        Integer answer26 = Integer.valueOf(selectedOptions[25]);
        phonologicaldyslexia = answer1 + answer6 + answer11 + answer14 + answer18 + answer23 + answer26;
        doubledeficitdyslexia = answer2 + answer7 + answer15 + answer19 + answer24;
        surfacedyslexia = answer3 + answer8 + answer12 + answer20 + answer25;
        rapidnamingdyslexia= answer4 + answer9 + answer13 + answer16 + answer21;
        visualdyslexia= answer5 + answer10 + answer17 + answer22;

    }



    // Method to display the current question and options
    private void displayQuestion() {
        questionTextView.setText(questions[currentQuestionIndex][0]); // Question
        optionsRadioGroup.removeAllViews(); // Clear existing options

        // Add options dynamically
        for (int i = 1; i < questions[currentQuestionIndex].length; i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(questions[currentQuestionIndex][i]);
            optionsRadioGroup.addView(radioButton);
        }

    }


}