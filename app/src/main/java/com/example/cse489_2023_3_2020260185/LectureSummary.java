package com.example.cse489_2023_3_2020260185;

public class LectureSummary {
    String name = "";
    String ID = "";
    String course = "";
    String type = "";
    String date = "";
    String lecture = "";

    String topicName = "";
    String lectureSummary = "";

    public LectureSummary(String name, String ID, String course, String type, String date, String lecture, String topicName, String lectureSummary) {
        this.name = name;
        this.ID = ID;
        this.course = course;
        this.type = type;
        this.date = date;
        this.lecture = lecture;
        this.topicName = topicName;
        this.lectureSummary = lectureSummary;
    }
}
