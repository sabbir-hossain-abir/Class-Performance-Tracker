package com.example.cse489_2023_3_2020260185;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ClassSummaryActivity extends AppCompatActivity {

    private TextView tvName;
    private TextView tvID;
    private RadioGroup radioGrp1;
    private RadioButton radioBtn1;
    private RadioButton radioBtn2;
    private RadioButton radioBtn3;
    private RadioButton radioBtn4;
    private RadioButton radioBtn5;
    private RadioButton radioBtn6;
    private EditText tvDate;
    private EditText lecture;
    private EditText etTopic;
    private EditText etSummary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_summary);

        tvName = findViewById(R.id.tvName);
        tvID = findViewById(R.id.tvID);
        radioGrp1 = findViewById(R.id.radioGrp1);
        radioBtn1 = findViewById(R.id.radioBtn1);
        radioBtn2 = findViewById(R.id.radioBtn2);
        radioBtn3 = findViewById(R.id.radioBtn3);
        radioBtn4 = findViewById(R.id.radioBtn4);
        radioBtn5 = findViewById(R.id.radioBtn5);
        radioBtn6 = findViewById(R.id.radioBtn6);
        tvDate = findViewById(R.id.tvDate);
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
                Integer radioG1 = radioGrp1.getCheckedRadioButtonId();
                String topic = etTopic.getText().toString();
                System.out.println(topic);

                //Validate RadioGroup
//                radioGrp1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//                    @Override
//                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                        RadioButton radioButton = radioGroup.findViewById(i);
//                    }
//                });

                if (TextUtils.isEmpty(tvDate.getText().toString())) {
                    tvDate.setError("Date can not be empty");
                }
                else if (TextUtils.isEmpty(lecture.getText().toString())){
                    lecture.setError("Lecture can not be empty");
                }
                else if (TextUtils.isEmpty(etTopic.getText().toString())){
                    etTopic.setError("Topic can not be empty");
                }
                else if (TextUtils.isEmpty(etSummary.getText().toString())){
                    etSummary.setError("Summary can not be empty");
                }

//////////////////////          If the data is valid store it to database            /////////////////////////////

//                else{
//                    if (LectureSummary.isEmpty()){
//                        LectureSummary = topic + System.currentTimeMillis();
//                        LectureSummaryDB.inserLectureSummary(String ID, String name, String course, int date, int lecture, String topicName, String lectureSummary)
//                        finish();
//                    }
//                    else {
//                        LectureSummaryDB.updateLectureSummary(String ID, String name, String course, int date, int lecture, String topicName, String lectureSummary)
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