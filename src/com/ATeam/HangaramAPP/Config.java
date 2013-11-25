package com.ATeam.HangaramAPP;

import org.holoeverywhere.preference.PreferenceActivity;
import org.holoeverywhere.widget.Toast;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.MenuItem;

public class Config extends PreferenceActivity {

	DbAdapter myHelper;
	Toast mToast;
	
	 @Override
	    public void onCreate(Bundle savedInstanceState){
		 setTheme(R.style.Default);
	        super.onCreate(savedInstanceState);
	        
	        addPreferencesFromResource(R.xml.config);
	        
	        ActionBar ab = getSupportActionBar();
			ab.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
			ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME
					| ActionBar.DISPLAY_SHOW_TITLE);
			ab.setTitle(getString(R.string.Act_Config));
			ab.setDisplayHomeAsUpEnabled(true);
			ab.setLogo(R.drawable.ic_action_settings);
			ab.setDisplayUseLogoEnabled (true);
	        
			myHelper = new DbAdapter(this);
	    }
	 
	 public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference)
	    {
	        // ���ø����̼� �̸�
	        if(preference.getKey().equals("config_reset_pref"))
	        {
	        	Log.i("Net", "���� �ʱ�ȭ ��ư ����");
				
				SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
				Editor editor = settings.edit();
				editor.clear();
				editor.commit();
				
				onContentChanged();
				startActivity(new Intent(Config.this, Config.class));
				overridePendingTransition(R.anim.zoom_out_still,
						R.anim.zoom_out_enter);
				finish();
	        }
	        
	        if(preference.getKey().equals("delete_meal_pref"))
	        {
	   	     // ��Ƽ�� �����ֱ�
	   			myHelper.open("WRITE");
	   			myHelper.create("bab");
	   			myHelper.close();
	   			myHelper.open("WRITE");
	   			myHelper.deletetable("bab");
	   			myHelper.close();
	   			myHelper.open("WRITE");

	   			myHelper.create("bab");
	   			myHelper.close();

	   			showToast("�̶����� ����� �޽������� ��� �����Ǿ����ϴ�.\n���� �޽ľ�����Ʈ�� �ð��� �ټ� ���� �ҿ�� �� �ֽ��ϴ�.");
	        	
	        }

	        
	        
	        
	        
	        return false;
	    }
	 
	 public void showToast(String str) {
			mToast = Main.mToast;
			
			if (mToast == null) {
				mToast = Toast.makeText(Config.this, str,
						Toast.LENGTH_SHORT);
			} else {
				mToast.setText(str);
			}
			mToast.show();

		}
	 
	 
		@Override
		public void onBackPressed() {
			finish();
			overridePendingTransition(R.anim.top_to_bottom_in, R.anim.top_to_bottom_out);
		}
		
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
		    switch (item.getItemId()) {
		        case android.R.id.home:
		        	finish();
		            overridePendingTransition(R.anim.top_to_bottom_in, R.anim.top_to_bottom_out);
		            return true;
		        default:
		            return super.onOptionsItemSelected(item);
		    }
		}
}
