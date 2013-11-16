 package com.mhseteditor;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.mhseteditor.models.MGalery;
import com.mhseteditor.models.MSet;
import com.mhseteditor.utils.FragmentHelper;

public class VSetManager extends FragmentActivity{
	
	public static final int INFO1 = 1;
	public static final int INFO2 = 2;
	
	public static int NUM_PAGES;
	private MSet set;
	private int setPosition;
	private int activePanel;
	private FragmentHelper fragmentHelper;
	private boolean fragmentsAdded;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setmanager);
		
		NUM_PAGES = MGalery.getInstance().getCount();
		activePanel = INFO1;
		fragmentsAdded = false;
		fragmentHelper = new FragmentHelper(this);
		
		Bundle bundle = getIntent().getExtras();
		setPosition = bundle.getInt("set_position");
		set = MGalery.getInstance().getSet(setPosition);
	}	
	
	public void onResume(){
		super.onResume();
		fragmentHelper.setPager();
		fragmentHelper.addFragment();
		Log.i("lifecycle","fragments añadidos");
		//fragmentHelper.updateView();
	}
	
	public void onPause(){
		super.onPause();
		fragmentHelper.resetFragments();
		Log.i("lifecycle","fragments reseteados");
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_setmanager, menu); 
        return super.onCreateOptionsMenu(menu);
    }
	
	
	
	

	/**
	 * @return the setPosition
	 */
	public int getSetPosition() {
		return setPosition;
	}

	/**
	 * @param setPosition the setPosition to set
	 */
	public void setSetPosition(int setPosition) {
		this.setPosition = setPosition;
	}

	/**
	 * @return the set
	 */
	public MSet getSet() {
		return set;
	}

	/**
	 * @param set the set to set
	 */
	public void setSet(MSet set) {
		this.set = set;
	}
	
	
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {

    	boolean resul = false;

        switch(item.getItemId()){
        case R.id.info_page:
        	
        	
        	if(activePanel == INFO1){
        		item.setIcon(R.drawable.menu2);
        	}else{
        		item.setIcon(R.drawable.menu1);
        	}

        	fragmentHelper.switchFragment();
        	updateActiveInfo();
        	break;
        }
       return resul;
    }
	
	
	
	private void updateActiveInfo(){
		
		if(activePanel == INFO1){
			activePanel = INFO2;
		}else{
			activePanel = INFO1;
		}
	}
	

	/**
	 * @return the activePanel
	 */
	public int getActivePanel() {
		return activePanel;
	}

	/**
	 * @param activePanel the activePanel to set
	 */
	public void setActivePanel(int activePanel) {
		this.activePanel = activePanel;
	}
	
	public FragmentHelper fragmentHelper(){
		return fragmentHelper;
	}

	/**
	 * @return the fragmentsAdded
	 */
	public boolean isFragmentsAdded() {
		return fragmentsAdded;
	}

	/**
	 * @param fragmentsAdded the fragmentsAdded to set
	 */
	public void setFragmentsAdded(boolean fragmentsAdded) {
		this.fragmentsAdded = fragmentsAdded;
	}
}
