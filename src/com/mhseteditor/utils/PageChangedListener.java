package com.mhseteditor.utils;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;

import com.mhseteditor.VSetManager;
import com.mhseteditor.models.MGalery;

public class PageChangedListener implements OnPageChangeListener{
	
	private VSetManager view;
	
	public PageChangedListener (VSetManager view){
		this.view = view;
	}

	@Override
	public void onPageScrollStateChanged(int position) {
		
	}

	@Override
	public void onPageScrolled(int position, float arg1, int arg2) {		
	}

	@Override
	public void onPageSelected(int position) {
		
		view.setSetPosition(position);
		view.setSet(MGalery.getInstance().getSet(position));
		Log.i("lifecycle","fragments actualizandose...");
		view.fragmentHelper().updateView();
	}

}
