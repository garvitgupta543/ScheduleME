package com.example.application;

import java.util.Calendar;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class backgroundservice extends Service {

	boolean a;
	public Handler handler = new Handler();
	 NotificationManager mManager;
	    static int k = 0;
	    int x ;
	    String[] stringArray;
	    public static final String file = "OutputFile";
		SharedPreferences prefs;
	  
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	 @Override
	    public void onCreate() 
	    {
	       // TODO Auto-generated method stub  
	       super.onCreate();
	       
	      
	    }
	@Override
	public void onStart(Intent intent, int startId){
		a = true;
		super.onStart(intent, startId);
		stringArray = intent.getStringArrayExtra("Key");
		//Toast.makeText(getApplicationContext(), "start", Toast.LENGTH_SHORT).show();
		
		prefs = getSharedPreferences(file, 0);
		
		boolean start = prefs.getBoolean("start", true);
		
		if(start){
			//Toast.makeText(getApplicationContext(), "if", Toast.LENGTH_SHORT).show();
		
		
		Log.e("lll", "kkkkkk");
		
		prefs = getSharedPreferences(file, 0);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putInt("array_size", stringArray.length);
		
		for(int i =0;i<stringArray.length;i++)
		{
			editor.putString("array_" + i, stringArray[i]);
		}
		
		editor.putBoolean("start", false);
		editor.commit();
		
		}
		
		
		prefs = getSharedPreferences(file, 0);
		
		int size = prefs.getInt("array_size", 0);
		final String[] array = new String[size];
		for(int i=0; i<size; i++)
		{	array[i] =   prefs.getString("array_" + i, null);
		}
		//Toast.makeText(getApplicationContext(), "shared prefs" + array[10], Toast.LENGTH_SHORT).show();
	//	Toast.makeText(getApplicationContext(), "Service Started", Toast.LENGTH_SHORT).show();
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(a){
					
			            
			           // handler.sendEmptyMessage(0);
					try{
					
			            Log.e("lll", "IIIIIII");
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
			 				switch(day){
			 				case 2 : x = 1;
			 					break;
			 				case 3 : x = 10;
			 					break;
			 				case 4 : x = 19;
			 					break;
			 				case 5 : x = 28;
			 					break;
			 				case 6 : x = 37;
			 				Log.e("lll", "before");
			 				// Toast.makeText(getApplicationContext(), x , Toast.LENGTH_SHORT).show();
			 				Log.e("lll", "after");
			 					break;	
			 				}
			 				//Toast.makeText(getApplicationContext()," " + x , Toast.LENGTH_SHORT).show();
			 				if((hour == 8)&&(minute == 20)){
			 					createnotification(x,array);
			 				//Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
			 				}
			 				x++;
			 				if((hour == 9)&&(minute == 15)){
			 					createnotification(x,array);}
			 				x++;
			 				if((hour == 10)&&(minute == 30)){
			 					createnotification(x,array);			 				//Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
			 				}
			 				x++;
			 				if((hour == 11)&&(minute == 25)){
			 					createnotification(x,array);}
			 				x++;
			 				if((hour == 12)&&(minute == 20)){
			 					createnotification(x,array);			 				//Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
			 				}
			 				x++;
			 				if((hour == 13)&&(minute == 30)){
			 					createnotification(x,array);			 				}
			 				x++;
			 				if((hour == 14)&&(minute == 30)){
			 					createnotification(x,array);			 				//Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
			 				}
			 				x++;
			 				if((hour == 15)&&(minute == 25)){
			 					createnotification(x,array);			 				}
			 			
			 				//Toast.makeText(getApplicationContext()," " + x , Toast.LENGTH_SHORT).show();
			            	}
			            	
			            } )
			            ;
			          
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
	
	public void createnotification(int i, String[] array){
	   	 mManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
	 	   Intent intent1 = new Intent(this,HomeScreen.class);
	 	
	 	   Notification notification = new Notification(R.drawable.ic_launcher,stringArray[i], System.currentTimeMillis());
	 	
	 	   intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP| Intent.FLAG_ACTIVITY_CLEAR_TOP);

	 	   PendingIntent pendingNotificationIntent = PendingIntent.getActivity( this,0, intent1,PendingIntent.FLAG_UPDATE_CURRENT);
	        notification.flags |= Notification.FLAG_AUTO_CANCEL;
	        notification.setLatestEventInfo(this.getApplicationContext(), "Your Class", array[i], pendingNotificationIntent);

	        mManager.notify(1, notification);
	       
	        Handler h = new Handler();
	        long delayInMilliseconds = 1200000;
	        h.postDelayed(new Runnable() {

	            public void run() {
	                mManager.cancel(1);
	            }}, delayInMilliseconds); 
	   }
	
}
