package org.example.androidsdk.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import org.example.androidsdk.demo.data.Flower;
import org.example.androidsdk.demo.data.FlowerData;

import java.util.List;

public class MainActivity extends Activity {

	@SuppressWarnings("unused")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		List<Flower> flowers = new FlowerData().getFlowers();
		LinearLayout layout = (LinearLayout) findViewById(R.id.layout);

		for(final Flower flower:flowers){
			//Create a button for the flower
			Button button = new Button(this);
			//Set the button caption/text
			button.setText(flower.flowerName);
			//Add the button to the layout
			layout.addView(button);

			//Create an onClick Listener for each button
			button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(MainActivity.this, DetailActivity.class);
					intent.putExtra("flowerName",flower.flowerName);
					intent.putExtra("imageResource", flower.imageResource);
					intent.putExtra("instructions", flower.instructions);
					startActivity(intent);
				}
			});
		}
		
	}
	
}
