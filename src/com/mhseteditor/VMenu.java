package com.mhseteditor;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.mhseteditor.controllers.CMenu;

public class VMenu extends Activity{
	
	private ImageView galeryButton;
	private CMenu controller;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        
        controller = new CMenu(this);
        galeryButton = (ImageView)findViewById(R.id.galeryButton);
        galeryButton.setOnClickListener(controller);
	}

}
