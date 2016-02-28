package com.danielcswain.explicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openActivityTwo(View v){
        Intent intent = new Intent(this,DetailActivity.class);
        startActivity(intent);
    }


    public void implicitViewURL(View view) {
        String webpage = "http://www.google.com";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webpage));
        startActivity(intent);
    }

    public void implicitSendText(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "Hello from me to you");
        intent.setType("text/plain");
        startActivity(intent);
    }
}
