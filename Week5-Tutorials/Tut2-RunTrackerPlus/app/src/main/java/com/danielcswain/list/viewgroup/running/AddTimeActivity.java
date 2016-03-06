package com.danielcswain.list.viewgroup.running;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ulternate on 6/03/2016.
 */
public class AddTimeActivity extends AppCompatActivity implements View.OnClickListener {

    static EditText timeView;
    static EditText notesView;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_time);
        Button saveButton = (Button)findViewById(R.id.saveButton);
        Button cancelButton = (Button)findViewById(R.id.cancelButton);
        timeView = (EditText)findViewById(R.id.addTime);
        notesView = (EditText)findViewById(R.id.addNote);
        saveButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.saveButton:
                Intent intent = getIntent();
                intent.putExtra("time", timeView.getText().toString());
                intent.putExtra("notes", notesView.getText().toString());
                this.setResult(RESULT_OK, intent);
                finish();

            case R.id.cancelButton:
                finish();
        }
    }
}
