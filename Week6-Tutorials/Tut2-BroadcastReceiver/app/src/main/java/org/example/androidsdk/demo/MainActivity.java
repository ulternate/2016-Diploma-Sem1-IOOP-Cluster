package org.example.androidsdk.demo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String LOGTAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Log.d(LOGTAG, "onCreate");

		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, DetailActivity.class);
				startActivity(intent);				
			}
		});
		
		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String webpage = "http://developer.android.com/index.html";
				
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webpage));
				startActivity(intent);
			}
		});
		
		Button button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_SEND);
				intent.putExtra(Intent.EXTRA_TEXT, "Hello from Hansel and Petal!");
				intent.setType("text/plain");
				startActivity(intent);
			}
		});

        Toast.makeText(this, "ActivityCreated", Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //compare config object that's passed in against a CONSTANT object
        if ( newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            Toast.makeText(this, "Landscape", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "Portrait", Toast.LENGTH_LONG).show();
        }

    }
    //	public void gotoActivity(View v) {
//		Intent intent = new Intent(this, DetailActivity.class);
//		startActivity(intent);
//	}
//	
//	public void implicitViewURL(View v) {
//		String webpage = "http://developer.android.com/index.html";
//		
//		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webpage));
//		startActivity(intent);
//	}
//	
//	public void implicitSendText(View v) {
//		Intent intent = new Intent();
//		intent.setAction(Intent.ACTION_SEND);
//		intent.putExtra(Intent.EXTRA_TEXT, "Hello from Hansel and Petal!");
//		intent.setType("text/plain");
//		startActivity(intent);
//	}
	
}
