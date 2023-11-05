package com.example.cse489_2023_3_2020260185;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ClassSummaryActivity extends AppCompatActivity {

    private TextView userID;
    private EditText etTopic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_summary);

        etTopic = findViewById(R.id.etTopic);
        userID = findViewById(R.id.tvID);

        Intent intent = this.getIntent();
        String userid = intent.getStringExtra("userID");
        userID.setText(userid);

        Button buttonCancel = findViewById(R.id.btnCancel);

        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String topic = etTopic.getText().toString();
                System.out.println(topic);
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClassSummaryActivity.this, ClassLecturesActivity.class);
                startActivity(intent);
            }
        });
    }
}