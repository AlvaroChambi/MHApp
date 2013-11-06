package com.mhseteditor.models;

import android.widget.ImageView;


public class MSet {
	
	private int id;
	private int numSlots;
	private String name;
	private String description;
	private ImageView imageView;
	private MArmor[] equiped;
	private boolean[] equipedSlots;
	
	public MSet(){
		id = -1;
		numSlots = -1;
		name = "";
		description = "";
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
		}
	}
	
	public void deleteArmor(){
		
	}
}
