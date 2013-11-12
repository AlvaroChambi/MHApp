package com.mhseteditor.models;

import android.widget.ImageView;

import com.seteditor.utils.Abilities;


public class MSet {
	
	private int id;
	private int numSlots;
	private String name;
	private String description;
	private ImageView imageView;
	private MArmor[] equiped;
	private boolean[] equipedSlots;
	private Abilities[] Abilities;
	
	private int totalDefense;
	private int totalFireRes;
	private int totalIceRes;
	private int totalThunderRes;
	private int totalDragonRes;
	private int totalWaterRes;
	
	
	
	public MSet(){
		id = -1;
		numSlots = -1;
		name = "";
		description = "";
		totalDefense = 0;
		totalFireRes = 0;
		totalIceRes = 0;
		totalThunderRes = 0;
		totalDragonRes = 0;
		totalWaterRes = 0;
		equiped = new MArmor[6];
		equipedSlots = new boolean[6];
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
	 * @return the numSlots
	 */
	public int getNumSlots() {
		return numSlots;
	}
	/**
	 * @param numSlots the numSlots to set
	 */
	public void setNumSlots(int numSlots) {
		this.numSlots = numSlots;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the imageView
	 */
	public ImageView getImageView() {
		return imageView;
	}
	/**
	 * @param imageView the imageView to set
	 */
	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}
	
	public MArmor getArmor(int armor_index){
		return equiped[armor_index];
	}
	
	public boolean[] getEquipedSlots(){
		return equipedSlots;
	}
	
	
	public void addArmor(MArmor armor){
		
		int slotId = armor.getSlot().getId();
	
		if(equipedSlots[slotId] == false){
			equiped[slotId] = armor;
			equipedSlots[slotId] = true;
			updateTotalValues(equiped[slotId]);
		}
	}
	
	private void updateTotalValues(MArmor armor){
		totalDefense += armor.getMax_defense();
		totalFireRes += armor.getFire_res();
		totalIceRes += armor.getIce_res();
		totalThunderRes += armor.getThunder_res();
		totalDragonRes += armor.getDragon_res();
		totalWaterRes += armor.getWater_res();
	}
	
	public void deleteArmor(){
		
	}
	
	/**
	 * @return the totalDefense
	 */
	public int getTotalDefense() {
		return totalDefense;
	}
	/**
	 * @return the totalFireRes
	 */
	public int getTotalFireRes() {
		return totalFireRes;
	}
	/**
	 * @return the totalIceRes
	 */
	public int getTotalIceRes() {
		return totalIceRes;
	}
	/**
	 * @return the totalThunderRes
	 */
	public int getTotalThunderRes() {
		return totalThunderRes;
	}
	/**
	 * @return the totalDragonRes
	 */
	public int getTotalDragonRes() {
		return totalDragonRes;
	}
	
	/**
	 * @return the totalWaterRes
	 */
	public int getTotalWaterRes() {
		return totalWaterRes;
	}
}
