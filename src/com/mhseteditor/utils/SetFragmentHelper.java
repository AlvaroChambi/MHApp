package com.mhseteditor.utils;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import com.mhseteditor.R;
import com.mhseteditor.VSetManager;
import com.mhseteditor.fragments.SetInfo1;
import com.mhseteditor.fragments.SetInfo2;

/**
 * Class that handles all the interaction between the holder view and the fragments.
 * 
 * @author Leid
 *
 */

public class SetFragmentHelper {
	
	private static final String INFO1_TAG = "tag1";
	private static final String INFO2_TAG = "tag2";
	
	private VSetManager view;
	private SetInfo1 setInfo1;
	private SetInfo2 setInfo2;
	private FragmentManager fragmentManager;
	
	public SetFragmentHelper(VSetManager view){
		this.view = view;
		setInfo1 = new SetInfo1();
		setInfo2 = new SetInfo2();
		fragmentManager = view.getSupportFragmentManager();
		
	}
	
	/**
	 * Initializes the fragment view and attaches it to the main view.
	 * Checks which has to be the active info panel and
	 * adds the respective fragment.
	 */

	public void addFragment() {
		
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		
		int activeInfoPanel = view.getActivePanel();
		
		switch(activeInfoPanel){
		case VSetManager.INFO1:
			transaction.add(R.id.infoFrame,setInfo1,INFO1_TAG);
			transaction.commit();
			view.setFragmentsAdded(true);
			break;
		case VSetManager.INFO2:
			transaction.add(R.id.infoFrame,setInfo2,INFO2_TAG);
			transaction.commit();
			view.setFragmentsAdded(true);
			break;
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
	 * Switch between info panel fragments 
	 */
	
	public void switchFragment(){
		
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		
		switch(view.getActivePanel()){
		
		case VSetManager.INFO1:
			
			transaction.replace(R.id.infoFrame, setInfo2,INFO2_TAG);
			transaction.commit();
			
			break;
		case VSetManager.INFO2:
			
			transaction.replace(R.id.infoFrame, setInfo1, INFO1_TAG);
			transaction.commit();
			
			break;
		}
	}
	
	/**
	 * Remove the fragments attached to the main view
	 */

	public void resetFragments() {
		
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		
		if(fragmentManager.findFragmentByTag(INFO2_TAG)!=null){
			
			transaction.remove(fragmentManager.findFragmentByTag(INFO2_TAG));
			
		}else if(fragmentManager.findFragmentByTag(INFO1_TAG)!= null){
			
			transaction.remove(fragmentManager.findFragmentByTag(INFO1_TAG));
		}
		transaction.commit();
		view.setFragmentsAdded(false); 
	}
}
