package com.seteditor.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mhseteditor.R;
import com.mhseteditor.models.MGalery;

public class ImageAdapter extends BaseAdapter {
	
	private Context context;
	private MGalery galery;

    public ImageAdapter(Context c) {
        context = c;
        galery = MGalery.getInstance();
    }

    public int getCount() {
        return galery.getCount() ;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
    	
    	View inflatedView = convertView;
        ImageView setView;
        TextView setName;

    	LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    	
    	inflatedView = inflater.inflate(R.layout.galery_item, null);
    	
    	
    	
    	setView = (ImageView)inflatedView.findViewById(R.id.setView);
        setName = (TextView)inflatedView.findViewById(R.id.setName);
    	
        if (convertView == null) {  // if it's not recycled, initialize some attributes

            
            
            //inflatedView.setLayoutParams(new GridView.LayoutParams(85, 85));
           // inflatedView.setScaleType(ImageView.ScaleType.CENTER_CROP);
           // inflatedView.setPadding(8, 8, 8, 8);
        } else {
            inflatedView =  convertView;
        }

        setView.setImageResource(mThumbIds[position]);
        setName.setText(galery.getSet(position).getName());
        
        return inflatedView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7
    };

}
