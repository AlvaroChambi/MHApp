package com.mhseteditor;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.mhseteditor.controllers.CSet;
import com.mhseteditor.models.MGalery;
import com.mhseteditor.models.MSet;
import com.mhseteditor.utils.Armor;

public class VViewSet extends Activity {
	
	private TextView[] armorNames;
	private ImageView[] armorImages;
	private CSet controller;
	private MSet set;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infoset);
        
        armorNames = new TextView[6];
        
        armorNames[Armor.Head.getId()] = (TextView)findViewById(R.id.headName);
        armorNames[Armor.Chest.getId()] = (TextView)findViewById(R.id.chestName);
        armorNames[Armor.Hands.getId()] = (TextView)findViewById(R.id.handName);
        armorNames[Armor.Waist.getId()] = (TextView)findViewById(R.id.waistName);
        armorNames[Armor.Feet.getId()] = (TextView)findViewById(R.id.feetName);
        armorNames[Armor.Charm.getId()] = (TextView)findViewById(R.id.charmName);
        
        armorImages = new ImageView[6];
        
        armorImages[Armor.Head.getId()] = (ImageView)findViewById(R.id.headImage);
        armorImages[Armor.Chest.getId()] = (ImageView)findViewById(R.id.chestImage);
        armorImages[Armor.Hands.getId()] = (ImageView)findViewById(R.id.handImage);
        armorImages[Armor.Waist.getId()] = (ImageView)findViewById(R.id.waistImage);
        armorImages[Armor.Feet.getId()] = (ImageView)findViewById(R.id.feetImage);
        armorImages[Armor.Charm.getId()] = (ImageView)findViewById(R.id.charmImage);
        
        //controller = new CSet(this);
        
        for(int i=0; i<armorNames.length; i++){
        	//armorNames[i].setOnClickListener(controller);
        	armorImages[i].setOnClickListener(controller);
        }
	}
	
	protected void onResume(){
		super.onResume();
		
		Bundle bundle = getIntent().getExtras();
		int setPosition = bundle.getInt("set_position");
		
		set = MGalery.getInstance().getSet(setPosition);
		
		updateInfo(set);
	}
	
	@Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        
    }

	/**
	 * @return the set
	 */
	public MSet getSet() {
		return set;
	}

	/**
	 * @param set the set to set
	 */
	public void setSet(MSet set) {
		this.set = set;
	}
	
	/**
	 * Updates the view with the set info.
	 * @param set
	 */
	
	public void updateInfo(MSet set){
		
		for(int i=0; i<armorNames.length ; i++){
			if(set.getEquipedSlots()[i] == true){
				armorNames[i].setText(set.getArmor(i).getName());
			}
		}
	}
}
