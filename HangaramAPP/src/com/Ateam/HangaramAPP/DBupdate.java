package com.Ateam.HangaramAPP;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import com.Ateam.HangaramAPP.DbAdapter;

public class DBupdate extends Activity {

	DbAdapter myHelper;
	private Button dbupbot;
	private Button upbot1;
	private TextView uptv1;
	private String ISNOTICEUPDATE;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    myHelper = new DbAdapter(this);
	    
	    dbupbot = (Button)findViewById(R.id.updatebot);
	    upbot1 = (Button)findViewById(R.id.upbot1);
	    uptv1 = (TextView)findViewById(R.id.uptv1);
	    	
	    setContentView(R.layout.dbupdate);
	    // DB 테이블 생성
	    
	    SQLiteDatabase db;
	    myHelper.open("WRITE");	    
	    Cursor cursor = myHelper.fetchd();
	    int cnt=cursor.getCount();
    	myHelper.close();
	    
	    if(cnt==0){
		    myHelper.open("WRITE");	    
	    	Log.i("Net","처음 시작!");
//	    	ContentValues values = new ContentValues();
//	    	values.put("tf", "false");
	    	myHelper.insertd("false","Isshowupdate?");
	    	
	    	myHelper.close();
	    }
	    else{
	    	getnoticeid();
	    }
	}
	public boolean getnoticeid(){
	    myHelper.open("READ");
	    Cursor cursor = myHelper.fetchd();
    	Log.i("Net","처음 실행이 아니다!");
	    Log.i("Net","현재 "+cursor.getColumnCount()+"개의 정보가 저장되어 있습니다");
	    cursor.moveToFirst();
		ISNOTICEUPDATE = cursor.getString(2);
	    Log.i("Net","* : "+cursor.getString(0)+cursor.getString(1)+cursor.getString(2));
	    String flag = cursor.getString(2);
	    myHelper.close();
	    if(flag.equals("false")==true) return false;
	    else return true;
		
	}
}

//http://stackoverflow.com/questions/8690039/android-db-helper-class