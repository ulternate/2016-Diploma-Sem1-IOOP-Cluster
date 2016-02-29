package com.danielcswain.intentfiltersexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tut 6 stuff
        Button activity1 = (Button) findViewById(R.id.button1);
        activity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DigitalClock_Activity.class);
                startActivityForResult(intent, 0);
            }
        });

        //Tut 7 code
        Button startButton = (Button) findViewById(R.id.startButton);
        Button stopButton = (Button)findViewById(R.id.stopButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getBaseContext(), MediaPlayerService.class));
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getBaseContext(), MediaPlayerService.class));
            }
        });
    }

    //Added a little bit more than the tute to actually handle the return intent in the main activity.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode){
            case RESULT_OK:
                if(requestCode == 0){
                    Toast.makeText(this,"You've returned from the digital days",Toast.LENGTH_SHORT).show();
                }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
