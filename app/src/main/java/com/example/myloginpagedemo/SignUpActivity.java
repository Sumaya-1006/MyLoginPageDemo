package com.example.myloginpagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText signUpName,signUpEmail,signUpUsername,signUpPassword;
    private Button signUpButton;
    DatabaseHelper databaseHelper;
    UserDetails userDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signUpName = findViewById(R.id.signUpNameId);
        signUpEmail = findViewById(R.id.signUpEmailId);
        signUpUsername = findViewById(R.id.signUpUsernameId);
        signUpPassword = findViewById(R.id.signUpPasswordId);
        signUpButton = findViewById(R.id.signUpButtonId);
        databaseHelper = new DatabaseHelper(this);

        userDetails = new UserDetails();
        signUpButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        String name = signUpName.getText().toString();
        String email = signUpEmail.getText().toString();
        String username = signUpUsername.getText().toString();
        String password = signUpPassword.getText().toString();

        userDetails.setName(name);
        userDetails.setEmail(email);
        userDetails.setUsername(username);
        userDetails.setPassword(password);

     long rowId = databaseHelper.insertData(userDetails);

     if(rowId>0){
         Toast.makeText(getApplicationContext(),"Row " +rowId+ " is successfully inserted", Toast.LENGTH_LONG ).show();

     }else{
        Toast.makeText(getApplicationContext(),"unsuccessful",Toast.LENGTH_LONG).show();
     }


        }
}