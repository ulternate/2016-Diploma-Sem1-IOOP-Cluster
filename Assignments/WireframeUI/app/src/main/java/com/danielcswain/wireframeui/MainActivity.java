package com.danielcswain.wireframeui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

// Main activity class, a simple activity that shows my activity_main layout and has an action
// for the button click (changing the mood of the face, who's made up of shapes).
public class MainActivity extends AppCompatActivity {

    // The view objects and state checker variables
    boolean scared = false;
    Button changeMood;
    ImageView mouth;
    TextView greeting2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Set the layout to my activity_main layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get out buttons and set the mouth background to the initial state
        changeMood = (Button)findViewById(R.id.button);
        mouth = (ImageView)findViewById(R.id.shapeMouth);
        greeting2 = (TextView)findViewById(R.id.textGreeting);
        // setBackgroundDrawable is depreciated, but I've targeted v15 and the new version is
        // only v16+
        mouth.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_red_line));

        // onClickListener for the changeMood button
        changeMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // if scared is true when you click, change the image back to normal and change
            // the messages/button text. If you weren't scared, then change to the scared
            // state and text.
            if (scared){
                mouth.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_red_line));
                greeting2.setText("Please, don't do that again, I don't think I'm up for it!");
                changeMood.setText("See if he's up for it ;D");
                scared = false;
            }else{
                mouth.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_red_ring));
                greeting2.setText("Why did you do that, I said I'm prone to frights!");
                changeMood.setText("Ok, sorry (click to start again)");
                scared = true;
            }
            }
        });
    }
}
