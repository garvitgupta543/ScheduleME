package com.example.application;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Curriculum extends Activity {
	TextView[] tv = new TextView[78];
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.curriculum);
		
		Intent Intent = getIntent();
		String[] stringArray = Intent.getStringArrayExtra("Key");
		
		tv[0] = (TextView) findViewById (R.id.textView7);
		tv[1] = (TextView) findViewById (R.id.textView8);
		tv[2] = (TextView) findViewById (R.id.textView9);
		tv[3] = (TextView) findViewById (R.id.textView10);
		tv[4] = (TextView) findViewById (R.id.textView11);
		tv[5] = (TextView) findViewById (R.id.textView12);
		tv[6] = (TextView) findViewById (R.id.textView13);
		tv[7] = (TextView) findViewById (R.id.textView14);
		tv[8] = (TextView) findViewById (R.id.textView15);
		tv[9] = (TextView) findViewById (R.id.textView16);
		tv[10] = (TextView) findViewById (R.id.textView17);
		tv[11] = (TextView) findViewById (R.id.textView18);
		tv[12] = (TextView) findViewById (R.id.textView19);
		tv[13] = (TextView) findViewById (R.id.textView20);
		tv[14] = (TextView) findViewById (R.id.textView21);
		tv[15] = (TextView) findViewById (R.id.textView22);
		tv[16] = (TextView) findViewById (R.id.textView23);
		tv[17] = (TextView) findViewById (R.id.textView24);
		tv[18] = (TextView) findViewById (R.id.textView25);
		tv[19] = (TextView) findViewById (R.id.textView26);
		tv[20] = (TextView) findViewById (R.id.textView27);
		tv[21] = (TextView) findViewById (R.id.textView28);
		tv[22] = (TextView) findViewById (R.id.textView29);
		tv[23] = (TextView) findViewById (R.id.textView30);
		tv[24] = (TextView) findViewById (R.id.textView31);
		tv[25] = (TextView) findViewById (R.id.textView32);
		tv[26] = (TextView) findViewById (R.id.textView33);
		tv[27] = (TextView) findViewById (R.id.textView34);
		tv[28] = (TextView) findViewById (R.id.textView35);
		tv[29] = (TextView) findViewById (R.id.textView36);
		tv[30] = (TextView) findViewById (R.id.textView37);
		tv[31] = (TextView) findViewById (R.id.textView38);
		tv[32] = (TextView) findViewById (R.id.textView39);
		tv[33] = (TextView) findViewById (R.id.textView40);
		tv[34] = (TextView) findViewById (R.id.textView41);
		tv[35] = (TextView) findViewById (R.id.textView42);
		tv[36] = (TextView) findViewById (R.id.textView43);
		tv[37] = (TextView) findViewById (R.id.textView44);
		tv[38] = (TextView) findViewById (R.id.textView45);
		tv[39] = (TextView) findViewById (R.id.textView46);
		tv[40] = (TextView) findViewById (R.id.textView47);
		tv[41] = (TextView) findViewById (R.id.textView48);
		tv[42] = (TextView) findViewById (R.id.textView49);
		tv[43] = (TextView) findViewById (R.id.textView50);
		tv[44] = (TextView) findViewById (R.id.textView51);
		tv[45] = (TextView) findViewById (R.id.textView52);
		tv[46] = (TextView) findViewById (R.id.textView53);
		tv[47] = (TextView) findViewById (R.id.textView54);
		tv[48] = (TextView) findViewById (R.id.textView55);
		tv[49] = (TextView) findViewById (R.id.textView56);
		tv[50] = (TextView) findViewById (R.id.textView57);
		tv[51] = (TextView) findViewById (R.id.textView58);
		tv[52] = (TextView) findViewById (R.id.textView59);
		tv[53] = (TextView) findViewById (R.id.textView60);
		tv[54] = (TextView) findViewById (R.id.textView61);
		tv[55] = (TextView) findViewById (R.id.textView62);
		tv[56] = (TextView) findViewById (R.id.textView63);
		tv[57] = (TextView) findViewById (R.id.textView64);
		tv[58] = (TextView) findViewById (R.id.textView65);
		tv[59] = (TextView) findViewById (R.id.textView66);
		tv[60] = (TextView) findViewById (R.id.textView67);
		tv[61] = (TextView) findViewById (R.id.textView68);
		tv[62] = (TextView) findViewById (R.id.textView69);
		tv[63] = (TextView) findViewById (R.id.textView70);
		tv[64] = (TextView) findViewById (R.id.textView71);
		tv[65] = (TextView) findViewById (R.id.textView72);
		tv[66] = (TextView) findViewById (R.id.textView73);
		tv[67] = (TextView) findViewById (R.id.textView74);
		tv[68] = (TextView) findViewById (R.id.textView75);
		tv[69] = (TextView) findViewById (R.id.textView76);
		tv[70] = (TextView) findViewById (R.id.textView77);
		tv[71] = (TextView) findViewById (R.id.textView78);
		tv[72] = (TextView) findViewById (R.id.textView79);
		tv[73] = (TextView) findViewById (R.id.textView80);
		tv[74] = (TextView) findViewById (R.id.textView81);
		tv[75] = (TextView) findViewById (R.id.textView82);
		tv[76] = (TextView) findViewById (R.id.textView83);
		tv[77] = (TextView) findViewById (R.id.textView84);
		
		for(int i = 0 ; i<stringArray.length;i++)
		{
			tv[i].setText(stringArray[i]);
		}
		
		
		
	}
	
}
