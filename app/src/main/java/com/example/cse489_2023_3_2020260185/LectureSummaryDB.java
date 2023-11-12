package com.example.cse489_2023_3_2020260185;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LectureSummaryDB extends SQLiteOpenHelper {
    public LectureSummaryDB(Context context) {
        super(context, "LectureSummaryDB.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("DB@OnCreate");
        String sql = "CREATE TABLE LectureSummary ("
                + "ID TEXT PRIMARY KEY,"
                + "name TEXT,"
                + "course INT,"
                + "date INT,"
                + "lecture INT,"
                + "topicName TEXT,"
                + "lectureSummary TEXT"
                + ")";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("Write code to modify database schema here");
        // db.execSQL("ALTER table my_table  ......");
        // db.execSQL("CREATE TABLE  ......");
    }
    public void insertLectureSummary(String ID, String name, String course, int date, int lecture, String topicName, String lectureSummary) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cols = new ContentValues();
        cols.put("ID", ID);
        cols.put("name", name);
        cols.put("course", course);
        cols.put("date", date);
        cols.put("lecture", lecture);
        cols.put("topicName", topicName);
        cols.put("lectureSummary", lectureSummary);
        db.insert("LectureSummary", null ,  cols);
        db.close();
    }
    public void updateLectureSummary(String ID, String name, String course, int date, int lecture, String topicName, String lectureSummary) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cols = new ContentValues();
        cols.put("ID", ID);
        cols.put("name", name);
        cols.put("course", course);
        cols.put("date", date);
        cols.put("lecture", lecture);
        cols.put("topicName", topicName);
        cols.put("lectureSummary", lectureSummary);
        db.update("LectureSummary", cols, "ID=?", new String[ ] {ID} );
        db.close();
    }
    public void deleteLectureSummary(String ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("LectureSummary", "ID=?", new String[ ] {ID} );
        db.close();
    }
    public Cursor selectLectureSummary(String query) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = null;
        try {
            res = db.rawQuery(query, null);
        } catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }
}
