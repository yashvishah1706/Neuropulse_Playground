package com.example.registerlogin;

import static com.example.registerlogin.chessStorage.*;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class chessNameActivity extends AppCompatActivity {

    ActionBar aB;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // sets content view to the name activity
        setContentView(R.layout.chess_activity_names);

        aB = getSupportActionBar();

        // hiding the action bar
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }

        // filling the edit texts with the default names
        EditText player1 = findViewById(R.id.player_1_name);
        player1.setText(playerWhite);
        EditText player2 = findViewById(R.id.player_2_name);
        player2.setText(playerBlack);
    }

    public void done (View view)
    {
        // saving the user text in chessStorage.java
        EditText player1 = findViewById(R.id.player_1_name);
        playerWhite = player1.getText().toString().trim();
        EditText player2 = findViewById(R.id.player_2_name);
        playerBlack = player2.getText().toString().trim();

        // creating a new intent
        Intent intent = new Intent(chessNameActivity.this, chessMainActivity.class);

        // switching to the chessMainActivity
        chessNameActivity.this.startActivity(intent);
    }

    public void buttonClickNameGenerator (View view)
    {
        Uri uri = Uri.parse("https://www.namegeneratorfun.com/nickname");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void home(View view) {
        Intent intent = new Intent(chessNameActivity.this,chessMainActivity.class);
        startActivity(intent);
        finish();

    }
}
