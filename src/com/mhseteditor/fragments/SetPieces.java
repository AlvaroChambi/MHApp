package com.mhseteditor.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mhseteditor.R;
import com.mhseteditor.VSetManager;
import com.mhseteditor.controllers.CSet;
import com.mhseteditor.models.MGalery;
import com.mhseteditor.models.MSet;
import com.mhseteditor.utils.Armor;

public class SetPieces extends Fragment{
	
	private static String ARG_PAGE;
	private int pageNumber;
	private MSet set;
	private TextView[] armorNames;
	private ImageView[] armorImages;
	private CSet controller;
	private VSetManager view;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARG_PAGE);
        view = (VSetManager)getActivity(); 
        
    }
	
	public void onResume(){
		super.onResume();
		set = MGalery.getInstance().getSet(pageNumber);
        updateInfo(set);
	}

	public static SetPieces create(int pageNumber){
		SetPieces fragment = new SetPieces();
		Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
		return fragment;
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
			//Inflate the layout for this fragment
			ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.setpieces, container, false);

			armorNames = new TextView[6];
	        
	        armorNames[Armor.Head.getId()] = (TextView)rootView.findViewById(R.id.headName);
	        armorNames[Armor.Chest.getId()] = (TextView)rootView.findViewById(R.id.chestName);
	        armorNames[Armor.Hands.getId()] = (TextView)rootView.findViewById(R.id.handName);
	        armorNames[Armor.Waist.getId()] = (TextView)rootView.findViewById(R.id.waistName);
	        armorNames[Armor.Feet.getId()] = (TextView)rootView.findViewById(R.id.feetName);
	        armorNames[Armor.Charm.getId()] = (TextView)rootView.findViewById(R.id.charmName);
	        
	        armorImages = new ImageView[6];
	        
	        armorImages[Armor.Head.getId()] = (ImageView)rootView.findViewById(R.id.headImage);
	        armorImages[Armor.Chest.getId()] = (ImageView)rootView.findViewById(R.id.chestImage);
	        armorImages[Armor.Hands.getId()] = (ImageView)rootView.findViewById(R.id.handImage);
	        armorImages[Armor.Waist.getId()] = (ImageView)rootView.findViewById(R.id.waistImage);
	        armorImages[Armor.Feet.getId()] = (ImageView)rootView.findViewById(R.id.feetImage);
	        armorImages[Armor.Charm.getId()] = (ImageView)rootView.findViewById(R.id.charmImage);
	        
	        controller = new CSet(view);
	        setClickListener(armorImages);
	        
        return rootView;
    }
	
	/**
	 * Updates the fragment view with the set info.
	 * @param set
	 */
	
	public void updateInfo(MSet set){
		
		for(int i=0; i<armorNames.length ; i++){
			if(set.getEquipedSlots()[i] == true){
				armorNames[i].setText(set.getArmor(i).getName());
			}
		}
	}
	
	/**
	 * Set the click listener to the passed view list
	 * @param list
	 */
	
	private void setClickListener(View[] list){
		
		 for(int i=0; i<list.length; i++){
	        	list[i].setOnClickListener(controller);
	     }
	}

}
