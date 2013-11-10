package com.mhseteditor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.mhseteditor.models.MSet;

public class VSetManager extends FragmentActivity{
	
	private MSet set;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setmanager);
	}	

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_setmanager, menu); 
        return super.onCreateOptionsMenu(menu);
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

}
