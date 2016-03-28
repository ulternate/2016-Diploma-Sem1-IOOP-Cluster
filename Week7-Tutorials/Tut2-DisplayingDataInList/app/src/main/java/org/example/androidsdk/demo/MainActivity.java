package org.example.androidsdk.demo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.example.androidsdk.demo.data.Flower;
import org.example.androidsdk.demo.data.FlowerData;

import java.util.List;

public class MainActivity extends ListActivity {

	private static final int REQUEST_CODE = 100;
	List<Flower> flowers = new FlowerData().getFlowers();

	@SuppressWarnings("unused")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Take the data and put it into the list
		ArrayAdapter<Flower> adapter = new ArrayAdapter<Flower>(this,
																android.R.layout.simple_list_item_1,
																flowers);
		setListAdapter(adapter);

		/*List<Flower> flowers = new FlowerData().getFlowers();
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
					startActivityForResult(intent, REQUEST_CODE);
				}
			});
		}*/
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		// Get the flower object
		Flower flower = flowers.get(position);
		// Create intent
		Intent intent = new Intent(this, DetailActivity.class);
		// Add data to the intent
		intent.putExtra("flowerName", flower.flowerName);
		intent.putExtra("imageResource", flower.imageResource);
		intent.putExtra("instructions", flower.instructions);
		// Start DetailActivity for result
		startActivityForResult(intent, REQUEST_CODE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == REQUEST_CODE && resultCode == RESULT_OK){
			// Grab the data from the return intent
			String flowerName = data.getStringExtra("flowerName");
			String action = data.getStringExtra("action");

			if (action.equals("add")){
				Toast.makeText(this, "Adding 1 to the cart: " + flowerName, Toast.LENGTH_SHORT).show();
			}
		}
	}
}
