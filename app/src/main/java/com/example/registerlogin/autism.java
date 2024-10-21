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


public class autism extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private Button submitBtn;

    // Array of questions and their options
    private String[][] questions = {
            {"Question 1 Is old-fashioned or precocious? ", "1", "2", "3", "4"},
            {"Question 2 Has a different voice or speech?", "1", "2", "3", "4"},
            {"Question 3 Has a deviant style of communication with formal, fussy, old-fashioned, or 'robot-like' language?", "1", "2", "3", "4"},
            {"Question 4 Has clumsy, ill-coordinated, ungainly, awkward movements or gestures? ", "1", "2", "3", "4"},
            {"Question 5 Wishes to be sociable but fails to make relationships with peers?  ", "1", "2", "3", "4"},
            {"Question 6 Is regarded as an 'eccentric professor' by the other children? ", "1", "2", "3", "4"},
            {"Question 7 Expresses sounds involuntarily; clears throat, grunts, smacks, cries, or screams? ", "1", "2", "3", "4"},
            {"Question 8 Invents idiosyncratic words and expressions? ", "1", "2", "3", "4"},
            {"Question 9 Has involuntary face or body movements? ", "1", "2", "3", "4"},
            {"Question 10 Can be with other children but only on his/her terms? ", "1", "2", "3", "4"},
            {"Question 11 Lives somewhat in a world of his/her own with restricted idiosyncratic intellectual interests? ", "1", "2", "3", "4"},
            {"Question 12 Is surprisingly good at some things and surprisingly poor at others? ", "1", "2", "3", "4"},
            {"Question 13 Lacks best friend? ", "1", "2", "3", "4"},
            {"Question 14 Has difficulties in completing simple daily activities because of compulsory repetition of certain actions or thoughts? ", "1", "2", "3", "4"},
            {"Question 15 Lacks empathy? ", "1", "2", "3", "4"},
            {"Question 16 Accumulates facts on certain subjects (good rote memory) but does not really understand the meaning? ", "1", "2", "3", "4"},
            {"Question 17 Uses language freely but fails to make adjustments to fit social contexts or the needs of different listeners? ", "1", "2", "3", "4"},
            {"Question 18 Makes naive or embarrassing remarks? ", "1", "2", "3", "4"},
            {"Question 19 Is poor at games: no idea of cooperating in a team, scores 'own goals'? ", "1", "2", "3", "4"},
            {"Question 20 Has a literal understanding of ambiguous and metaphorical language? ", "1", "2", "3", "4"},
            {"Question 21 Has a deviant style of gaze?", "1", "2", "3", "4"},
            {"Question 22 Shows idiosyncratic attachment to objects?", "1", "2", "3", "4"},
            {"Question 23 Has special routines; insists on no change?", "1", "2", "3", "4"},
            {"Question 24 Has markedly unusual facial expression? ", "1", "2", "3", "4"},
            {"Question 25 Has markedly unusual posture?  ", "1", "2", "3", "4"},
            {"Question 26 Is bullied by other children? ", "1", "2", "3", "4"},
    };

    // Index to keep track of the current question
    private int currentQuestionIndex = 0;

    // Array to store selected options for each question
    private String[] selectedOptions = new String[questions.length];
    public static int aspergersyndrome ;
    public static int kannersyndrome;
    public static int rettsyndrome;
    public static int pervasivedevelopmentaldisorder;
    public static int childhooddisintegrativedisorder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autism);

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
                    Toast.makeText(autism.this, "Selected Option: " + selectedOption, Toast.LENGTH_SHORT).show();
                    // Move to the next question
                    currentQuestionIndex++;
                    if (currentQuestionIndex < questions.length) {
                        // Display the next question
                        displayQuestion();

                    } else {
                        // End of questions
                        Toast.makeText(autism.this, "End of questions", Toast.LENGTH_SHORT).show();
                        totalAnswer();
                        Intent intent = new Intent(autism.this, autismResult.class);
                        intent.putExtra("aspergersyndromeScore", aspergersyndrome);
                        intent.putExtra("kannersyndromeScore", kannersyndrome);
                        intent.putExtra("rettsyndromeScore", rettsyndrome);
                        intent.putExtra("pervasivedevelopmentaldisorderScore", pervasivedevelopmentaldisorder);
                        intent.putExtra("childhooddisintegrativedisorderScore", childhooddisintegrativedisorder);
                        startActivity(intent);
                        finish();
                        // You can perform any action here, like displaying a dyslexiaResult
                    }
                } else {
                    Toast.makeText(autism.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void totalAnswer(){
        aspergersyndrome = 0;
        kannersyndrome  = 0;
        rettsyndrome = 0;
        pervasivedevelopmentaldisorder=0;
        childhooddisintegrativedisorder=0;

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
        aspergersyndrome = answer1 + answer3 + answer6 + answer8 + answer11 + answer16 + answer21;
        kannersyndrome = answer2 + answer7 + answer12 + answer17 + answer20 + answer24;
        rettsyndrome = answer4 + answer9 + answer14 + answer22 + answer23;
        pervasivedevelopmentaldisorder= answer5 + answer10 + answer13 + answer19 + answer26;
        childhooddisintegrativedisorder= answer15 + answer18 + answer25;

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