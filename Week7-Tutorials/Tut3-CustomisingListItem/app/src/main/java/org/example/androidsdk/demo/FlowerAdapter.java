package org.example.androidsdk.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.example.androidsdk.demo.data.Flower;

import java.util.List;

/**
 * Created by ulternate on 28/03/2016.
 */
public class FlowerAdapter extends ArrayAdapter<Flower> {

    private Context mContext;
    private List<Flower> mList;

    public FlowerAdapter(Context context, int resource, List<Flower> objects) {
        super(context, resource, objects);
        mContext = context;
        mList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Flower flower = mList.get(position);
        // Create the view
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // Create the new view object
        View view = inflater.inflate(R.layout.item_flower, null);
        // Get the data for the new view
        ImageView image = (ImageView) view.findViewById(R.id.imageView);
        image.setImageResource(flower.imageResource);
        TextView text = (TextView) view.findViewById(R.id.textView);
        text.setText(flower.flowerName);
        // Return the view
        return view;
    }
}
