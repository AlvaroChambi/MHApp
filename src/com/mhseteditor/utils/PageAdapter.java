package com.mhseteditor.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.mhseteditor.VSetManager;
import com.mhseteditor.fragments.SetPieces;

public class PageAdapter extends FragmentStatePagerAdapter {
	
	private SetPieces[] pages;

	public PageAdapter(FragmentManager fm) {
		super(fm);
		pages = new SetPieces[VSetManager.NUM_PAGES];
	}

	@Override
	public Fragment getItem(int position) {
		if(pages[position]==null){
			pages[position] = SetPieces.create(position);
		}
		return pages[position];
	}

	@Override
	public int getCount() {
		return VSetManager.NUM_PAGES;
	}

}
