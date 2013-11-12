package com.mhseteditor;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mhseteditor.models.MSet;

public class SetInfo1 extends Fragment{
	
	private TextView[] resistances;
	private TextView defense;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("fragmentLife","onCreate fragment info");
    }
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
		ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.setinfo1, container, false);
		
		resistances = new TextView[5];
		defense = (TextView)rootView.findViewById(R.id.defValue);
		
		resistances[0]=(TextView)rootView.findViewById(R.id.fireValue);
		resistances[1]=(TextView)rootView.findViewById(R.id.waterValue);
		resistances[2]=(TextView)rootView.findViewById(R.id.iceValue);
		resistances[3]=(TextView)rootView.findViewById(R.id.thunderValue);
		resistances[4]=(TextView)rootView.findViewById(R.id.dragonValue);
		
        return rootView;
    }
	
	public void updateView(MSet set){
		
		
		
		if(checkAvailability(set)){
			resistances[0].setText(String.valueOf(set.getTotalFireRes())) ;
			resistances[1].setText(String.valueOf(set.getTotalWaterRes())) ;
			resistances[2].setText(String.valueOf(set.getTotalIceRes())) ;
			resistances[3].setText(String.valueOf(set.getTotalThunderRes())) ;
			resistances[4].setText(String.valueOf(set.getTotalDragonRes())) ;
			
			defense.setText(String.valueOf(set.getTotalDefense()));
		}
	}
	
	private boolean checkAvailability(MSet set){
		
		int orientation = getResources().getConfiguration().orientation;
		boolean resul = false;
		if(orientation == Configuration.ORIENTATION_LANDSCAPE && set!= null && resistances!= null){
			resul = true;
		}
		
		return resul;
	}
		
		
	

}
