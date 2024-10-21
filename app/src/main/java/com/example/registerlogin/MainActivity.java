package com.example.registerlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail,etPassword;
    private String email,password;


    private final String URL="http://10.125.0.227/login/login.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = password ="";
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
    }
    public void parent(View view) {
        Intent intent = new Intent(MainActivity.this, parentLogin.class);
        startActivity(intent);
        finish();
    }

    public void login(View view){
        email = etEmail.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        if(!email.equals("") && !password.equals("")) {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, response -> {
                String trimmedResponse = response.trim(); // Trim spaces from the response
                if ("success".equalsIgnoreCase(trimmedResponse)) {
                    Intent intent = new Intent(MainActivity.this, Success.class);
                    startActivity(intent);
                    finish();
                } else if ("failure".equalsIgnoreCase(trimmedResponse)) {
                    Toast.makeText(MainActivity.this, "Invalid Login ID/Password", Toast.LENGTH_SHORT).show();
                }
            }, error -> Toast.makeText(MainActivity.this, error.toString().trim(), Toast.LENGTH_SHORT).show()) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> data = new HashMap<>();
                    data.put("email", email);
                    data.put("password", password);
                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }else{
            Toast.makeText(this, "Fields can not be empty!", Toast.LENGTH_SHORT).show();
        }
    }

    public void register(View view) {
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
        finish();
    }



}