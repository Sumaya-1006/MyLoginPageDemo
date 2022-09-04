package com.example.myloginpagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText Username, Password;
    private Button signInButton, signUpHereButton;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Username = findViewById(R.id.usernameEditTextId);
        Password = findViewById(R.id.passwordEditTextId);
        signInButton = findViewById(R.id.signInButtonId);
        signUpHereButton = findViewById(R.id.signUpHereButtonId);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();


        signInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = Username.getText().toString();
                String password = Password.getText().toString();


                if (view.getId() == R.id.signInButtonId) {

                    Boolean result = databaseHelper.findPassword(username, password);

                    if (result == true) {

                        Intent intent = new Intent(MainActivity.this,SignInActivity.class);
                        startActivity(intent);

                    } else {

                        Toast.makeText(getApplicationContext(), "Username or Password did not matched", Toast.LENGTH_LONG).show();
                    }

                }
            }


        });

        signUpHereButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = Username.getText().toString();
                String password = Password.getText().toString();

                SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

                if (view.getId() == R.id.signUpHereButtonId) {
                    Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                    startActivity(intent);
                }


            }


        });

    }
}


