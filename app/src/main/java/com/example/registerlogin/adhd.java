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


public class adhd extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private Button submitBtn;

    // Array of questions and their options
    private String[][] questions = {
            {"Question 1 How often do you have trouble wrapping up the final details of a project, once the challenging parts have been done? ", "1", "2", "3", "4"},
            {"Question 2 How often do you fidget or squirm with your hands or feet when you have to sit down for a long time?", "1", "2", "3", "4"},
            {"Question 3 How often do you have difficulty unwinding and relaxing when you have time to yourself?", "1", "2", "3", "4"},
            {"Question 4 How often do you have difficulty getting things in order when you have to do a task that requires organization? ", "1", "2", "3", "4"},
            {"Question 5 How often do you feel overly active and compelled to do things, like you were driven by a motor?  ", "1", "2", "3", "4"},
            {"Question 6 How often do you find yourself talking too much when you are in social situations? ", "1", "2", "3", "4"},
            {"Question 7 How often do you have problems remembering appointments or obligations? ", "1", "2", "3", "4"},
            {"Question 8 How often do you make careless mistakes when you have to work on a boring or difficult project? ", "1", "2", "3", "4"},
            {"Question 9 When you're in a conversation, how often do you find yourself finishing the sentences of the people you are talking to, before they can finish them themselves? ", "1", "2", "3", "4"},
            {"Question 10 When you have a task that requires a lot of thought, how often do you avoid or delay getting started? ", "1", "2", "3", "4"},
            {"Question 11 How often do you have difficulty keeping your attention when you are doing boring or repetitive work? ", "1", "2", "3", "4"},
            {"Question 12 How often do you have difficulty waiting your turn in situations when turn taking is required? ", "1", "2", "3", "4"},
            {"Question 13 How often do you have difficulty concentrating on what people say to you, even when they are speaking to you directly? ", "1", "2", "3", "4"},
            {"Question 14 How often do you leave your seat in meetings or other situations in which you are expected to remain seated? ", "1", "2", "3", "4"},
            {"Question 15 How often do you interrupt others when they are busy? ", "1", "2", "3", "4"},
            {"Question 16 How often do you misplace or have difficulty finding things at home or at work? ", "1", "2", "3", "4"},
            {"Question 17 How often do you feel restless or fidgety? ", "1", "2", "3", "4"},
            {"Question 18 How often are you distracted by activity or noise around you? ", "1", "2", "3", "4"},
    };

    // Index to keep track of the current question
    private int currentQuestionIndex = 0;

    // Array to store selected options for each question
    private String[] selectedOptions = new String[questions.length];
    public static int predominantlyinattentivepresentation ;
    public static int predominantlyhyperactiveimpulsivepresentation;
    public static int difficultygettingalongwithothers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adhd);

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
                    Toast.makeText(adhd.this, "Selected Option: " + selectedOption, Toast.LENGTH_SHORT).show();
                    // Move to the next question
                    currentQuestionIndex++;
                    if (currentQuestionIndex < questions.length) {
                        // Display the next question
                        displayQuestion();

                    } else {
                        // End of questions
                        Toast.makeText(adhd.this, "End of questions", Toast.LENGTH_SHORT).show();
                        totalAnswer();
                        Intent intent = new Intent(adhd.this, adhdResult.class);
                        intent.putExtra("predominantlyinattentivepresentationScore", predominantlyinattentivepresentation);
                        intent.putExtra("predominantlyhyperactiveimpulsivepresentationScore", predominantlyhyperactiveimpulsivepresentation);
                        intent.putExtra("difficultygettingalongwithothersScore", difficultygettingalongwithothers);
                        startActivity(intent);
                        finish();
                        // You can perform any action here, like displaying a dyslexiaResult
                    }
                } else {
                    Toast.makeText(adhd.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void totalAnswer(){
        predominantlyinattentivepresentation = 0;
        predominantlyhyperactiveimpulsivepresentation  = 0;
        difficultygettingalongwithothers = 0;

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
        predominantlyinattentivepresentation = answer1 + answer4 + answer7 + answer10 + answer13 + answer16 + answer18;
        predominantlyhyperactiveimpulsivepresentation = answer2 + answer5 + answer8 + answer11 + answer14 + answer17;
        difficultygettingalongwithothers = answer3 + answer6 + answer9 + answer12 + answer15;
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