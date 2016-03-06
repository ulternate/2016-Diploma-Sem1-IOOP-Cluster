package com.danielcswain.list.viewgroup.running;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class TimeTrackerActivity extends AppCompatActivity {

    TimeTrackerAdapter timeTrackerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_tracker);

        ListView listView = (ListView)findViewById(R.id.timesList);
        timeTrackerAdapter = new TimeTrackerAdapter();
        listView.setAdapter(timeTrackerAdapter);
    }
}
