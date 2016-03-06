package com.danielcswain.list.viewgroup.running;

/**
 * Created by ulternate on 6/03/2016.
 */
public class TimeRecord {

    private String time;
    private String notes;

    // Public Constructor
    public TimeRecord(String time, String notes){
        this.time = time;
        this.notes = notes;
    }

    // Public Getter methods
    public String getTime(){
        return this.time;
    }

    public String getNotes(){
        return this.notes;
    }

    // Public Setter Methods
    public void setTime(String time){
        this.time = time;
    }

    public void setNotes(String notes){
        this.notes = notes;
    }
}
