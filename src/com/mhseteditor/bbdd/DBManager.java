package com.mhseteditor.bbdd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.mhseteditor.models.MArmor;
import com.mhseteditor.models.MGalery;
import com.mhseteditor.models.MSet;
import com.mhseteditor.models.MSkill;
import com.seteditor.utils.Armor;


/**
 * Singleton class that will handle all the interaction with the database.
 * 
 * @author AF
 *
 */

public class DBManager {
	
	private static DBManager instance;
	
	private SQLiteDatabase database;
	private DataBaseHelper dbHelper;
	
	private DBManager(DataBaseHelper dbHelper){
		database = null;
		this.dbHelper = dbHelper;
	}
	
	//TODO Cambiar para gestionar mas de una galeria.
	
	public static DBManager getInstance(DataBaseHelper dbHelper){
		
		if(instance == null){
			instance = new DBManager(dbHelper);
		}
		return instance;
	}
	
	/**
	 * Method that return an DBManager instance, the DBManager object must be already instantiated, in other cases it will return null
	 * @return
	 */
	
	public static DBManager getInstance(){
		return instance;
	}
	
	/**
	 * Loads galery, sets and armor resources into memory
	 */
	
	public void loadResources(){
		Cursor cursor;
		MGalery galery = MGalery.getInstance();
		
		database = dbHelper.getReadableDatabase();
		
		/**************Load Sets************/
		cursor = database.query("ArmorSet", null, null, null, null, null, null);
		if(cursor.moveToFirst()){
            do{
            	MSet set = new MSet();
            	set.setId(cursor.getInt(0));
            	set.setName(cursor.getString(1));
            	set.setDescription(cursor.getString(2));
            	galery.addSet(set);
            	
            	Log.i("database",set.getName());
            }while(cursor.moveToNext());
		}
		
		/**************Load Armor************/
		
		for(int i=0; i<galery.getCount(); i++){
			MSet set = galery.getSet(i);
			cursor = database.query("Armor",null,"set__id="+set.getId(),null,null,null,null);
			 if(cursor.moveToFirst()){
				 do{
					 MArmor armor = new MArmor();
			         armor.setId(cursor.getInt(0));
			         armor.setName(cursor.getString(1));
			         armor.setSlot(Armor.valueOf(cursor.getString(2)));
			         armor.setDefense(cursor.getInt(3));
			         armor.setMax_defense(cursor.getInt(4));
			         armor.setFire_res(cursor.getInt(5));
			         armor.setThunder_res(cursor.getInt(6));
			         armor.setDragon_res(cursor.getInt(7));
			         armor.setWater_res(cursor.getInt(8));
			         armor.setIce_res(cursor.getInt(9));
			         armor.setHunter_type(cursor.getString(10));
			         armor.setNumSlots(11);
			         armor = loadSkills(armor);
			         set.addArmor(armor);

			     }while(cursor.moveToNext());
			 }
		}
	}
	
	/**
	 * Load into memoery the skills linked to the armor and attaches them to it
	 */
	
	private MArmor loadSkills(MArmor armor){
		
		/**************Load Armor Skills************/
		
		SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
		queryBuilder.setTables("ARMORSKILL,SKILL");
		queryBuilder.appendWhere("ARMORSKILL.skill__id = SKILL._id");
		String columns[] = {"_id","name","modifier"};
		Cursor cursor = queryBuilder.query(database, columns, null, null, null, null, null);
		 if(cursor.moveToFirst()){
			 do{
				 MSkill skill = new MSkill();
				 skill.setId(cursor.getInt(0));
				 skill.setName(cursor.getString(1));
				 skill.setModifier(cursor.getInt(2));
				 armor.addSkill(skill);

		     }while(cursor.moveToNext());
		 }
		return armor;
	}
}
