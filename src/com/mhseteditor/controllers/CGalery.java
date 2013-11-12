package com.mhseteditor.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.mhseteditor.VGalery;
import com.mhseteditor.VSetManager;

public class CGalery implements OnItemClickListener {
	
	private VGalery view;
	
	public CGalery(VGalery view){
		this.view = view;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		Bundle bundle = new Bundle();
		bundle.putInt("set_position", position);
		//Intent intent = new Intent(this.view,VViewSet.class);
		Intent intent = new Intent(this.view,VSetManager.class);
		intent.putExtras(bundle);
		
		this.view.startActivity(intent);
	}
}
