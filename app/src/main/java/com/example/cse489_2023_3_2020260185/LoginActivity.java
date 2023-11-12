package com.example.cse489_2023_3_2020260185;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
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
                if (TextUtils.isEmpty(userIDEditText.getText().toString())){
                    userIDEditText.setError("Please Enter a User ID");
                }
                else if (TextUtils.isEmpty(passwordEditText.getText().toString())){
                    passwordEditText.setError("Please Enter a Password");
                }
                else {
                    SharedPreferences localPref = LoginActivity.this.getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor edit = localPref.edit();
                    edit.putString("userID", userIDEditText.getText().toString());
                    edit.putString("password",passwordEditText.getText().toString());
                    edit.putBoolean("remember-user-id", false);
                    edit.putBoolean("remember-user-password", false);
                    edit.apply();
                    Intent intent = new Intent(LoginActivity.this, ClassSummaryActivity.class);
                    startActivity(intent);
                }
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