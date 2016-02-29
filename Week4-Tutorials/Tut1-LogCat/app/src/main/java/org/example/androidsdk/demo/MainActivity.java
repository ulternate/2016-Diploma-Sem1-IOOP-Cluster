package org.example.androidsdk.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

    public static final String MAIN_ACTIVITY = "MainActivity";

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//The following is to demonstrate the LogCat, it will crash the app
        // ArrayList<String> values = new ArrayList<String>();
        // String value = values.get(0); //<-This will crash

        //Now play with the log class
        Log.d(MAIN_ACTIVITY, "Activity created");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
        // A log message for the options menu creation
        Log.d(MAIN_ACTIVITY, "Options Menu Created");

		return true;
	}

}
