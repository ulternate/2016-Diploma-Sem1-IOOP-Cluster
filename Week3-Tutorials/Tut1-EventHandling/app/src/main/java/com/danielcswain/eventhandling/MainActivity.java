package com.danielcswain.eventhandling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Boolean clicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button exampleButton = (Button) this.findViewById(R.id.testButton);
        exampleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(clicked){
            TextView text = (TextView) this.findViewById(R.id.textView1);
            text.setText("Ok, really, DON'T TOUCH THE BUTTON");
            clicked = false;
        }else{
            TextView text = (TextView) this.findViewById(R.id.textView1);
            text.setText("I SAID DON'T TOUCH THE BUTTON");
            clicked = true;
        }
    }
}
