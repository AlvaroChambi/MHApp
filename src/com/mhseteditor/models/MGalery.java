package com.mhseteditor.models;

import java.util.ArrayList;
import java.util.Iterator;

public class MGalery {
	
	private static MGalery instance = null;
	private ArrayList<MSet> sets;
	private int count;
	
	private MGalery(){	
		sets = new ArrayList<MSet>();
		count = 0;
	}
	public static MGalery getInstance(){
		if(instance == null){
			instance = new MGalery();
		}
		return instance;
	}
	
	public void addSet(MSet set){
		if(set!=null){
			sets.add(set);
			count++;
		}
	}
	
	public MSet getSet (int position){
		return sets.get(position);
	}
	
	public MSet getSetById (int id){
		
		MSet set = null;
		boolean flag = false;
		Iterator<MSet> iterator = sets.iterator();
		while(iterator.hasNext() && !flag){
			set = iterator.next();
			if(set.getId() == id){
				flag = true;
			}
		}
		return set;
	}
	
	public int getCount(){
		return count;
	}
}
