package com.mhseteditor.utils;

public enum Abilitie {
	
	
	Gathering1 ("Gathering+1",10,14,"Gathering"),
	Gathering2 ("Gathering+2",15,-2, "Gathering"),
	Gathering0 ("Gathering-1",-2,-10,"Gathering"),
	SpdGather ("Speed Gatherer",10,-2,"SpdGather"),
	Whim0 ("Spectre's Whim",-10, -14, "Whim"),
	Whim1 ("Devil's Whim",-2,-15, "Whim"),
	Whim2 ("Spirit's Whim",10,14, "Whim"),
	Whim3 ("Divine's Whim",15,-2, "Whim");
	
	
	private String reference;
	private String name;
	private int min;
	private int max;
	public static final int INFINITE = -2;
	
	private Abilitie(String reference, int min, int max, String name){
		this.name = name;
		this.name = name;
		this.min = min;
		this.max = max;
	}

	public String getName() {
		return name;
	}
	
	
	public String getreference(){
		return reference;
	}
	
	/**
	 * Given a skill reference and value, getActiveAbilities() method returns the associated active Ability,
	 *  measures the range in which the abilities get active and returns the fit. 
	 *  Returns null if our value doesn't reach any activation point.
	 * 
	 * @param reference
	 * @param value
	 * @return 
	 */
	
	public static Abilitie getActiveAbilitie(String reference, int value){
		
		Abilitie resul = null;
		Abilitie[] abilitiesList = Abilitie.values();
		
		for(int i=0; i< abilitiesList.length; i++){
			if(reference == abilitiesList[i].reference ){
				if(abilitiesList[i].min == INFINITE){
					if (value <= abilitiesList[i].max ){
						resul = abilitiesList[i];
					}
				}else if(abilitiesList[i].max == INFINITE){
					if(value >= abilitiesList[i].min){
						resul = abilitiesList[i];
					}
				}else if(abilitiesList[i].min <= value && value <=abilitiesList[i].max){
					resul = abilitiesList[i];
				}
				resul = abilitiesList[i];
			}
		}
		return resul;
	}
}
