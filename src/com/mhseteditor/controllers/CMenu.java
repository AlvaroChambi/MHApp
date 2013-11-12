package com.mhseteditor.controllers;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.mhseteditor.R;
import com.mhseteditor.VGalery;
import com.mhseteditor.VMenu;

public class CMenu implements OnClickListener{
	
	private VMenu view;
	
	public CMenu(VMenu view){
		this.view = view;
	}

	@Override
	public void onClick(View element) {
		switch(element.getId()){
		case R.id.galeryButton:
			Intent intent = new Intent(view,VGalery.class);
			view.startActivity(intent);
			break;
		}
	}

}
