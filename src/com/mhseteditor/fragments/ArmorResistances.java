package com.mhseteditor.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mhseteditor.R;
import com.mhseteditor.VInfoArmor;
import com.mhseteditor.models.MArmor;

public class ArmorResistances extends Fragment{
	
	private TextView defense;
	private TextView maxDefense;
	private TextView[] resistances;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
		ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.armor_resist, container, false);
		
		
		defense = (TextView)rootView.findViewById(R.id.defValue);
		maxDefense = (TextView)rootView.findViewById(R.id.maxDefValue);
		
		resistances = new TextView[5];
		
		resistances[0]=(TextView)rootView.findViewById(R.id.fireValue);
		resistances[1]=(TextView)rootView.findViewById(R.id.waterValue);
		resistances[2]=(TextView)rootView.findViewById(R.id.iceValue);
		resistances[3]=(TextView)rootView.findViewById(R.id.thunderValue);
		resistances[4]=(TextView)rootView.findViewById(R.id.dragonValue);
		
		VInfoArmor view = (VInfoArmor)getActivity();
		updateView(view.getArmor());
		
        return rootView;
    }
	
	public void updateView(MArmor armor){
		
		if(armor!= null){

			resistances[0].setText(String.valueOf(armor.getDragon_res()));
			resistances[1].setText(String.valueOf(armor.getFire_res()));
			resistances[2].setText(String.valueOf(armor.getIce_res()));
			resistances[3].setText(String.valueOf(armor.getThunder_res()));
			resistances[4].setText(String.valueOf(armor.getWater_res()));
			
			defense.setText(String.valueOf(armor.getDefense()));
			maxDefense.setText(String.valueOf(armor.getMax_defense()));
		}
	}

}
