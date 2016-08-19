package com.example.application;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Gravity;
import android.view.Menu;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;

import android.widget.TextView;

public class SQLView extends Activity {
	//TableLayout t1;
	//TableRow[] tr = new TableRow[5];
	TextView[] tv = new TextView[45];
	
	public static final String filename = "SQLData";
	SharedPreferences sqldata;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.table);
		
		Intent Intent = getIntent();
		String[] stringArray = Intent.getStringArrayExtra("Key");
		int k=0;	
		
		/* sqldata = getSharedPreferences(filename, 0);
		SharedPreferences.Editor editor = sqldata.edit();
		editor.putInt("array_size", stringArray.length);
		for(int i =0;i<stringArray.length;i++)
		{
			editor.putString("array_" + i, stringArray[i]);
		}
		editor.commit();
		
		
		
		int size = sqldata.getInt("array_size", 0);
		String[] array = new String[size];
		for(int i=0; i<size; i++)
		{	array[i] =   sqldata.getString("array_" + i, null);
		}
		*/
		//t1 = (TableLayout) findViewById(R.id.tablelayout);
		
		/* tr[0] = (TableRow) findViewById(R.id.table_row0);
		tr[1] = (TableRow) findViewById(R.id.table_row1);
		tr[2] = (TableRow) findViewById(R.id.table_row2);
		tr[3] = (TableRow) findViewById(R.id.table_row3);
		tr[4] = (TableRow) findViewById(R.id.table_row4); */
		
	    tv[0] = (TextView) findViewById(R.id.text_View0);
	    tv[1] = (TextView) findViewById(R.id.text_View1);
	    tv[2] = (TextView) findViewById(R.id.text_View2);
	    tv[3] = (TextView) findViewById(R.id.text_View3);
	    tv[4] = (TextView) findViewById(R.id.text_View4);
	    tv[5] = (TextView) findViewById(R.id.text_View5);
	    tv[6] = (TextView) findViewById(R.id.text_View6);
	    tv[7] = (TextView) findViewById(R.id.text_View7);
	    tv[8] = (TextView) findViewById(R.id.text_View8);
	    tv[9] = (TextView) findViewById(R.id.text_View9);
	    tv[10] = (TextView) findViewById(R.id.text_View10);
	    tv[11] = (TextView) findViewById(R.id.text_View11);
	    tv[12] = (TextView) findViewById(R.id.text_View12);
	    tv[13] = (TextView) findViewById(R.id.text_View13);
	    tv[14] = (TextView) findViewById(R.id.text_View14);
	    tv[15] = (TextView) findViewById(R.id.text_View15);
	    tv[16] = (TextView) findViewById(R.id.text_View16);
	    tv[17] = (TextView) findViewById(R.id.text_View17);
	    tv[18] = (TextView) findViewById(R.id.text_View18);
	    tv[19] = (TextView) findViewById(R.id.text_View19);
	    tv[20] = (TextView) findViewById(R.id.text_View20);
	    tv[21] = (TextView) findViewById(R.id.text_View21);
	    tv[22] = (TextView) findViewById(R.id.text_View22);
	    tv[23] = (TextView) findViewById(R.id.text_View23);
	    tv[24] = (TextView) findViewById(R.id.text_View24);
	    tv[25] = (TextView) findViewById(R.id.text_View25);
	    tv[26] = (TextView) findViewById(R.id.text_View26);
	    tv[27] = (TextView) findViewById(R.id.text_View27);
	    tv[28] = (TextView) findViewById(R.id.text_View28);
	    tv[29] = (TextView) findViewById(R.id.text_View29);
	    tv[30] = (TextView) findViewById(R.id.text_View30);
	    tv[31] = (TextView) findViewById(R.id.text_View31);
	    tv[32] = (TextView) findViewById(R.id.text_View32);
	    tv[33] = (TextView) findViewById(R.id.text_View33);
	    tv[34] = (TextView) findViewById(R.id.text_View34);
	    tv[35] = (TextView) findViewById(R.id.text_View35);
	    tv[36] = (TextView) findViewById(R.id.text_View36);
	    tv[37] = (TextView) findViewById(R.id.text_View37);
	    tv[38] = (TextView) findViewById(R.id.text_View38);
	    tv[39] = (TextView) findViewById(R.id.text_View39);
	    tv[40] = (TextView) findViewById(R.id.text_View40);
	    tv[41] = (TextView) findViewById(R.id.text_View41);
	    tv[42] = (TextView) findViewById(R.id.text_View42);
	    tv[43] = (TextView) findViewById(R.id.text_View43);
	    tv[44] = (TextView) findViewById(R.id.text_View44);
	    
	    
	
		
	/*	TableLayout.LayoutParams tableRowParams= new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.MATCH_PARENT);
		tableRowParams.setMargins(0, 10, 0, 0);
		
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
	    params.setMargins(4, 4, 4, 4);
		params.width=79; */
		
		for(int i = 0 ; i<45;i++){
		//TableRow tr = new TableRow(this);
		//		tr.setLayoutParams(tableRowParams);
		
		//for(int j=0;j<9;j++){
			//TextView value = new TextView(this);
			
			//value.setText(stringArray[k]);
		
			tv[i].setText(stringArray[k]);
		
            k++;
            
            //tr.addView(value,params);
		//}
		
		//t1.addView(tr);
		}		
	}


}
