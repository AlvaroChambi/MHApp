package com.mhseteditor.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.mhseteditor.R;
import com.mhseteditor.VInfoArmor;
import com.mhseteditor.VSetManager;
import com.mhseteditor.utils.Armor;

public class CSet implements OnClickListener{
	
	private VSetManager view;
	
	public CSet(VSetManager view){
		this.view = view;
	}
	
	@Override
	public void onClick(View element) {
		Bundle bundle = new Bundle();
		Intent intent = new Intent(view,VInfoArmor.class);
		bundle.putInt("set_id", view.getSet().getId());
		bundle.putInt("set_position", view.getSetPosition());
		
		Log.i("setManager","C. setId: "+view.getSet().getId());
		
		switch(element.getId()){
		case R.id.headImage:
			bundle.putString("armor_slot", Armor.Head.toString());
			break;
		case R.id.chestImage:
			bundle.putString("armor_slot", Armor.Chest.toString());
			break;
		case R.id.handImage:
			bundle.putString("armor_slot", Armor.Hands.toString());
			break;
		case R.id.waistImage:
			bundle.putString("armor_slot", Armor.Waist.toString());
			break;
		case R.id.feetImage:
			bundle.putString("armor_slot", Armor.Waist.toString());
			break;
		case R.id.charmImage:
			bundle.putString("armor_slot", Armor.Charm.toString());
		}
		
		intent.putExtras(bundle);
		view.startActivity(intent);
	}

}
