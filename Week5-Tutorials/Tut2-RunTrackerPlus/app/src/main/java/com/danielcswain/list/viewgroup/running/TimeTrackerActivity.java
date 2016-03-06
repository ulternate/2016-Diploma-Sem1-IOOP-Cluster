package com.danielcswain.list.viewgroup.running;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

public class TimeTrackerActivity extends AppCompatActivity {

    private static final int TIME_ENTRY_REQUEST_CODE = 1;
    TimeTrackerAdapter timeTrackerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_tracker);

        ListView listView = (ListView)findViewById(R.id.timesList);
        timeTrackerAdapter = new TimeTrackerAdapter();
        listView.setAdapter(timeTrackerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_add_time) {
            Intent intent = new Intent(this, AddTimeActivity.class);
            startActivityForResult(intent, TIME_ENTRY_REQUEST_CODE);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == TIME_ENTRY_REQUEST_CODE) {
            if (resultCode == RESULT_OK){
                String time = data.getStringExtra("time");
                String notes = data.getStringExtra("notes");
                timeTrackerAdapter.addTimeRecord(new TimeRecord(time, notes));
                timeTrackerAdapter.notifyDataSetChanged();
            }
        }
    }
}
