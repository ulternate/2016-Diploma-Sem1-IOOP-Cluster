package com.danielcswain.intentfiltersexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by ulternate on 28/02/2016.
 */
public class DigitalClock_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Button activity2 = (Button) findViewById(R.id.button2);
        activity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });
    }

}
