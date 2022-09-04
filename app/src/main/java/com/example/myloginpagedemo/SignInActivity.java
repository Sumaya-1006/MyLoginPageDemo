package com.example.myloginpagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class SignInActivity extends AppCompatActivity {
    private EditText welcomeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        welcomeEditText = findViewById(R.id.welcomeId);
    }
}