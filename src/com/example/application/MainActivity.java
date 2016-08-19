package com.example.application;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends Activity {

	Spinner spinnerYear,spinnerBranch,spinnerSection;
    public static final String PREFS_NAME = "MyPrefsFile";
    SharedPreferences settings;
    String[] arrayYear, arrayBranch,defaultRegions,arrayFirstsection,arrayCOEsection, arrayMEsection,arrayITsection,arrayIEMsection,arrayEEsection,arrayECEsection,arrayCEsection;
  
    int position1 = 0;
    int position2 = 0;
    int position3 = 0;
    String spositionYear;
    String spositionBranch;
    String spositionSection;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reg_page);
		 spinnerYear = (Spinner) findViewById(R.id.spinner_year);
		 spinnerBranch = (Spinner) findViewById(R.id.spinner_branch);
		 spinnerSection = (Spinner) findViewById(R.id.spinner_section);
		 
		 
			
	//	 arrayYear =  getResources().getStringArray(R.array.Year); 
         arrayBranch = getResources().getStringArray(R.array.Branch);
		 arrayFirstsection = getResources().getStringArray(R.array.Firstsection);
         arrayCOEsection = getResources().getStringArray(R.array.COE);
         arrayITsection = getResources().getStringArray(R.array.IT);
         arrayIEMsection = getResources().getStringArray(R.array.IEM);
         arrayMEsection = getResources().getStringArray(R.array.ME);
         arrayEEsection = getResources().getStringArray(R.array.EE);
         arrayECEsection = getResources().getStringArray(R.array.ECE);
         arrayCEsection = getResources().getStringArray(R.array.CE);
         
         defaultRegions = getResources().getStringArray(R.array.Default);
         final ArrayAdapter<String> defaultAdapter = new ArrayAdapter<String>(this,
                 android.R.layout.simple_spinner_item, defaultRegions);
        // spinnerSection.setAdapter(defaultAdapter);
         
         final ArrayAdapter<String> adapterbranch = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayBranch);
         
        
         final ArrayAdapter<String> adapterFirstsection = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayFirstsection);
         final ArrayAdapter<String> adapterCOEsection = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayCOEsection);
         final ArrayAdapter<String> adapterITsection = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayITsection);
         final ArrayAdapter<String> adapterIEMsection = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayIEMsection);
         final ArrayAdapter<String> adapterMEsection = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayMEsection);
         final ArrayAdapter<String> adapterEEsection = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayEEsection);
         final ArrayAdapter<String> adapterECEsection = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayECEsection);
         final ArrayAdapter<String> adapterCEsection = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayCEsection);
         
         spinnerYear.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					position1 = (int) spinnerYear.getItemIdAtPosition(arg2);
					 spositionYear = String.valueOf(position1);
					 switch(position1){
					 case 0 : spinnerBranch.setAdapter(adapterbranch);
					 		  spositionBranch = "0";
							  spinnerSection.setAdapter(adapterFirstsection);
					 		  adapterFirstsection.notifyDataSetChanged();
					 		  break;
					 		  
					 default : spinnerBranch.setAdapter(adapterbranch); 
					 
						 spinnerBranch.setOnItemSelectedListener(new OnItemSelectedListener()
						
					 		{
									public void onItemSelected(AdapterView<?> arg0, View arg1,
									int arg2, long arg3) {
									position2 = (int) spinnerBranch.getItemIdAtPosition(arg2);
									spositionBranch = String.valueOf(position2);
									
									if(position1==0){
										spinnerSection.setAdapter(adapterFirstsection);
								 		  adapterFirstsection.notifyDataSetChanged();
									}
									else{
									switch(position2)
									{
									case 0 : spinnerSection.setAdapter(adapterCOEsection);
										     adapterCOEsection.notifyDataSetChanged();
										     break;
									case 1 : spinnerSection.setAdapter(adapterITsection);
											 adapterITsection.notifyDataSetChanged();
											 break;
									case 2 : spinnerSection.setAdapter(adapterIEMsection);
									 		 adapterIEMsection.notifyDataSetChanged();
									 		 break;
									
									case 3 : spinnerSection.setAdapter(adapterMEsection);
									 		 adapterMEsection.notifyDataSetChanged();
									 		 break;
										
									case 4 : spinnerSection.setAdapter(adapterEEsection);
									 		 adapterEEsection.notifyDataSetChanged();
									 		 break;
										
									case 5 : spinnerSection.setAdapter(adapterECEsection);
									 		 adapterECEsection.notifyDataSetChanged();
									 		 break;
										
									case 6 : spinnerSection.setAdapter(adapterCEsection);
									 		 adapterCEsection.notifyDataSetChanged();
									 		 break;	
									default : spinnerSection.setAdapter(defaultAdapter) ;
											  defaultAdapter.notifyDataSetChanged();	
											  break;
									}
									}					}						

							@Override
							public void onNothingSelected(AdapterView<?> arg0) {
								// TODO Auto-generated method stub
								
																				}
					 		}
						 
								
								);
					 break;
					 
					 }
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
			});
         
         			spinnerSection.setOnItemSelectedListener(new OnItemSelectedListener(){
         			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
         			long arg3) {
         			position3 = (int) spinnerSection.getItemIdAtPosition(arg2);
         			spositionSection = String.valueOf(position3);
           	  
         						}
         			
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
           		              		  
             });
         
         			settings = getSharedPreferences(PREFS_NAME, 0);
         	        boolean hasLoggedIn = settings.getBoolean("hasLoggedIn", false);

         	        if(hasLoggedIn)
         	        {
         	        	Intent i = new Intent(this, HomeScreen.class);
         	        	startActivity(i);//Go directly to main activity
         	        	finish();
         	        }
	} // end of oncreate

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void GetDetails(View view){
		
		TestAdapter mDbHelper = new TestAdapter(this);         
    	mDbHelper.createDatabase();
    	mDbHelper.open();
    	
		EditText name = (EditText) findViewById(R.id.editText_name);
    	String getname = name.getText().toString();
    	
    	SharedPreferences.Editor editor = settings.edit();
    	//Set "hasLoggedIn" to true
    	editor.putBoolean("hasLoggedIn", true);
    	// Commit the edits!
    	editor.commit();

    	String[] array = new String[3];
    	//array[0]= getname;
    	array[0]=spositionYear;
    	array[1]=spositionBranch;
    	array[2]=spositionSection;
    	
    	Log.e("main", array[0] + " " +array[1] + " " + array[2] );
    	
    	Cursor c = mDbHelper.getTestData(array);
    	String[] values = new String[46];
    	values[0]= getname;
    	int k = 1;
    	for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
        	for(int j=0;j<9;j++){
        	/*	result = result + c.getString(0) + "\t" + c.getString(1) + "\t" + c.getString(2)+ "\t" + c.getString(3)+ "\t" 
        	+ c.getString(4)+ "\t" + c.getString(5) +  "\n" ;	*/
        	values[k]= c.getString(j);
        		k++;
        	}
        	}
    	
    	Intent i = new Intent(this, HomeScreen.class);
    	i.putExtra("Key", values);
    	i.putExtra("array", array);
    	startActivity(i);
    	finish();
    	
    	
	}
	
	
	
}
