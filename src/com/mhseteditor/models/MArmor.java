package com.mhseteditor.models;

import java.util.ArrayList;

import com.seteditor.utils.Armor;

public class MArmor {
	
	private int id;
	private String name;
	private Armor slot;
	private String hunter_type;
	private int numSlots;
	private int fire_res;
	private int ice_res;
	private int water_res;
	private int dragon_res;
	private int thunder_res;
	private int defense;
	private int max_defense;
	private int jewelCount;
	private int skillsCount;
	private MJewel[] jewels;
	private ArrayList<MSkill> skills;
	
	public MArmor(){
		skills = new ArrayList<MSkill>();
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	/**
	 * @return the slot
	 */
	public Armor getSlot() {
		return slot;
	}

	/**
	 * @param slot the slot to set
	 */
	public void setSlot(Armor slot) {
		this.slot = slot;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the hunter_type
	 */
	public String getHunter_type() {
		return hunter_type;
	}
	/**
	 * @param hunter_type the hunter_type to set
	 */
	public void setHunter_type(String hunter_type) {
		this.hunter_type = hunter_type;
	}

	/**
	 * @return the numSlots
	 */
	public int getNumSlots() {
		return numSlots;
	}
	/**
	 * Sets the number o jewel slots and initialize array of jewels.
	 * @param numSlots the numSlots to set
	 */
	public void setNumSlots(int numSlots) {
		this.numSlots = numSlots;
		jewels = new MJewel[numSlots];
	}
	/**
	 * @return the fire_res
	 */
	public int getFire_res() {
		return fire_res;
	}
	/**
	 * @param fire_res the fire_res to set
	 */
	public void setFire_res(int fire_res) {
		this.fire_res = fire_res;
	}
	/**
	 * @return the ice_res
	 */
	public int getIce_res() {
		return ice_res;
	}
	/**
	 * @param ice_res the ice_res to set
	 */
	public void setIce_res(int ice_res) {
		this.ice_res = ice_res;
	}
	/**
	 * @return the water_res
	 */
	public int getWater_res() {
		return water_res;
	}
	/**
	 * @param water_res the water_res to set
	 */
	public void setWater_res(int water_res) {
		this.water_res = water_res;
	}
	/**
	 * @return the dragon_res
	 */
	public int getDragon_res() {
		return dragon_res;
	}
	/**
	 * @param dragon_res the dragon_res to set
	 */
	public void setDragon_res(int dragon_res) {
		this.dragon_res = dragon_res;
	}
	/**
	 * @return the thunder_res
	 */
	public int getThunder_res() {
		return thunder_res;
	}
	/**
	 * @param thunder_res the thunder_res to set
	 */
	public void setThunder_res(int thunder_res) {
		this.thunder_res = thunder_res;
	}
	/**
	 * @return the defense
	 */
	public int getDefense() {
		return defense;
	}
	/**
	 * @param defense the defense to set
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}
	/**
	 * @return the max_defense
	 */
	public int getMax_defense() {
		return max_defense;
	}
	/**
	 * @param max_defense the max_defense to set
	 */
	public void setMax_defense(int max_defense) {
		this.max_defense = max_defense;
	}

	/**
	 * @return the jewels
	 */
	public MJewel[] getJewels() {
		return jewels;
	}

	/**
	 * @return the skills
	 */
	public ArrayList<MSkill> getSkills() {
		return skills;
	}

	/**
	 * the jewel array is null if the number of slots it's not defined yet
	 * @param jewel
	 */
	
	public void addJewel(MJewel jewel){
		if(jewelCount < jewels.length){
			jewels[jewelCount] = jewel;
			jewelCount++;
		}
	}
	/**
	 * Returns the number of jewels attached to the armor
	 * @return jewelCount 
	 */
	public int getJewelCount(){
		return jewelCount;
	}
	
	/**
	 * Link a skill to the armor
	 * @param skill
	 */
	
	public void addSkill(MSkill skill){
		skills.add(skill);
		skillsCount++;
	}

	/**
	 * Return the number of skills linked to the armor
	 * @return skillsCount
	 */
	public int getSkillsCount() {
		return skillsCount;
	}	
}
