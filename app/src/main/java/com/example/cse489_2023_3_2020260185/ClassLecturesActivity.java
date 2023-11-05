package com.example.cse489_2023_3_2020260185;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClassLecturesActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_lectures);

        //Calling the values from Signup Activity
        Intent intent = this.getIntent();
        String name = intent.getStringExtra("User Name");
        System.out.println(name);


        Button buttonAddNew = findViewById(R.id.btnAddNew);
        buttonAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClassLecturesActivity.this, ClassSummaryActivity.class);
                intent.putExtra("userID", "2020-2-60-185");
                startActivity(intent);
            }
        });
    }



}