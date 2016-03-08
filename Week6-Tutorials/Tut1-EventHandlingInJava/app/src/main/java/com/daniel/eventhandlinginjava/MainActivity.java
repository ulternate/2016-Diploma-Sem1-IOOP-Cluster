package com.daniel.eventhandlinginjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
                Intent intent1 = new Intent(this,DetailActivity.class);
                startActivity(intent1);
                break;

            case R.id.button2:
                String webpage = "http://www.google.com";
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(webpage));
                startActivity(intent2);
                break;

            case R.id.button3:
                Intent intent3 = new Intent();
                intent3.setAction(Intent.ACTION_SEND);
                intent3.putExtra(Intent.EXTRA_TEXT, "Hello from me to you");
                intent3.setType("text/plain");
                startActivity(intent3);
                break;

        }
    }
}
