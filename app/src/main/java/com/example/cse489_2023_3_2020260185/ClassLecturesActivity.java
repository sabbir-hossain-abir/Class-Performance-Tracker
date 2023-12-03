package com.example.cse489_2023_3_2020260185;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ClassLecturesActivity extends AppCompatActivity {

    private ArrayList<LectureSummary>classes;
    private ClassSummaryAdapter adapter;
    private ListView lvClasses;

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

        lvClasses = findViewById(R.id.lvLec);
        classes = new ArrayList<>();

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


    @Override
    protected void onStart() {
        super.onStart();
        loadData();
    }

    private void loadData() {
        classes.clear();
        LectureSummaryDB db = new LectureSummaryDB(this);
        Cursor rows = db.selectLectureSummary("SELECT * FROM LectureSummary");
        if (rows.getCount()>0){
            while (rows.moveToNext()){
                String id = rows.getString(0);
                String name = rows.getString(1);
                String course = rows.getString(2);
                String type = rows.getString(3);
                String date = rows.getString(4);
                String lecture = rows.getString(5);
                String topicName = rows.getString(6);
                String lectureSummary = rows.getString(7);

                LectureSummary cs = new LectureSummary(name, id, course, type, date, lecture, topicName, lectureSummary);
                classes.add(cs);
            }
        }

        db.close();
        adapter = new ClassSummaryAdapter(this, classes);
        lvClasses.setAdapter(adapter);

        lvClasses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                System.out.println(position);
                Intent i = new Intent(ClassLecturesActivity.this, LectureSummary.class);
                i.putExtra("ClassSummaryKey", classes.get(position).ID);
                i.putExtra("CourseCode", classes.get(position).name);
                i.putExtra("Course", classes.get(position).course);
                i.putExtra("Type", classes.get(position).type);
                i.putExtra("Date", classes.get(position).date);
                i.putExtra("Lecture", classes.get(position).topicName);
                i.putExtra("LectureSummary", classes.get(position).lectureSummary);

                startActivity(i);
            }
        });

        //Handle the long-click on an class-summary-list item

        lvClasses.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String info = classes.get(position).course + "," + classes.get(position),topic;
                String message = "Do you want to delete class-summary -"+ info + "?";
                System.out.println(message);
                return true;
            }
        });
    }


}