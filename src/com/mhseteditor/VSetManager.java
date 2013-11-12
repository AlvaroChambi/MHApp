 package com.mhseteditor;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.mhseteditor.models.MGalery;
import com.mhseteditor.models.MSet;
import com.seteditor.utils.PageAdapter;
import com.seteditor.utils.PageChangedListener;

public class VSetManager extends FragmentActivity{
	
	public static int NUM_PAGES;
	private MSet set;
	private ViewPager pager;
	private int setPosition;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setmanager);
		
		NUM_PAGES = MGalery.getInstance().getCount();
		
		Bundle bundle = getIntent().getExtras();
		setPosition = bundle.getInt("set_position");
		set = MGalery.getInstance().getSet(setPosition);
	}	
	
	public void onResume(){
		super.onResume();
		setPager();
		//updateInfo1();
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_setmanager, menu); 
        return super.onCreateOptionsMenu(menu);
    }
	
	
	public void setPager(){
		
		PageChangedListener pChangedListener = new PageChangedListener(this);
		pager = (ViewPager) findViewById(R.id.pager);
        
        PageAdapter mPagerAdapter = new PageAdapter(getSupportFragmentManager());
        pager.setAdapter(mPagerAdapter);
        pager.setOffscreenPageLimit(1);
        pager.setCurrentItem(setPosition);
        pager.setOnPageChangeListener(pChangedListener);
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
	
	public void updateInfo1(){
		FragmentManager fragmentManager = this.getSupportFragmentManager();
		SetInfo1 infoFragment =(SetInfo1) fragmentManager.findFragmentById(R.id.setInfo1);
		if(infoFragment!=null){
			infoFragment.updateView(set);
		}
		
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {

    	boolean resul = false;

        switch(item.getItemId()){
        case R.id.setInfo1:
        	//TODO Make fragment transaction to change this viewfragment
        	break;
        }
       return resul;
    }
}
