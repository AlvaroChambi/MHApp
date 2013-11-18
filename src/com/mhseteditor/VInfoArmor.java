package com.mhseteditor;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.mhseteditor.fragments.ArmorResistances;
import com.mhseteditor.fragments.ArmorSkills;
import com.mhseteditor.models.MArmor;
import com.mhseteditor.models.MGalery;
import com.mhseteditor.utils.Armor;

public class VInfoArmor extends FragmentActivity{
	
	private MArmor armor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_infoarmor);
		Bundle bundle = getIntent().getExtras();
		
		Armor armorSlot = Armor.valueOf(bundle.getString("armor_slot"));
		int setId = bundle.getInt("set_id");
		
		armor = MGalery.getInstance().getSetById(setId).getArmor(armorSlot.getId());

	}
	
	protected void onResume(){
		super.onResume();
		
		updateView(armor);
	}
	
	public void updateView(MArmor armor){
		
		FragmentManager fragmentManager = this.getSupportFragmentManager();
		ArmorSkills armorSkills = (ArmorSkills)fragmentManager.findFragmentById(R.id.armor_skills);
		ArmorResistances armorResis = (ArmorResistances)fragmentManager.findFragmentById(R.id.armor_resistances);
		
		armorSkills.updateView(armor);
		armorResis.updateView(armor);
	}
	
	/**
	 * @return the armor
	 */
	public MArmor getArmor() {
		return armor;
	}
}
