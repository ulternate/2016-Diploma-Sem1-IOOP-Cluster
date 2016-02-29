package com.danielcswain.intentfiltersexample;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ulternate on 28/02/2016.
 */
public class DigitalClock_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        //Old Tut 6 code
        Button activity2 = (Button) findViewById(R.id.button2);
        activity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });

        //New Tut 8 code
        Button startTimer = (Button) findViewById(R.id.startTimer);
        startTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerAlert(v);
            }
        });
    }

    private void timerAlert(View v) {
        EditText textField = (EditText) findViewById(R.id.timeInSeconds);
        int i = Integer.parseInt(textField.getText().toString());

        Intent timerIntent = new Intent (this, TimerBroadcastReceiver.class);
        PendingIntent myPendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 0, timerIntent, 0);
        AlarmManager myAlarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        myAlarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i * 1000), myPendingIntent);
        Toast.makeText(this, "Alarm is set for " + i + " seconds!", Toast.LENGTH_SHORT).show();
    }

}
