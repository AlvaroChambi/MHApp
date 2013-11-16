package com.mhseteditor.utils;

public enum Armor {
	Head (0),
	Chest (1),
	Hands (2),
	Waist (3),
	Feet (4),
	Charm (5);
	
	private int id;
	
	private Armor (int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	} 
}
