package com.mhseteditor;


import java.util.Iterator;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mhseteditor.models.MSet;
import com.mhseteditor.utils.Abilitie;

public class SetInfo1 extends Fragment{
	
	private TextView[] resistances;
	private TextView defense;
	private TextView[] abilities;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("fragmentLife","onCreate fragment info1");
    }
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
		ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.setinfo1, container, false);
		
		abilities = new TextView[10];

		abilities[0] = (TextView)rootView.findViewById(R.id.hab1);
		abilities[1] = (TextView)rootView.findViewById(R.id.hab2);
		abilities[2] = (TextView)rootView.findViewById(R.id.hab3);
		abilities[3] = (TextView)rootView.findViewById(R.id.hab4);
		abilities[4] = (TextView)rootView.findViewById(R.id.hab5);
		abilities[5] = (TextView)rootView.findViewById(R.id.hab6);
		abilities[6] = (TextView)rootView.findViewById(R.id.hab7);
		abilities[7] = (TextView)rootView.findViewById(R.id.hab8);
		abilities[8] = (TextView)rootView.findViewById(R.id.hab9);
		abilities[9] = (TextView)rootView.findViewById(R.id.hab10);
		
		defense = (TextView)rootView.findViewById(R.id.defValue);
		
		resistances = new TextView[5];
		
		resistances[0]=(TextView)rootView.findViewById(R.id.fireValue);
		resistances[1]=(TextView)rootView.findViewById(R.id.waterValue);
		resistances[2]=(TextView)rootView.findViewById(R.id.iceValue);
		resistances[3]=(TextView)rootView.findViewById(R.id.thunderValue);
		resistances[4]=(TextView)rootView.findViewById(R.id.dragonValue);
		
		VSetManager view = (VSetManager)getActivity();
		updateView(view.getSet());
		
        return rootView;
    }
	
	
	public void updateView(MSet set){
		
		int orientation = getResources().getConfiguration().orientation;
		switch(orientation){
		case Configuration.ORIENTATION_LANDSCAPE:
			updateResistances(set);
			updateAbilities(set);
			break;
		case Configuration.ORIENTATION_PORTRAIT:
			updateResistances(set);
			break;
		}

		if(checkAvailability(set)){
			
		}
	}
	private void updateResistances(MSet set){
		
		resistances[0].setText(String.valueOf(set.getTotalFireRes())) ;
		resistances[1].setText(String.valueOf(set.getTotalWaterRes())) ;
		resistances[2].setText(String.valueOf(set.getTotalIceRes())) ;
		resistances[3].setText(String.valueOf(set.getTotalThunderRes())) ;
		resistances[4].setText(String.valueOf(set.getTotalDragonRes())) ;
		
		defense.setText(String.valueOf(set.getTotalDefense()));
	}
	
	private void updateAbilities(MSet set){
		
		String skill;
		int value;
		int i = 0;
		
		Iterator <String> iterator = set.getTotalSkills().iterator();
		while(iterator.hasNext()){
			skill = iterator.next();
			value = set.getSkillValue(skill);
			Abilitie abilitie = Abilitie.getActiveAbilitie(skill, value);
			if(abilitie!=null){
				abilities[i].setText(abilitie.toString());
			}
		}
		
	}
	
	private boolean checkAvailability(MSet set){
		
		boolean resul = false;
		if(set!= null && resistances!= null){
			resul = true;
		}
		
		return resul;
	}
		
		
	

}
