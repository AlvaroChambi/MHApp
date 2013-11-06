package com.mhseteditor;

import com.mhseteditor.controllers.CMenu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class VMenu extends Activity{
	
	private Button galeryButton;
	private CMenu controller;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        
        controller = new CMenu(this);
        galeryButton = (Button)findViewById(R.id.galeryButton);
        galeryButton.setOnClickListener(controller);
	}

}
