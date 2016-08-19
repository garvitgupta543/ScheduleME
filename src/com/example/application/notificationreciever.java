package com.example.application;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class notificationreciever extends Activity {

	SharedPreferences savedata;
	public static final String filename = "StoreData";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		savedata = getSharedPreferences(filename, 0);
		
		int size1 = savedata.getInt("array_size", 0);
		String[] array1 = new String[size1-1];
		for(int i=1; i<size1; i++)
		{	array1[i-1] =  savedata.getString("array_" + i, null);
		}
		Intent intent = new Intent(this, backgroundservice.class);
    	intent.putExtra("Key",array1);
    	startService(intent);
    	finish();
	
	}
	}
	
