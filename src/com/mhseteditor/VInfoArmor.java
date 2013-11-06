package com.mhseteditor;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.mhseteditor.models.MArmor;
import com.mhseteditor.models.MGalery;
import com.seteditor.utils.Armor;

public class VInfoArmor extends Activity{
	
	private TextView armorName;
	private ImageView armorImage;
	private TextView[] skills;
	private TextView[] resistances;
	private MArmor armor;
	

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infoarmor);
        
        initSkillTexts();
        initResTexts();
        
        armorName = (TextView) findViewById(R.id.armorName);
        armorImage = (ImageView) findViewById(R.id.armorImage);
        
	}
	
	protected void onResume(){
		super.onResume();
		Bundle bundle = getIntent().getExtras();
		
		Armor armorSlot = Armor.valueOf(bundle.getString("armor_slot"));
		int setId = bundle.getInt("set_id");
		
		armor = MGalery.getInstance().getSetById(setId).getArmor(armorSlot.getId());
		
		updateView(armor);
	}
	
	private void initSkillTexts(){
		skills = new TextView[8];
		skills[0] = (TextView)findViewById(R.id.skill1);
		skills[1] = (TextView)findViewById(R.id.skill2);
		skills[2] = (TextView)findViewById(R.id.skill3);
		skills[3] = (TextView)findViewById(R.id.skill4);
		
	}
	private void initResTexts(){
		resistances = new TextView[8];
		resistances[0] = (TextView)findViewById(R.id.res1);
		resistances[1] = (TextView)findViewById(R.id.res2);
		resistances[2] = (TextView)findViewById(R.id.res3);
		resistances[3] = (TextView)findViewById(R.id.res4);
		resistances[4] = (TextView)findViewById(R.id.res5);
		resistances[5] = (TextView)findViewById(R.id.res6);
		resistances[6] = (TextView)findViewById(R.id.res7);
		resistances[7] = (TextView)findViewById(R.id.res8);
	}
	
	/**
	 * Updates view with the armor info
	 * @param armor
	 */
	
	public void updateView(MArmor armor){
		armorName.setText(armor.getName());
		resistances[0].setText("Dragon res: "+armor.getDragon_res());
		resistances[1].setText("Fire res: "+armor.getFire_res());
		resistances[2].setText("Ice res: "+armor.getIce_res());
		resistances[3].setText("Thunder res: "+armor.getThunder_res());
		resistances[4].setText("Water res: "+armor.getWater_res());
		resistances[5].setText("Defense: "+armor.getDefense());
		resistances[6].setText("Max Defense: "+armor.getMax_defense());
		
		for(int i=0; i<armor.getSkillsCount(); i++){
			skills[i].setText(armor.getSkills().get(i).getName()) ;
		}
	}

	/**
	 * @return the armorImage
	 */
	public ImageView getArmorImage() {
		return armorImage;
	}

	/**
	 * @param armorImage the armorImage to set
	 */
	public void setArmorImage(ImageView armorImage) {
		this.armorImage = armorImage;
	}

	/**
	 * @return the armorName
	 */
	public TextView getArmorName() {
		return armorName;
	}

	/**
	 * @param armorName the armorName to set
	 */
	public void setArmorName(TextView armorName) {
		this.armorName = armorName;
	}
}
