package com.mhseteditor;


import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.mhseteditor.bbdd.DBManager;
import com.mhseteditor.bbdd.DataBaseHelper;

public class VSplash extends Activity {
	
	public final int SPLASH_DISPLAY_LENGTH = 3000;
	public final Activity vista = this;

	private Intent intent;
	private DBManager dbManager;
	private DataBaseHelper dbHelper;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        
        Handler handler = new Handler();
        handler.postDelayed(getRunnableStartApp(), SPLASH_DISPLAY_LENGTH);
    }
	
	/**
	 * Method that returns a thread that launch the ---- activity
	 * @return runnable
	 */
    
    private Runnable getRunnableStartApp() {
		Runnable runnable = new Runnable(){

			public void run() {
				loadDataBase();
				dbManager = DBManager.getInstance(dbHelper);
				dbManager.loadResources();
				intent = new Intent(VSplash.this,VMenu.class);
				startActivity(intent);
			}
		};
		return runnable;
    }
    private void loadDataBase(){

    	dbHelper = new DataBaseHelper(this);
   	 
        try {
        	dbHelper.createDataBase();
 
        } catch (IOException ioe) {
 
        	throw new Error("Unable to create database");
 
        }
    }
}
