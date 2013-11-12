package com.mhseteditor;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import com.mhseteditor.controllers.CGalery;
import com.seteditor.utils.ImageAdapter;

public class VGalery extends Activity{
	
	private CGalery controller;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galery);
        
        GridView gridview = (GridView) findViewById(R.id.gridview);
        ImageAdapter imageAdapter = new ImageAdapter(this);
        gridview.setAdapter(imageAdapter);
        
        controller = new CGalery(this);

        gridview.setOnItemClickListener(controller);
	}

}
