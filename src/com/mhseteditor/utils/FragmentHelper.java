package com.mhseteditor.utils;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.mhseteditor.R;
import com.mhseteditor.SetInfo1;
import com.mhseteditor.SetInfo2;
import com.mhseteditor.VSetManager;



public class FragmentHelper {
	
	private static final String INFO1_TAG = "tag1";
	private static final String INFO2_TAG = "tag2";
	
	private VSetManager view;
	private SetInfo1 setInfo1;
	private SetInfo2 setInfo2;
	private FragmentManager fragmentManager;
	
	public FragmentHelper(VSetManager view){
		this.view = view;
		setInfo1 = new SetInfo1();
		setInfo2 = new SetInfo2();
		fragmentManager = view.getSupportFragmentManager();
		
	}
	
	/**
	 * Initializes the fragment view and attaches it to the main view.
	 * Checks the orientation and which has to be the active info panel and
	 * adds the respective fragment.
	 */

	public void addFragment() {
		
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		
		int orientation = view.getResources().getConfiguration().orientation;
		if(orientation == Configuration.ORIENTATION_PORTRAIT){
			if(view.getActivePanel() == VSetManager.INFO1){
				transaction.add(R.id.infoFrame,setInfo1,INFO1_TAG);
				transaction.commit();
				view.setFragmentsAdded(true);
				Log.i("fragHelper","añadido fragment 1 a la vista portrait");
			}else{
				transaction.add(R.id.infoFrame,setInfo2,INFO2_TAG);
				transaction.commit();
				view.setFragmentsAdded(true);
				Log.i("fragHelper","añadido fragment 2 a la vista portrait");
			}
		}else if(orientation == Configuration.ORIENTATION_LANDSCAPE  ){
			if(view.getActivePanel() == VSetManager.INFO1){
				transaction.add(R.id.infoFrame,setInfo1,INFO1_TAG);
				transaction.commit();
				view.setFragmentsAdded(true);
				Log.i("fragHelper","añadido fragment 1 a la vista landscape");
			}else{
				transaction.add(R.id.infoFrame,setInfo2,INFO2_TAG);
				transaction.commit();
				view.setFragmentsAdded(true);
				Log.i("fragHelper","añadido fragment 2 a la vista landscape");
			}
		}
			
	}
	
	/**
	 * Update the active fragments view.
	 */

	public void updateView() {
		
		if(view.isFragmentsAdded()){
			
			switch(view.getActivePanel()){
			case VSetManager.INFO1:
				setInfo1.updateView(view.getSet());
				break;
			case VSetManager.INFO2:
				setInfo2.updateView(view.getSet());
				break;
			}
		}
	}
	
	/**
	 * Initializes the view pager and attaches it to the main view.
	 */
	
	public void setPager() {
		PageChangedListener pChangedListener = new PageChangedListener(view);
		ViewPager pager = (ViewPager) view.findViewById(R.id.pager);
        
        PageAdapter mPagerAdapter = new PageAdapter(view.getSupportFragmentManager());
        pager.setAdapter(mPagerAdapter);
        pager.setOffscreenPageLimit(1);
        pager.setCurrentItem(view.getSetPosition());
        pager.setOnPageChangeListener(pChangedListener);
	}
	
	/**
	 * Switch beetween info panel fragments 
	 */
	
	public void switchFragment(){
		
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		
		switch(view.getActivePanel()){
		
		case VSetManager.INFO1:
			transaction.replace(R.id.infoFrame, setInfo2,INFO2_TAG);
			//transaction.add(R.id.infoFrame,setInfo2, INFO2_TAG);
			//transaction.remove(fragmentManager.findFragmentByTag(INFO1_TAG));
			//transaction.detach(fragmentManager.findFragmentByTag(INFO1_TAG));
			transaction.commit();
			//transaction.add(R.id.infoFrame,setInfo2);
			Log.i("fragHelper", "switched to info2");
			break;
		case VSetManager.INFO2:
			transaction.replace(R.id.infoFrame, setInfo1, INFO1_TAG);
			//transaction.remove(fragmentManager.findFragmentByTag(INFO2_TAG));
			transaction.commit();
			//transaction.add(R.id.infoFrame,setInfo1);
			Log.i("fragHelper", "switched to info1");
			break;
			/*

			transaction.commit();
			Log.i("fragHelper","switch changes commited");*/
		}
	}

	public void resetFragments() {
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		if(fragmentManager.findFragmentByTag(INFO2_TAG)!=null){
			transaction.remove(fragmentManager.findFragmentByTag(INFO2_TAG));
		}else if(fragmentManager.findFragmentByTag(INFO1_TAG)!= null){
			transaction.remove(fragmentManager.findFragmentByTag(INFO1_TAG));
		}
		view.setFragmentsAdded(false);
		transaction.commit();
	}
}
