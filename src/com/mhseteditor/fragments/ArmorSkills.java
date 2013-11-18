package com.mhseteditor.fragments;

import java.util.Iterator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mhseteditor.R;
import com.mhseteditor.VInfoArmor;
import com.mhseteditor.models.MArmor;

public class ArmorSkills extends Fragment {
	
	private TextView armorName;
	private TextView[] skills;
	private ImageView[] sockets;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
		ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.armor_skills, container, false);
		
		armorName = (TextView)rootView.findViewById(R.id.armorName);
		skills = new TextView[6];
		skills[0] = (TextView)rootView.findViewById(R.id.skill1);
		skills[1] = (TextView)rootView.findViewById(R.id.skill2);
		skills[2] = (TextView)rootView.findViewById(R.id.skill3);
		skills[3] = (TextView)rootView.findViewById(R.id.skill4);
		skills[4] = (TextView)rootView.findViewById(R.id.skill5);
		skills[5] = (TextView)rootView.findViewById(R.id.skill6);
		
		sockets = new ImageView[4];
		sockets[0] = (ImageView)rootView.findViewById(R.id.socket1);
		sockets[1] = (ImageView)rootView.findViewById(R.id.socket2);
		sockets[2] = (ImageView)rootView.findViewById(R.id.socket3);
		sockets[3] = (ImageView)rootView.findViewById(R.id.socket4);
		
		VInfoArmor view = (VInfoArmor)getActivity();
		updateView(view.getArmor());
		
        return rootView;
    }
	
	/**
	 * Updates view with the armor info
	 * @param armor
	 */
	
	public void updateView(MArmor armor){
		
		if(armor!= null){
			armorName.setText(armor.getName());
			updateSkills(armor);
			updateSockets(armor);
		}
	}
	
	private void updateSkills(MArmor armor){
		String skill;
		int i = 0;
		Iterator<String> iterator = armor.getSkills().iterator();
		while(iterator.hasNext()){
			skill = iterator.next();
			skills[i].setText(skill + armor.getSkillValue(skill));
			i++;
		}
	}
	
	private void updateSockets(MArmor armor){
		
		Log.i("armorSKill","num sockets: " + armor.getNumSlots());
		for(int i =0; i< armor.getNumSlots(); i++){
			sockets[i].setImageResource(R.drawable.socket);
		}
	}

}
