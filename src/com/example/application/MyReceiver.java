package com.example.application;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class MyReceiver extends BroadcastReceiver
{
	 
	public static final String filename = "StoreData";
	
	@Override
	 public void onReceive(Context context, Intent intent)
	{
	 
		SharedPreferences prefs = context.getSharedPreferences(filename, 0);
		boolean a = prefs.getBoolean("savedstate", false);
		boolean b = prefs.getBoolean("silentstate", false);
		if(a){
		Intent activity1 = new Intent(context, notificationreciever.class);
		activity1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	   context.startActivity(activity1);
		}
		if(b){
			Intent service2 = new Intent(context, silentservice.class);
			   context.startService(service2);
		}
	 }

}
