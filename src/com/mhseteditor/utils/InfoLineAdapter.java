package com.mhseteditor.utils;

import java.util.Iterator;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mhseteditor.R;
import com.mhseteditor.models.MArmor;
import com.mhseteditor.models.MSet;

public class InfoLineAdapter extends BaseAdapter{
	
	private Context context;
	private MSet set;
	private TextView skill;
	private TextView[] skillValues;
	private String[] skills;

    public InfoLineAdapter(Context c, MSet set) {
        context = c;
        this.set = set;
        initSkills();
    }

	public int getCount() {
        return set.getSkillsCount() ;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View inflatedView = convertView;

    	LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    	
    	inflatedView = inflater.inflate(R.layout.skill_line, null);
    	skillValues = new TextView[6];
    	
    	skill = (TextView)inflatedView.findViewById(R.id.skill);
    	
    	skillValues[Armor.Head.getId()] = (TextView)inflatedView.findViewById(R.id.skill_head);
    	skillValues[Armor.Chest.getId()] = (TextView)inflatedView.findViewById(R.id.skill_chest);
    	skillValues[Armor.Hands.getId()] = (TextView)inflatedView.findViewById(R.id.skill_hands);
    	skillValues[Armor.Waist.getId()] = (TextView)inflatedView.findViewById(R.id.skill_waist);
    	skillValues[Armor.Feet.getId()] = (TextView)inflatedView.findViewById(R.id.skill_feet);
    	skillValues[Armor.Charm.getId()] = (TextView)inflatedView.findViewById(R.id.skill_charm);
    	
    	if (convertView == null) { 
    		
    		// if it's not recycled, initialize some attributes
            //inflatedView.setLayoutParams(new GridView.LayoutParams(85, 85));
           // inflatedView.setScaleType(ImageView.ScaleType.CENTER_CROP);
           // inflatedView.setPadding(8, 8, 8, 8);
        } else {
            inflatedView =  convertView;
        }

        updateView(position);
        
        return inflatedView;
	}
	
	public void updateSet(MSet set) {
		this.set = set;
	}
	
	private void updateView(int position){
		if(skills.length>0){
			Log.i("ListSkill","set name: "+set.getName());
			skill.setText(skills[position]);
			String skill = skills[position];
			Log.i("ListSkill",skill);
			for(int i=0; i<skillValues.length; i++){
				
				MArmor armor = set.getArmor(i);
				int value = 0;
				if(armor!=null){
					Log.i("ListSkill",armor.getName());
					value = armor.getSkill(skill);
					Log.i("ListSkill","value: "+armor.getSkill(skill));
				}
				skillValues[i].setText(String.valueOf(value));
			}
		}
	}
	
	private void initSkills() {
		
		int i = 0;
		skills = new String[set.getSkillsCount()];
		Iterator<String> iterator = set.getTotalSkills().iterator();
		
		while(iterator.hasNext()){
			skills[i] = iterator.next();
			i++;
		}		
	}
}
