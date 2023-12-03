package com.example.cse489_2023_3_2020260185;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.ArrayList;
public class ClassSummaryAdapter extends ArrayAdapter<LectureSummary> {
    private final Context context;
    private final ArrayList<LectureSummary> values;

    public ClassSummaryAdapter(@NonNull Context context, @NonNull ArrayList<LectureSummary> items) {
        super(context, -1, items);
        this.context = context;
        this.values = items;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        @SuppressLint("ViewHolder") View rowView = inflater.inflate(R.layout.layout_class_summary_row, parent, false);

        TextView topLeftTitle = rowView.findViewById(R.id.lvClassCode);
        TextView dateTime = rowView.findViewById(R.id.tvDateTime);
        TextView topic = rowView.findViewById(R.id.tvTopic);
        //TextView eventType = rowView.findViewById(R.id.tvEventType);

        LectureSummary e = values.get(position);
        topLeftTitle.setText("Course: " + e.course);
        dateTime.setText("Date: " + e.date);
        topic.setText("Topic Name: " + e.topicName);
        return rowView;
    }
}
