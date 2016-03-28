package com.danielcswain.list.viewgroup.running;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ulternate on 6/03/2016.
 */
public class TimeTrackerAdapter extends BaseAdapter {

    private ArrayList<TimeRecord> times = new ArrayList<TimeRecord>();

    // Initiating TimeRecords manually for the time being.
    public TimeTrackerAdapter(){
        times.add(new TimeRecord("38:45", "Feeling Good"));
        times.add(new TimeRecord("24:52", "Feeling Tired"));
        times.add(new TimeRecord("42:00", "Knackered!!"));
        times.add(new TimeRecord("32:35", "Getting better......I think"));
        times.add(new TimeRecord("39:50", "My Legs Hurt! :-( "));
        times.add(new TimeRecord("24:45", "Ok never stopped this time"));
        times.add(new TimeRecord("28:24", "Legs still hurt"));
        times.add(new TimeRecord("29:00", "HELP ME!!!"));
    }

    @Override
    public int getCount() {
        // Get the size of our list of time record objects.
        return times.size();
    }

    @Override
    public Object getItem(int position) {
        // Get the TimeRecord object from the list
        return getItem(position);
    }

    @Override
    public long getItemId(int position) {
        // Return the position of the item in the list.
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Initiate the view if it doesn't exist, inflating it if it doesn't exist
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.time_list_item, parent, false);
        }
        // This pulls the Time Record object at that position to be able to use it's data
        TimeRecord time = times.get(position);

        // Set the time and the notes for the list view item
        TextView timeView = (TextView)convertView.findViewById(R.id.timeView);
        TextView notesView = (TextView)convertView.findViewById(R.id.notesView);
        timeView.setText(time.getTime());
        notesView.setText(time.getNotes());

        // Return the populated view
        return convertView;
    }
}
