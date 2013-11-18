package com.mhseteditor.fragments;

import java.util.Iterator;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.mhseteditor.R;
import com.mhseteditor.VSetManager;
import com.mhseteditor.models.MSet;
import com.mhseteditor.utils.Abilitie;
import com.mhseteditor.utils.InfoLineAdapter;

public class SetInfo2 extends Fragment{
	
	private InfoLineAdapter adapter;
	private ListView lineView;
	private TextView[] abilities;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
		ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.setinfo2, container, false);
		lineView = (ListView) rootView.findViewById(R.id.ListView1);
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
		
		VSetManager view = (VSetManager) getActivity();
		updateView(view.getSet());
		
		Log.i("lyfecicle","SetInfo2 inflated and added");
        return rootView;
    }
	
	/**
	 * Takes a set and updates the fragments view info taking in account the orientation.
	 * @param set
	 */
	
	public void updateView(MSet set){
		
		int orientation = getResources().getConfiguration().orientation;
		
		switch(orientation){
		case Configuration.ORIENTATION_LANDSCAPE:
			
			adapter = new InfoLineAdapter(getActivity(),set);
			adapter.updateSet(set);
			lineView.setAdapter(adapter);
			
			break;
		case Configuration.ORIENTATION_PORTRAIT:
			
			updateAbilities(set);
			
			break;
		}
	}
	
	/**
	 * Updates the abilities with the set info
	 * @param set
	 */
	
	private void updateAbilities(MSet set){
		
		String skill;
		int value;
		int i = 0;
		
		Iterator <String> iterator = set.getTotalSkills().iterator();
		while(iterator.hasNext()){
			String abilitieName = "";
			skill = iterator.next();
			value = set.getSkillValue(skill);
			Abilitie abilitie = Abilitie.getActiveAbilitie(skill, value);
			if(abilitie!=null){
				abilitieName = abilitie.getName();
			}
			abilities[i].setText(abilitieName);
			i++;
		}
		
		for(int j =i; j<abilities.length; j++){
			abilities[j].setText("");
		}
	}
}
