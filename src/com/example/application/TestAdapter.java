package com.example.application;

import java.io.IOException;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


public class TestAdapter {

	 protected static final String TAG = "DataAdapter"; 
	 
	    private final Context mContext; 
	    private SQLiteDatabase mDb; 
	    private DataBaseHelper mDbHelper; 
	 
	    public TestAdapter(Context context)  
	    { 
	        this.mContext = context; 
	        mDbHelper = new DataBaseHelper(mContext); 
	    } 
	 
	    public TestAdapter createDatabase() throws SQLException  
	    { 
	        try  
	        { 
	            mDbHelper.createDataBase(); 
	        }  
	        catch (IOException mIOException)  
	        { 
	            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase"); 
	            throw new Error("UnableToCreateDatabase"); 
	        } 
	        return this; 
	    } 
	 
	    public TestAdapter open() throws SQLException  
	    { 
	        try  
	        { 
	            mDbHelper.openDataBase(); 
	            mDbHelper.close(); 
	            mDb = mDbHelper.getReadableDatabase(); 
	        }  
	        catch (SQLException mSQLException)  
	        { 
	            Log.e(TAG, "open >>"+ mSQLException.toString()); 
	            throw mSQLException; 
	        } 
	        return this; 
	    } 
	 
	    public void close()  
	    { 
	        mDbHelper.close(); 
	    } 
	 
	     public Cursor getTestData(String[] array) 
	     {
	    	 int[] intarray = new int[array.length];
	    	 for(int i = 0 ; i<array.length;i++){
	    		 intarray[i] = Integer.parseInt(array[i]);
	    	 }
	    	 Log.e("check", " "+intarray[0] +" " + intarray[1] + " "+ intarray[2]);
	    	String sql="";
	    	 try 
	         { 
	        	 
	        /*	if(array.equals("IT1")){
	        		sql ="select Time, Monday, Tuesday, Wednesday, Thrusday, Friday from IT12"; 
	        	}
	        	else if(array.equals("IT2")){
	        		sql ="select Time, Monday, Tuesday, Wednesday, Thrusday, Friday from IT22";
	        	}  */
	    		 
	    		switch(intarray[0]){
	    			case 0 : switch(intarray[2]){
	    								case 0 : sql = "select * from A1";
	    									     break;
	    								case 1 : sql = "select * from A2";
	    										 break;
	    								case 2 : sql = "select * from B1";
	    										break;
	    								case 3 : sql = "select * from B2";
									     		 break;
	    								case 4 : sql = "select * from C1";
									     		 break;
	    								case 5 : sql = "select * from C2";
	    										 break;
	    								case 6 : sql = "select * from D1";
	    										 break;
	    								case 7 : sql = "select * from D2";
									     		break;
	    								case 8 : sql = "select * from E1";
									     		 break;
	    								case 9 : sql = "select * from E2";
									     		 break;
	    								case 10 : sql = "select * from F1";
									     		  break;
	    								case 11 : sql = "select * from F2";
									     		  break;
	    								case 12 : sql = "select * from G1";
									     		  break;
	    								case 13 : sql = "select * from G2";
									     		  break;
	    								case 14 : sql = "select * from H1";
	    										  break;
	    								case 15 : sql = "select * from H2";
	    										  break;
	    								case 16 : sql = "select * from I1";
	    										  break;
	    								case 17 : sql = "select * from I2";
									     		  break;
	    								case 18 : sql = "select * from J1";
									     		  break;
	    								case 19 : sql = "select * from J2";
									     		  break;
	    								case 20 : sql = "select * from K1";
									     		  break;	
	    								case 21 : sql = "select * from K2";
									     		  break;
	    								case 22 : sql = "select * from L1";
									     		  break;
	    								case 23 : sql = "select * from L2";
	    										  break;
	    										}
	    			
	    			break; //end of case 0
	    			case 1 : switch(intarray[1]){
	    								case 0: switch(intarray[2]){
	    												case 0 : sql = "select * from COE12";
	    												break;
	    												case 1 : sql = "select * from COE22";
	    												break;
	    												case 2 : sql = "select * from COE32";
	    												break;
	    												case 3 : sql = "select * from COE42";
	    												break;
	    												case 4 : sql = "select * from CO52";
	    												break;
	    												case 5 : sql = "select * from COE62";
	    												break;
	    												     		}
	    								break;	
	    								case 1: switch(intarray[2]){
														case 0 : sql = "select * from IT12";
														break;
														case 1 : sql = "select * from IT22";
														break;
														case 2 : sql = "select * from IT32";
														break;
														case 3 : sql = "select * from IT42";
														break;
														case 4 : sql = "select * from IT52";
														break;
														case 5 : sql = "select * from IT62";
														break;
										     		}
	    								break;	
	    								case 2: switch(intarray[2]){
														case 0 : sql = "select * from IEM12";
														break;
														case 1 : sql = "select * from IEM22";
														break;
														case 2 : sql = "select * from IEM32";
														break;
														case 3 : sql = "select * from IEM42";																				
														break;
	    															}
	    								break;
	    								case 3: switch(intarray[2]){
														case 0 : sql = "select * from M12";
														break;
														case 1 : sql = "select * from M22";
														break;
														case 2 : sql = "select * from M32";
														break;
														case 3 : sql = "select * from M42";
														break;
														case 4 : sql = "select * from M52";
														break;
														case 5 : sql = "select * from M62";
														break;	
														case 6 : sql = "select * from M72";
														break;	
														case 7 : sql = "select * from M82";
														break;
	    															}
	    								break;	
	    								case 4: switch(intarray[2]){
														case 0 : sql = "select * from E12";
														break;
														case 1 : sql = "select * from E22";
														break;
														case 2 : sql = "select * from E32";
														break;
														case 3 : sql = "select * from E42";
														break;
														case 4 : sql = "select * from E52";
														break;
														case 5 : sql = "select * from E62";
														break;	
														case 6 : sql = "select * from E72";
														break;	
														case 7 : sql = "select * from E82";
														break;
													}
	    								break;	
	    								case 5: switch(intarray[2]){
														case 0 : sql = "select * from EC12";
														break;
														case 1 : sql = "select * from EC22";
														break;
														case 2 : sql = "select * from EC32";
														break;
														case 3 : sql = "select * from EC42";
														break;
														case 4 : sql = "select * from EC52";
														break;
														case 5 : sql = "select * from EC62";
														break;	
														case 6 : sql = "select * from EC72";
														break;	
														case 7 : sql = "select * from EC82";
														break;
	    															}
	    								break;	
	    								case 6: switch(intarray[2]){
														case 0 : sql = "select * from C12";
														break;
														case 1 : sql = "select * from C22";
														break;
														case 2 : sql = "select * from C32";
														break;
														case 3 : sql = "select * from C42";
														break;
														case 4 : sql = "select * from C52";
														break;
														case 5 : sql = "select * from C62";
														break;	
														case 6 : sql = "select * from C72";
														break;	
														case 7 : sql = "select * from C82";
														break;
	    									
	    											}
	 	    							break;
	    										}
	    			break;	 // end of case 1
	    			case 2 : 	switch(intarray[1]){
									 case 0: switch(intarray[2]){
														case 0 : sql = "select * from COE13";
														break;
														case 1 : sql = "select * from COE23";
														break;
														case 2 : sql = "select * from COE33";
														break;
														case 3 : sql = "select * from COE43";
														break;
														case 4 : sql = "select * from COE53";
														break;
														case 5 : sql = "select * from COE63";
														break;
									 							}
									 break;	
									 case 1: switch(intarray[2]){
									 					case 0 : sql = "select * from IT13";
									 					break;
									 					case 1 : sql = "select * from IT23";
									 					break;
									 					case 2 : sql = "select * from IT33";
									 					break;
									 					case 3 : sql = "select * from IT43";
									 					break;
									 					case 4 : sql = "select * from IT53";
									 					break;
									 					case 5 : sql = "select * from IT63";
									 					break;
									 							}
									 break;	
									 case 2: switch(intarray[2]){
									 					case 0 : sql = "select * from IEM13";
									 					break;
									 					case 1 : sql = "select * from IEM23";
									 					break;
									 					case 2 : sql = "select * from IEM33";
									 					break;
									 					case 3 : sql = "select * from IEM43";																				
									 					break;
									 							}
									 break;
									 case 3: switch(intarray[2]){
									 					case 0 : sql = "select * from M13";
									 					break;
									 					case 1 : sql = "select * from M23";
									 					break;
									 					case 2 : sql = "select * from M33";
									 					break;
									 					case 3 : sql = "select * from M43";
									 					break;
									 					case 4 : sql = "select * from M53";
									 					break;
									 					case 5 : sql = "select * from M63";
									 					break;	
									 					case 6 : sql = "select * from M73";
									 					break;	
									 					case 7 : sql = "select * from M83";
									 					break;
									 					}
									 break;
									 case 4: switch(intarray[2]){
									 					case 0 : sql = "select * from E13";
									 					break;
									 					case 1 : sql = "select * from E23";
									 					break;
									 					case 2 : sql = "select * from E33";
									 					break;
									 					case 3 : sql = "select * from E43";
									 					break;
									 					case 4 : sql = "select * from E53";
									 					break;
									 					case 5 : sql = "select * from E63";
									 					break;	
									 					case 6 : sql = "select * from E73";
									 					break;	
									 					case 7 : sql = "select * from E83";
									 					break;
									 						}
									 break;
									 case 5: switch(intarray[2]){
									 					case 0 : sql = "select * from EC13";
									 					break;
									 					case 1 : sql = "select * from EC23";
									 					break;
									 					case 2 : sql = "select * from EC33";
									 					break;
									 					case 3 : sql = "select * from EC43";
									 					break;
									 					case 4 : sql = "select * from EC53";
									 					break;
									 					case 5 : sql = "select * from EC63";
									 					break;	
									 					case 6 : sql = "select * from EC73";
									 					break;	
									 					case 7 : sql = "select * from EC83";
									 					break;
									 					}
									 break;
									 case 6: switch(intarray[2]){
									 					case 0 : sql = "select * from C13";
									 					break;
									 					case 1 : sql = "select * from C23";
									 					break;
									 					case 2 : sql = "select * from C33";
									 					break;
									 					case 3 : sql = "select * from C43";
									 					break;
									 					case 4 : sql = "select * from C53";
									 					break;
									 					case 5 : sql = "select * from C63";
									 					break;	
									 					case 6 : sql = "select * from C73";
									 					break;	
									 					case 7 : sql = "select * from C83";
									 					break;
									 					}
									 break;
	    					}
	    			break; //end of case 2
	    				
	    		case 3 :	switch(intarray[1]){
					 				case 0: switch(intarray[2]){
					 									case 0 : sql = "select * from COE14";
					 									break;
					 									case 1 : sql = "select * from COE24";
					 									break;
					 									case 2 : sql = "select * from COE34";
					 									break;
					 									case 3 : sql = "select * from COE44";
					 									break;
					 									case 4 : sql = "select * from COE54";
					 									break;
					 									case 5 : sql = "select * from COE64";
					 									break;
					 										}
					 				break;	
					 				case 1: switch(intarray[2]){
					 									case 0 : sql = "select * from IT14";
					 									break;
					 									case 1 : sql = "select * from IT24";
					 									break;
					 									case 2 : sql = "select * from IT34";
					 									break;
					 									case 3 : sql = "select * from IT44";
					 									break;
					 									case 4 : sql = "select * from IT54";
					 									break;
					 									case 5 : sql = "select * from IT64";
					 									break;
					 											}
					 				break;	
					 				case 2: switch(intarray[2]){
					 									case 0 : sql = "select * from IEM14";
					 									break;
					 									case 1 : sql = "select * from IEM24";
					 									break;
					 									case 2 : sql = "select * from IEM34";
					 									break;
					 									case 3 : sql = "select * from IEM44";																				
					 									break;
					 											}
					 				break;
					 				case 3: switch(intarray[2]){
					 									case 0 : sql = "select * from M14";
					 									break;
					 									case 1 : sql = "select * from M24";
					 									break;
					 									case 2 : sql = "select * from M34";
					 									break;
					 									case 3 : sql = "select * from M44";
					 									break;
					 									case 4 : sql = "select * from M54";
					 									break;
					 									case 5 : sql = "select * from M64";
					 									break;	
					 									case 6 : sql = "select * from M74";
					 									break;	
					 									case 7 : sql = "select * from M84";
					 									break;
					 											}
					 									break;
					 				case 4: switch(intarray[2]){
					 									case 0 : sql = "select * from E14";
					 									break;
					 									case 1 : sql = "select * from E24";
					 									break;
					 									case 2 : sql = "select * from E34";
					 									break;
					 									case 3 : sql = "select * from E44";
					 									break;
					 									case 4 : sql = "select * from E54";
					 									break;
					 									case 5 : sql = "select * from E64";
					 									break;	
					 									case 6 : sql = "select * from E74";
					 									break;	
					 									case 7 : sql = "select * from E84";
					 									break;
					 											}
					 				break;
					 				case 5: switch(intarray[2]){
					 									case 0 : sql = "select * from EC14";
					 									break;
					 									case 1 : sql = "select * from EC24";
					 									break;
					 									case 2 : sql = "select * from EC34";
					 									break;
					 									case 3 : sql = "select * from EC44";
					 									break;
					 									case 4 : sql = "select * from EC54";
					 									break;
					 									case 5 : sql = "select * from EC64";
					 									break;	
					 									case 6 : sql = "select * from EC74";
					 									break;	
					 									case 7 : sql = "select * from EC84";
					 									break;
					 											}
					 				break;
					 				case 6: switch(intarray[2]){
					 									case 0 : sql = "select * from C14";
					 									break;
					 									case 1 : sql = "select * from C24";
					 									break;
					 									case 2 : sql = "select * from C34";
					 									break;
					 									case 3 : sql = "select * from C44";
					 									break;
					 									case 4 : sql = "select * from C54";
					 									break;
					 									case 5 : sql = "select * from C64";
					 									break;	
					 									case 6 : sql = "select * from C74";
					 									break;	
					 									case 7 : sql = "select * from C84";
					 									break;
					 											}
					 								break;
	    													}
	    					break; //end of case 3
	    		
	    				}
	        	
	        	Cursor mCur = mDb.rawQuery(sql, null); 
	             if (mCur!=null) 
	             { 
	                mCur.moveToNext(); 
	             } 
	             return mCur; 
	         } 
	         catch (SQLException mSQLException)  
	         { 
	             Log.e(TAG, "getTestData >>"+ mSQLException.toString()); 
	             throw mSQLException; 
	         } 
	     }
	     
	     public Cursor getCurriculumdata(String[] array){
	    	 
	    	 int[] intarray = new int[array.length];
	    	 for(int i = 0 ; i<array.length;i++){
	    		 intarray[i] = Integer.parseInt(array[i]);
	    	 }
	    	 Log.e("check", " "+intarray[0] +" " + intarray[1] + " "+ intarray[2]);
	    	 String sql="";
	    	 
	    	 switch(intarray[0]){
	    	 		case 0 :switch(intarray[2]){
	    	 						case 0 :
	    	 						case 1 :
	    	 						case 2 :
	    	 						case 3 :
	    	 						case 4 :
	    	 						case 5 :
	    	 						case 6 :
	    	 						case 7 :
	    	 						case 8 :
	    	 						case 9 :
	    	 						case 10 :
	    	 						case 11 : sql = "select * from FIRSTC1";
	    	 						break;
	    	 						case 12 :
	    	 						case 13 :
	    	 						case 14 :
	    	 						case 15 :
	    	 						case 16 :
	    	 						case 17 :
	    	 						case 18 :
	    	 						case 19 :
	    	 						case 20 :
	    	 						case 21 :
	    	 						case 22 :
	    	 						case 23 : sql = "select * from FIRSTC2";
	    	 						break;
	    	 									}
	    	 		break;
	    	 		
	    	 		case 1: switch(intarray[1]){
	    	 						case 0 : sql = "select * from COC3";
	    	 						break;
	    	 						case 1 : sql = "select * from ITC3";
	    	 						break;
	    	 						case 2: sql = "select * from IC3";
	    	 						break;
	    	 						case 3: sql = "select * from MC3";
	    	 						break;	
	    	 						case 4 : sql = "select * from EC3";
	    	 						break;
	    	 						case 5 : sql = "select * from ECC3";
	    	 						break;
	    	 						case 6 : sql = "select * from CC3";
	    	 						break;
	    	 									}
	    	 		break;
	    	 		case 2 : switch(intarray[1]){
									case 0 : sql = "select * from COC5";
									break;
									case 1 : sql = "select * from ITC5";
									break;
									case 2: sql = "select * from IC5";
									break;
									case 3: sql = "select * from MC5";
									break;	
									case 4 : sql = "select * from EC5";
									break;
									case 5 : sql = "select * from ECC5";
									break;
									case 6 : sql = "select * from CC5";
									break;
									}
	    	 		break;
	    	 		case 3 : switch(intarray[1]){
									case 0 : sql = "select * from COC7";
									break;
									case 1 : sql = "select * from ITC7";
									break;
									case 2: sql = "select * from IC7";
									break;
									case 3: sql = "select * from MC7";
									break;	
									case 4 : sql = "select * from EC7";
									break;
									case 5 : sql = "select * from ECC7";
									break;
									case 6 : sql = "select * from CC7";
									break;
									}
	    	 		break;	
	    	 					}
	    	 
	    	 
	    	 
	    	 
			Cursor mCur = mDb.rawQuery(sql, null);
			 if (mCur!=null) 
             { 
                mCur.moveToNext(); 
             } 
	    	 return mCur;
	    	 
	     }
	     
	
}
