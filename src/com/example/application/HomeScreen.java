package com.example.application;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.TextView;
import android.widget.ToggleButton;


public class HomeScreen extends Activity {

	
	public static final String filename = "StoreData";
	public static final String PREFS_NAME = "MyPrefsFile";
	public static final String file = "OutputFile";
	SharedPreferences savedata,prefs;
	TextView tv;
	ToggleButton toggle , toggle1;
	
	/*public static SharedPreferences getPrefs(Context context) {


	    return context.getSharedPreferences(filename, context.MODE_PRIVATE);

	}
	
	public static boolean getMyStringPref(Context context) {

	    return getPrefs(context).getBoolean("savedstate", false);
	}*/
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homescreen);
		toggle = (ToggleButton) findViewById(R.id.toggleButton1);
		toggle1 = (ToggleButton) findViewById(R.id.toggleButton2);
		
		savedata = getSharedPreferences(filename, 0);
		boolean savedstate = savedata.getBoolean("savedstate", false);
		toggle.setChecked(savedstate);
		
		boolean silentstate = savedata.getBoolean("silentstate", false);
		toggle1.setChecked(silentstate);
		 
		savedata = getSharedPreferences(filename, 0);
		
		boolean hasnotsaved = savedata.getBoolean("hasnotsaved", true);
		if(hasnotsaved)
		{
			Intent Intent = getIntent();
			String[] stringArray = Intent.getStringArrayExtra("Key");
			String[] array2 = Intent.getStringArrayExtra("array");
			
			Log.e("homescreen", array2[0] + " " +array2[1] + " " + array2[2] );
			
			SharedPreferences.Editor editor = savedata.edit();
			editor.putInt("array_size", stringArray.length);
			for(int i =0;i<stringArray.length;i++)
			{
				editor.putString("array_" + i, stringArray[i]);
			}
			
			editor.putInt("array2_size",array2.length);
			for(int i = 0 ; i<array2.length ; i++)
			{
				editor.putString("array2_" + i, array2[i]);
			}
			
			editor.putBoolean("hasnotsaved", false);
			editor.commit();	
		}

		savedata = getSharedPreferences(filename, 0);
		
		int size = savedata.getInt("array_size", 0);
		String[] array = new String[size];
		for(int i=0; i<size; i++)
		{	array[i] =   savedata.getString("array_" + i, null);
		}
		
		tv = (TextView) findViewById(R.id.tv);
		tv.setText(array[0]);
		
	}
	
	public void Logout(View view)
	{
		SharedPreferences.Editor editor = savedata.edit();
		editor.putBoolean("hasnotsaved", true);
		editor.commit();
		
		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor1 = settings.edit();
        
    	//Set "hasLoggedIn" to true
    	editor1.putBoolean("hasLoggedIn", false);

    	// Commit the edits!
    	editor1.commit();
    	
    	SharedPreferences.Editor editor2 = savedata.edit();
    	editor2.putBoolean("savedstate", false);
    	editor2.putBoolean("silentstate", false);
    	editor2.commit();
    	
    	Intent intent = new Intent(this, backgroundservice.class);
	  	stopService(intent);
	  	
	  	Intent intent1 = new Intent(this, silentservice.class);
	  	stopService(intent1);
    	
    	Intent i = new Intent(this, MainActivity.class);
    	startActivity(i);
    	finish();
	}
	
	public void ViewTimeTable(View view){
		
		savedata = getSharedPreferences(filename, 0);
		
		int size1 = savedata.getInt("array_size", 0);
		String[] array1 = new String[size1-1];
		for(int i=1; i<size1; i++)
		{	array1[i-1] =  savedata.getString("array_" + i, null);
		}
		
    	Intent intent = new Intent(this, SQLView.class);
		intent.putExtra("Key", array1);
		startActivity(intent);
		
	}
	
	public void Curriculum(View view){
		
		TestAdapter mDbHelper = new TestAdapter(this);         
    	mDbHelper.open();
    	
    	savedata = getSharedPreferences(filename, 0);
		
		int size = savedata.getInt("array2_size", 0);
		String[] array1 = new String[size];
		for(int i=0; i<size; i++)
		{	array1[i] =  savedata.getString("array2_" + i, null);
		}
		Log.e("curriculum", array1[0] + " " +array1[1] + " " + array1[2] );
		Cursor c = mDbHelper.getCurriculumdata(array1);
		String[] values = new String[78];
		
		int k = 0;
    	for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
        	for(int j=0;j<6;j++){
        		
        	values[k]= c.getString(j);
        		k++;
        	}
        	}
    	Intent intent = new Intent(this, Curriculum.class);
		intent.putExtra("Key", values);
		startActivity(intent);
    	
	}
	
	
	public void onToggleClicked(View view) {
		savedata = getSharedPreferences(filename, 0);
		
		int size1 = savedata.getInt("array_size", 0);
		String[] array1 = new String[size1-1];
		for(int i=1; i<size1; i++)
		{	array1[i-1] =  savedata.getString("array_" + i, null);
		}
	    // Is the toggle on?
	    boolean on = ((ToggleButton) view).isChecked();
	    
	    if (on) {
	    	//((ToggleButton) view).setChecked(true);
	    	SharedPreferences.Editor editor = savedata.edit();
	    	editor.putBoolean("savedstate", true);
	    	editor.commit();
	    	
	    	//Flag(1);
	    	
	        Intent intent = new Intent(this, backgroundservice.class);
	    	intent.putExtra("Key",array1);
	    	startService(intent);
	    	
	        // Enable vibrate
	    } else {
	   // 	((ToggleButton) view).setChecked(false);
	    	SharedPreferences.Editor editor = savedata.edit();
	    	editor.putBoolean("savedstate", false);
	    	editor.commit();
	    	
	    	//Flag(0);
	    	
	    	Intent intent = new Intent(this, backgroundservice.class);
		  	 stopService(intent);
	        // Disable vibrate
	    }

	}
	
	public void onsilentToggleClicked(View view) {
		boolean on = ((ToggleButton) view).isChecked();
	    
	    if (on) {
	    	SharedPreferences.Editor editor = savedata.edit();
	    	editor.putBoolean("silentstate", true);
	    	editor.commit();
	    	prefs = getSharedPreferences(file, 0);
	    	SharedPreferences.Editor editor1 = prefs.edit();
	    	editor1.putBoolean("start", true);
	    	editor1.commit();
	    	//silentFlag(1);
	    	
	    	Intent intent = new Intent(this, silentservice.class);
	    	startService(intent);
	    	//silentFlag(1);
	    }
	    else {
	    	SharedPreferences.Editor editor = savedata.edit();
	    	editor.putBoolean("silentstate", false);
	    	editor.commit();
	    	
	    
	    	
	    	//silentFlag(0);
	    	
	    	Intent intent = new Intent(this, silentservice.class);
	    	stopService(intent);
	    }
	}
	/*public int Flag(int i){
		int flag;
		if(i==1 || i==0)
		{flag = i; 
		}
		
		return flag;
		}
	public int silentFlag(int i){
		int flag = i;
		return flag;
	}*/
}
