package com.example.application;

import java.util.Calendar;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class silentservice extends Service {

	public Handler handler = new Handler();
	boolean a;
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onStart(Intent intent, int startId){
		a = true;
		super.onStart(intent, startId);
		
		Log.e("sss", "servicesilent");
		
		//Toast.makeText(getApplicationContext(), "Service Started", Toast.LENGTH_SHORT).show();
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(!a) return;
				while(a){    
			           // handler.sendEmptyMessage(0);
					try{
					
			            Log.e("lll", "silent");
			            Calendar c = Calendar.getInstance();
						final int hour = c.get(Calendar.HOUR_OF_DAY);
		 				final int minute = c.get(Calendar.MINUTE);
		 				final int day = c.get(Calendar.DAY_OF_WEEK);
		 				final int dayofmonth = c.get(Calendar.DAY_OF_MONTH);
		 				final int month = c.get(Calendar.MONTH);
		 				if( (day == 1) || (day == 7) ||( month==9 && dayofmonth==16) ){
		 				   Thread.sleep(60000);
		 					continue;
		 				}
			            handler.post(new Runnable(){
			            	
			            	@Override
			            	public void run(){
			 				//Toast.makeText(getApplicationContext(), ""+hour +""+ minute, Toast.LENGTH_SHORT).show();			 				
			 				
			 			if( hour==8 && minute >=30 ){
			 				AudioManager audio = (AudioManager)getSystemService(AUDIO_SERVICE);
			 				audio.setRingerMode(AudioManager.RINGER_MODE_SILENT);
			 			}
			 			else if(hour==16 && minute==30){
			 				AudioManager audio = (AudioManager)getSystemService(AUDIO_SERVICE);
			 				audio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
			 			}
			 			else if(hour>8 && hour<16){
			 				AudioManager audio = (AudioManager)getSystemService(AUDIO_SERVICE);
			 				audio.setRingerMode(AudioManager.RINGER_MODE_SILENT);
			 			}
			 			else if(hour==16){
			 				if(minute<30){
			 					AudioManager audio = (AudioManager)getSystemService(AUDIO_SERVICE);
				 				audio.setRingerMode(AudioManager.RINGER_MODE_SILENT);
			 				}
			 			}
			            	}
			            	
			            } );
			            Thread.sleep(60000);
					}
			            catch (Exception e) {
		                    // TODO: handle exception
			            }				
		}
			}
																
		}).start();
		
	}
	@Override
	public void onDestroy()
	{
		//Toast.makeText(getApplicationContext(), "Service Destroyed", Toast.LENGTH_SHORT).show();
		a = false;
		super.onDestroy();
	}
	
	
}
