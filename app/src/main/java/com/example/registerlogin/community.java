package com.example.registerlogin;

import static com.example.registerlogin.R.id.likeDislikeLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class community extends AppCompatActivity {
    EditText editTextQuery;
    public static TextView postTextView;
    Button buttonPost;
    ImageButton like,dislike,notlike,notdislike;
    LinearLayout postLayout,likeDislikeLayout;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    // Map to store predefined questions and replies
    Map<String, String> predefinedReplies;
    Map<String, String> pastQueries;

    public static TextView postText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.community);

        editTextQuery = findViewById(R.id.editTextQuery);
        buttonPost = findViewById(R.id.buttonPost);
        likeDislikeLayout = findViewById(R.id.likeDislikeLayout);
        postLayout = findViewById(R.id.postLayout);
        like = findViewById(R.id.buttonlike);
        dislike = findViewById(R.id.buttondislike);
        notlike = findViewById(R.id.buttonlike1);
        notdislike = findViewById(R.id.buttondislike1);

        sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        // Initialize predefined questions and replies
        initPredefinedReplies();

        // Load past queries from SharedPreferences
        loadPastQueries();

        buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                like.setVisibility(View.VISIBLE);
                dislike.setVisibility(View.VISIBLE);
                if(notdislike.getVisibility()== View.VISIBLE){
                    notdislike.setVisibility(View.INVISIBLE);
                }
                if(notlike.getVisibility()== View.VISIBLE){
                    notlike.setVisibility(View.INVISIBLE);
                }
                // Get the query text and convert it to lowercase
                String query = editTextQuery.getText().toString().trim().toLowerCase();

                if (!query.isEmpty()) {
                    // Get the corresponding reply if it exists, else display a default message
                    String reply = predefinedReplies.containsKey(query) ? predefinedReplies.get(query) : "Sorry, I don't have an answer for that.";

                    // Store the query and its reply in SharedPreferences
                    pastQueries.put(query, reply);
                    savePastQueries();

                    // Add a new TextView for the current post
                    addPostTextView(query, reply);

                    // Clear the EditText
                    editTextQuery.getText().clear();
                    likeDislikeLayout.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    // Initialize predefined questions and replies
    private void initPredefinedReplies() {
        predefinedReplies = new HashMap<>();
        predefinedReplies.put("what is android", "Android is a mobile operating system based on a modified version of the Linux kernel.");
        predefinedReplies.put("how do i create an android app", "You can create Android apps using languages like Java or Kotlin, and development environments like Android Studio.");
        predefinedReplies.put("what is xml", "XML stands for eXtensible Markup Language. It is used for storing and transporting data.");
        predefinedReplies.put("hi", "Hello");
        // Add more predefined questions and replies as needed
    }

    // Load past queries from SharedPreferences
    private void loadPastQueries() {
        String pastQueriesJson = sharedPref.getString("pastQueries", "{}");
        pastQueries = new Gson().fromJson(pastQueriesJson, new TypeToken<HashMap<String, String>>() {}.getType());

        // Display past queries
        for (Map.Entry<String, String> entry : pastQueries.entrySet()) {
            addPostTextView(entry.getKey(), entry.getValue());
        }
    }

    // Save past queries to SharedPreferences
    private void savePastQueries() {
        String pastQueriesJson = new Gson().toJson(pastQueries);
        editor.putString("pastQueries", pastQueriesJson);
        editor.apply();
    }

    // Add a new TextView for a post
    private void addPostTextView(String query, String reply) {
        TextView postTextView = new TextView(this);
        postTextView.setText("Query: " + query + "\nReply: " + reply + "\n\n");
        postLayout.addView(postTextView);
    }

    public void like(View view) {

        like.setVisibility(View.INVISIBLE);
        notlike.setVisibility(View.VISIBLE);
        if(notdislike.getVisibility()== View.VISIBLE){
            notdislike.setVisibility(View.INVISIBLE);
            dislike.setVisibility(View.VISIBLE);
        }

//        Intent intent = new Intent(this, like.class);
//        intent.putExtra("message",postText); // Pass the message as a string
//        startActivity(intent);
//        buttonPost.setEnabled(false);
    }

    public void dislike(View view) {
        dislike.setVisibility(View.INVISIBLE);
        notdislike.setVisibility(View.VISIBLE);
        if(notlike.getVisibility()== View.VISIBLE){
            notlike.setVisibility(View.INVISIBLE);
            like.setVisibility(View.VISIBLE);
        }
//        Intent intent = new Intent(this, dislike.class);
//        intent.putExtra("message", (Parcelable) postTextView); // Pass the message as an extra
//        startActivity(intent);
//        finish();
//        buttonPost.setEnabled(false);
    }

    public void notlike(View view) {
        notlike.setVisibility(View.INVISIBLE);
        like.setVisibility(View.VISIBLE);
    }

    public void notdislike(View view) {
        notdislike.setVisibility(View.INVISIBLE);
        dislike.setVisibility(View.VISIBLE);

    }
}
