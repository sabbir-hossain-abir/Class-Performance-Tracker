package com.example.cse489_2023_3_2020260185;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ClassSummaryActivity extends AppCompatActivity {

    private TextView tvName;
    private TextView tvID;
    private RadioGroup radioGrp1, radioGrp2;

    private RadioButton radioBtn1, radioBtn2, radioBtn3, radioBtn4, radioBtn5, radioBtn6;
    private EditText tvDate;
    private EditText tvLecture;
    private EditText etTopic;
    private EditText etSummary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_summary);

        tvName = findViewById(R.id.tvName);
        tvID = findViewById(R.id.tvID);
        radioGrp1 = findViewById(R.id.radioGrp1);
        radioGrp2 = findViewById(R.id.radioGrp2);
        radioBtn1 = findViewById(R.id.radioBtn1);
        radioBtn2 = findViewById(R.id.radioBtn2);
        radioBtn3 = findViewById(R.id.radioBtn3);
        radioBtn4 = findViewById(R.id.radioBtn4);
        radioBtn5 = findViewById(R.id.radioBtn5);
        radioBtn6 = findViewById(R.id.radioBtn6);
        tvDate = findViewById(R.id.tvDate);
        tvLecture = findViewById(R.id.tvLecture);
        etTopic = findViewById(R.id.etTopic);
        etSummary = findViewById(R.id.etSummary);


        Intent intent = this.getIntent();
        String userid = intent.getStringExtra("userID");
        tvID.setText(userid);


        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = tvName.getText().toString();
                String ID = tvID.getText().toString();
                String course = radioGrp1.toString();  //Need to fix this
                String type = radioGrp2.toString(); //Need to fix this
                String date = tvDate.getText().toString();
                String topic = etTopic.getText().toString();
                String lecture = tvLecture.getText().toString();
                String lectureSummary = etSummary.getText().toString();


                System.out.println(topic);

                //Validate RadioGroup
//                radioGrp1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//                    @Override
//                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                        RadioButton radioButton = radioGroup.findViewById(i);
//                    }
//                });

                if (radioBtn1.isChecked() || radioBtn2.isChecked() || radioBtn3.isChecked() || radioBtn4.isChecked()) {
                    // Check which radio button is selected
                    if (radioBtn1.isChecked()) {
                        course = radioBtn1.getText().toString();
                    } else if (radioBtn2.isChecked()) {
                        course = radioBtn2.getText().toString();
                    } else if (radioBtn3.isChecked()) {
                        course = radioBtn3.getText().toString();
                    } else if (radioBtn4.isChecked()) {
                        course = radioBtn4.getText().toString();
                    }

                    // Check which type radio button is selected
                    if (radioBtn5.isChecked()) {
                        type = radioBtn5.getText().toString();
                    } else if (radioBtn6.isChecked()) {
                        type = radioBtn6.getText().toString();
                    }

                    // Save the class summary
                    if (!TextUtils.isEmpty(date) && !TextUtils.isEmpty(topic) && !TextUtils.isEmpty(lecture) && !TextUtils.isEmpty(lectureSummary)) {
                        LectureSummaryDB db = new LectureSummaryDB(ClassSummaryActivity.this);
                        db.insertLectureSummary(ID,name,course,type,date,lecture,topic,lectureSummary);

                        Intent intent1 = new Intent(ClassSummaryActivity.this, ClassLecturesActivity.class);
                        startActivity(intent1);
                        db.close();
//                        Log.d("ClassSummaryActivity", "Save button clicked");
                    } else {
                        // Display an error message
                        Toast.makeText(ClassSummaryActivity.this, "Please fill in all required fields", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Display an error message
                    Toast.makeText(ClassSummaryActivity.this, "Please select a course and type", Toast.LENGTH_SHORT).show();
                }


//////////////////////          If the data is valid store it to database            /////////////////////////////

//                else{
//                    LectureSummaryDB db = new LectureSummaryDB(ClassSummaryActivity.this);
//                    if (ID.isEmpty()){
//                        ID = topic + System.currentTimeMillis();
//
//                        db.insertLectureSummary(ID, name, course, type, date, lecture, topic, lectureSummary);
//                        finish();
//                    }
//                    else {
//                        db.updateLectureSummary(ID, name, course, type, date, lecture, topic, lectureSummary);
//                    }
//
//                }
            }
        });

        findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClassSummaryActivity.this, ClassLecturesActivity.class);
                startActivity(intent);
            }
        });

    }
}