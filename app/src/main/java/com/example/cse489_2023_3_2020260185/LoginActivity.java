package com.example.cse489_2023_3_2020260185;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText userIDEditText = findViewById(R.id.tvUserID);
    EditText passwordEditText = findViewById(R.id.tvPassword);

    Button buttonExit = findViewById(R.id.btnExit);
    Button buttonGo = findViewById(R.id.btnGo);


    String userID = userIDEditText.getText().toString();
    String password = passwordEditText.getText().toString();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Start the ClassSummaryActivity when the button is clicked.
                Intent intent = new Intent(LoginActivity.this, ClassSummaryActivity.class);
                startActivity(intent);
            }
        });

        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LoginActivity().finish();
                System.exit(0);
            }
        });
    }





}