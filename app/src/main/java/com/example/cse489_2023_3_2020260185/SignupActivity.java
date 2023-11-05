package com.example.cse489_2023_3_2020260185;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class SignupActivity extends AppCompatActivity {


    //Validate Name
//    private Boolean validateName() {
//        if (name.isEmpty()) {
//            nameEditText.setError("Field cannot be empty");
//            return false;
//        }
//        else {
//            nameEditText.setError(null);
//            return true;
//        }
//    }

    //Validate Email
//    private Boolean validateEmail() {
//        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
//        if (email.isEmpty()) {
//            emailEditText.setError("Field cannot be empty");
//            return false;
//        } else if (!email.matches(emailPattern)) {
//            emailEditText.setError("Invalid email address");
//            return false;
//        } else {
//            emailEditText.setError(null);
//            return true;
//        }
//    }

//    private boolean validateUserID() {
//        String noWhiteSpace = "\\A\\w{4,20}\\z";
//        if (SignupActivity.this.userID.isEmpty()) {
//            userIDEditText.setError("Field cannot be empty");
//            return false;
//        } else if (SignupActivity.this.userID.length() >= 15) {
//            userIDEditText.setError("Username too long");
//            return false;
//        } else if (!SignupActivity.this.userID.matches(noWhiteSpace)) {
//            userIDEditText.setError("White Spaces are not allowed");
//            return false;
//        } else {
//            userIDEditText.setError(null);
//            return true;
//        }
//    }

//    private boolean validatePhoneNo() {
//        if (SignupActivity.this.phone.isEmpty()) {
//            phoneEditText.setError("Field cannot be empty");
//            return false;
//        } else {
//            phoneEditText.setError(null);
//            return true;
//        }
//    }

//    private boolean validatePassword() {
//        String passwordVal = "^" +
//                //"(?=.*[0-9])" +         //at least 1 digit
//                //"(?=.*[a-z])" +         //at least 1 lower case letter
//                //"(?=.*[A-Z])" +         //at least 1 upper case letter
//                "(?=.*[a-zA-Z])" +      //any letter
//                "(?=.*[@#$%^&+=])" +    //at least 1 special character
//                "(?=\\S+$)" +           //no white spaces
//                ".{4,}" +               //at least 4 characters
//                "$";
//        if (password.isEmpty()) {
//            passwordEditText.setError("Field cannot be empty");
//            return false;
//        } else if (!password.matches(passwordVal)) {
//            passwordEditText.setError("Password is too weak");
//            return false;
//        } else {
//            passwordEditText.setError(null);
//            return true;
//        }
//    }
    //This function will execute when user click on Register Button
//    public void registerUser() {
//        if(!validateName() |!validatePassword() | !validatePhoneNo() | !validateEmail() | !validateUserID())
//        {
//            return;
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        EditText nameEditText = findViewById(R.id.tvName);
        EditText emailEditText = findViewById(R.id.tvEmail);
        EditText phoneEditText = findViewById(R.id.tvPhone);
        EditText userIDEditText = findViewById(R.id.tvUserID);
        EditText passwordEditText = findViewById(R.id.tvPassword);
        EditText rEnterPassword = findViewById(R.id.tvRePassword);
        Button buttonExit = findViewById(R.id.btnExit);
        Button buttonGo = findViewById(R.id.btnGo);
        CheckBox checkBoxUserID = findViewById(R.id.cbUserID);
        CheckBox checkBoxPassword = findViewById(R.id.cbPassword);

        //Checks if fields are empty
//        String name = nameEditText.getText().toString();
//        String email = emailEditText.getText().toString();
//        String phone = phoneEditText.getText().toString();
//        String userID = userIDEditText.getText().toString();
//        String password = passwordEditText.getText().toString();
//        String reEnterPassword = rEnterPassword.getText().toString();

        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(nameEditText.getText().toString())) {
                    nameEditText.setError("Name can not be empty");
                }
                else if (TextUtils.isEmpty(emailEditText.getText().toString())){
                    emailEditText.setError("Email can not be empty");
                }
                else if (TextUtils.isEmpty(phoneEditText.getText().toString())){
                    phoneEditText.setError("Phone can not be empty");
                }
                else if (TextUtils.isEmpty(userIDEditText.getText().toString())){
                    userIDEditText.setError("userID can not be empty");
                }
                else if (TextUtils.isEmpty(passwordEditText.getText().toString())){
                    passwordEditText.setError("Password can not be empty");
                }
                else if (TextUtils.isEmpty(rEnterPassword.getText().toString())){
                    rEnterPassword.setError("Password can not be empty");
                }
                else{
                    SharedPreferences localPref = SignupActivity.this.getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor edit = localPref.edit();
                    edit.putString("name", nameEditText.getText().toString());
                    edit.putString("email", emailEditText.getText().toString());
                    edit.putString("phone", phoneEditText.getText().toString());
                    edit.putString("userID", userIDEditText.getText().toString());
                    edit.putString("password",passwordEditText.getText().toString());
                    edit.putString("reEnterPassword", rEnterPassword.getText().toString());
                    edit.putBoolean("remember-user-id", false);
                    edit.putBoolean("remember-user-password", false);
                    edit.apply();

                    Intent  intent = new Intent(SignupActivity.this, ClassLecturesActivity.class);
                    startActivity(intent);
                }

            }
        });

        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SignupActivity().finish();
                System.exit(0);
            }
        });

    }





}