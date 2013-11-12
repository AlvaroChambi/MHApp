package com.seteditor.utils;

public enum Abilities {
	Gathering1 ("Gathering+1",10,"Gathering"),
	Gathering2 ("Gathering+2",15,"Gathering"),
	Gathering0 ("Gathering-1",-10,"Gathering"),
	SpdGather ("Speed Gatherer",10,"SpdGather"),
	Whim0 ("Spectre's Whim",-10, "Whim"),
	Whim1 ("Devil's Whim",-15, "Whim"),
	Whim2 ("Spirit's Whim",10, "Whim"),
	Whim3 ("Divine's Whim",15, "Whim");
	
	private String value;
	private String name;
	private int modifier;
	
	private Abilities(String value, int modifier, String name){
		this.name = name;
		this.modifier = modifier;
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public int getModifier(){
		return modifier;
	}
	
	public String getValue(){
		return value;
	}
}
