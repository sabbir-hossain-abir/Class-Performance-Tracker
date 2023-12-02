package com.example.cse489_2023_3_2020260185;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClassLecturesActivity extends AppCompatActivity {


    private void loadClassSummary(){
        String q = "SELECT * FROM LectureSummary";
        LectureSummaryDB db = new LectureSummaryDB(this);
        Cursor cur = db.selectLectureSummary(q);
        if (cur!=null){
            if (cur.getCount()>0){
                while (cur.moveToNext()){
                    String ID = cur.getString(0);
                    String name = cur.getString(1);
                    String course = cur.getString(2);
                    String type = cur.getString(3);
                    String date = cur.getString(4);
                    String lecture = cur.getString(5);
                    String topic = cur.getString(6);
                    String lectureSummary = cur.getString(7);

                    System.out.println(ID);
                    System.out.println(name);
                    System.out.println(course);
                    System.out.println(type);
                    System.out.println(date);
                    System.out.println(lecture);
                    System.out.println(topic);
                    System.out.println(lectureSummary);

                }
            }
            cur.close();
        }
        db.close();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_lectures);

        //Calling the values from Signup Activity
        loadClassSummary();


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