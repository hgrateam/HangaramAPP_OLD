package com.ATeam.HangaramAPP;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Teachers_list extends ActionBarActivity {

	public static Activity Teachers_list;
	
	
	public static Teachers_list instance;
	public int POS = 0;
	public int Click_dat =0;
	public String DATA;
	public ArrayList<String> data1, data2, data3, data4, data5, data6, data7, data8,
			data9, data10;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		

		setTheme(R.style.Default);
		setContentView(R.layout.teachers_list);
		
		final ActionBar ab = getSupportActionBar();
    	ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
		ab.setDisplayHomeAsUpEnabled(true);
    	ab.setTitle(getString(R.string.Act_Teachers_list));
    	ab.setLogo(R.drawable.teachers_w);
		ab.setDisplayUseLogoEnabled (true);
		
    	Teachers_list = Teachers_list.this;
		
		instance = this;

		// #1
		// List ����
		data1 = new ArrayList<String>();
		data1.add("�̿��� ������");
		data1.add("�鼺ȣ ������");
		data1.add("������ ������");
		data1.add("������ ������");

		// #
		ArrayAdapter<String> adpater1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, data1);

		ListView list1 = (ListView) findViewById(R.id.tab1_listView);
		list1.setAdapter(adpater1);

		list1.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Click_dat = 1;
				// Ŭ���� �������� �������� �̿��� ����ͺ信�� �������� �����´�.
				   final String data_T = (String) parent.getItemAtPosition(position);
				   POS = position;
				   DATA = data_T;
				startActivity(new Intent(Teachers_list.this,
						Teachers_info.class));
				overridePendingTransition(R.anim.top_to_bottom_in, R.anim.top_to_bottom_out);
			}
		});

		// #2
		// List ����
		data2 = new ArrayList<String>();
		data2.add("�̿�� ������");
		data2.add("�ſ��� ������");
		data2.add("�ֽ��� ������");
		data2.add("������ ������");
		data2.add("������ ������");
		data2.add("�̼��� ������");
		data2.add("�ڱ��� ������");
		data2.add("�ڿ��� ������");

		// #
		ArrayAdapter<String> adpater2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, data2);

		ListView list2 = (ListView) findViewById(R.id.tab2_listView);
		list2.setAdapter(adpater2);

		list2.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Click_dat = 2;
				
				// Ŭ���� �������� �������� �̿��� ����ͺ信�� �������� �����´�.
			   final String data_T = (String) parent.getItemAtPosition(position);
			   POS = position;
			   DATA = data_T;
				startActivity(new Intent(Teachers_list.this,
						Teachers_info.class));
				overridePendingTransition(R.anim.top_to_bottom_in, R.anim.top_to_bottom_out);
			}
		});

		// #3
		// List ����
		data3 = new ArrayList<String>();
		data3.add("�輺�� ������");
		data3.add("���ҿ� ������");
		data3.add("������ ������");
		data3.add("������ ������");
		data3.add("������ ������");
		data3.add("�̼��� ������");
		data3.add("������ ������");
		data3.add("������ ������");
		data3.add("���� ������");
		data3.add("������ ������");

		// #
		ArrayAdapter<String> adpater3 = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, data3);

		ListView list3 = (ListView) findViewById(R.id.tab3_listView);
		list3.setAdapter(adpater3);

		list3.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Click_dat = 3;
				// Ŭ���� �������� �������� �̿��� ����ͺ信�� �������� �����´�.
			   final String data_T = (String) parent.getItemAtPosition(position);
			   POS = position;
			   DATA = data_T;
			// Ŭ���� �������� �������� Ȯ���� ����.
			   Log.i("AndroidTutorial07Activity", "---------------------------------------------------------");
			   Log.i("AndroidTutorial07Activity", "onItemClick()");
			   Log.i("AndroidTutorial07Activity", "position is " + position);
			   Log.i("AndroidTutorial07Activity", "data3_POS is " + data_T);
			   Log.i("AndroidTutorial07Activity", "POS is " + POS);
			 
				startActivity(new Intent(Teachers_list.this,
						Teachers_info.class));
				overridePendingTransition(R.anim.top_to_bottom_in, R.anim.top_to_bottom_out);
			}
		});
		

		// #4
		// List ����
		data4 = new ArrayList<String>();
		data4.add("������ ������");
		data4.add("�ֻ� ������");
		data4.add("������ ������");
		data4.add("������ ������");

		// #
		ArrayAdapter<String> adpater4 = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, data4);

		ListView list4 = (ListView) findViewById(R.id.tab4_listView);
		list4.setAdapter(adpater4);

		list4.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Click_dat = 4;
				// Ŭ���� �������� �������� �̿��� ����ͺ信�� �������� �����´�.
				   final String data_T = (String) parent.getItemAtPosition(position);
				   POS = position;
				   DATA = data_T;
				
				startActivity(new Intent(Teachers_list.this,
						Teachers_info.class));
				overridePendingTransition(R.anim.top_to_bottom_in, R.anim.top_to_bottom_out);
			}
		});
		
		
		// #5
		// List ����
		data5 = new ArrayList<String>();
		data5.add("�������� ������");
		data5.add("��ö�� ������");
		data5.add("�迹�� ������");
		data5.add("���μ� ������");

		// #
		ArrayAdapter<String> adpater5 = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, data5);

		ListView list5 = (ListView) findViewById(R.id.tab5_listView);
		list5.setAdapter(adpater5);

		list5.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Click_dat = 5;
				// Ŭ���� �������� �������� �̿��� ����ͺ信�� �������� �����´�.
				   final String data_T = (String) parent.getItemAtPosition(position);
				   POS = position;
				   DATA = data_T;
				
				startActivity(new Intent(Teachers_list.this,
						Teachers_info.class));
				overridePendingTransition(R.anim.top_to_bottom_in, R.anim.top_to_bottom_out);
			}
		});
		
		
		// #6
		// List ����
		data6 = new ArrayList<String>();
		data6.add("��ö ������");
		data6.add("�迬�� ������");
		data6.add("������ ������");
		data6.add("������ ������");
		data6.add("���¿� ������");
		data6.add("����ö ������");
		data6.add("������ ������");

		// #
		ArrayAdapter<String> adpater6 = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, data6);

		ListView list6 = (ListView) findViewById(R.id.tab6_listView);
		list6.setAdapter(adpater6);

		list6.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Click_dat = 6;
				// Ŭ���� �������� �������� �̿��� ����ͺ信�� �������� �����´�.
				   final String data_T = (String) parent.getItemAtPosition(position);
				   POS = position;
				   DATA = data_T;
				
				startActivity(new Intent(Teachers_list.this,
						Teachers_info.class));
				overridePendingTransition(R.anim.top_to_bottom_in, R.anim.top_to_bottom_out);
			}
		});
		
		
		// #7
		// List ����
		data7 = new ArrayList<String>();
		data7.add("������ ������");
		data7.add("������ ������");
		data7.add("�ڼ��� ������");
		data7.add("������ ������");
		data7.add("���¿� ������");
		data7.add("����� ������");

		// #
		ArrayAdapter<String> adpater7 = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, data7);

		ListView list7 = (ListView) findViewById(R.id.tab7_listView);
		list7.setAdapter(adpater7);

		list7.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Click_dat = 7;
				// Ŭ���� �������� �������� �̿��� ����ͺ信�� �������� �����´�.
				   final String data_T = (String) parent.getItemAtPosition(position);
				   POS = position;
				   DATA = data_T;
				
				startActivity(new Intent(Teachers_list.this,
						Teachers_info.class));
				overridePendingTransition(R.anim.top_to_bottom_in, R.anim.top_to_bottom_out);
			}
		});
		
		
		// #8
		// List ����
		data8 = new ArrayList<String>();
		data8.add("������ ������");
		data8.add("����� ������");
		data8.add("���ػ� ������");
		data8.add("������ ������");
		data8.add("�ڰ�� ������");
		data8.add("�۶�� �� ������");
		data8.add("Philip Marnell ������");
		data8.add("���γ� ������");

		// #
		ArrayAdapter<String> adpater8 = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, data8);

		ListView list8 = (ListView) findViewById(R.id.tab8_listView);
		list8.setAdapter(adpater8);

		list8.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Click_dat = 8;
				// Ŭ���� �������� �������� �̿��� ����ͺ信�� �������� �����´�.
				   final String data_T = (String) parent.getItemAtPosition(position);
				   POS = position;
				   DATA = data_T;
				
				startActivity(new Intent(Teachers_list.this,
						Teachers_info.class));
				overridePendingTransition(R.anim.top_to_bottom_in, R.anim.top_to_bottom_out);
			}
		});							
		
		
		// #9
		// List ����
		data9 = new ArrayList<String>();
		data9.add("�ֺ��� ������");
		data9.add("�̿��� ������");
		data9.add("�̿��� ������");
		data9.add("�ڿ�ȣ ������");
		data9.add("���̼� ������");
		data9.add("�躴�� ������");
		data9.add("������ ������");
		data9.add("�ǿ��� ������");
		data9.add("������ ������");

		// #
		ArrayAdapter<String> adpater9 = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, data9);

		ListView list9 = (ListView) findViewById(R.id.tab9_listView);
		list9.setAdapter(adpater9);

		list9.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Click_dat = 9;
				// Ŭ���� �������� �������� �̿��� ����ͺ信�� �������� �����´�.
				   final String data_T = (String) parent.getItemAtPosition(position);
				   POS = position;
				   DATA = data_T;
				
				startActivity(new Intent(Teachers_list.this,
						Teachers_info.class));
				overridePendingTransition(R.anim.top_to_bottom_in, R.anim.top_to_bottom_out);
			}
		});							
				
		
		// #10
		// List ����
		data10 = new ArrayList<String>();
		data10.add("������ ������");
		data10.add("��ġ�� ������");
		data10.add("������ ������");
		data10.add("��â�� ������");
		data10.add("������ ������");
		data10.add("���μ� ������");
		data10.add("������ ������");
		data10.add("������ ������");
		data10.add("������ ������");

		// #
		ArrayAdapter<String> adpater10 = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, data10);

		ListView list10 = (ListView) findViewById(R.id.tab10_listView);
		list10.setAdapter(adpater10);

		list10.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Click_dat = 10;
				// Ŭ���� �������� �������� �̿��� ����ͺ信�� �������� �����´�.
				   final String data_T = (String) parent.getItemAtPosition(position);
				   POS = position;
				   DATA = data_T;
				
				startActivity(new Intent(Teachers_list.this,
						Teachers_info.class));
				overridePendingTransition(R.anim.top_to_bottom_in, R.anim.top_to_bottom_out);
			}
		});							
					
		
//
		// ���⼭���� �ǵ��� ���ÿ�.

		TabHost tabhost = (TabHost) findViewById(R.id.tab_host);
		tabhost.setup();

		// ��ǥ ������_tab1
		TabSpec tbspc1 = tabhost.newTabSpec("Tab1");
		tbspc1.setIndicator("     ��ǥ     ");
		tbspc1.setContent(R.id.tab1);
		tabhost.addTab(tbspc1);

		// ������������ ������_tab2
		TabSpec tbspc2 = tabhost.newTabSpec("Tab2");
		tbspc2.setIndicator(" ������������ ");
		tbspc2.setContent(R.id.tab2);
		tabhost.addTab(tbspc2);

		// AA ������_tab3
		TabSpec tbspc3 = tabhost.newTabSpec("Tab3");
		tbspc3.setIndicator(" Academic Adviser ");
		tbspc3.setContent(R.id.tab3);
		tabhost.addTab(tbspc3);

		// ���� ������_tab4
		TabSpec tbspc4 = tabhost.newTabSpec("Tab4");
		tbspc4.setIndicator("    �����    ");
		tbspc4.setContent(R.id.tab4);
		tabhost.addTab(tbspc4);

		// ��ȸ�� ������_tab5
		TabSpec tbspc5 = tabhost.newTabSpec("Tab5");
		tbspc5.setIndicator("    ��ȸ��    ");
		tbspc5.setContent(R.id.tab5);
		tabhost.addTab(tbspc5);

		// ���а� ������_tab6
		TabSpec tbspc6 = tabhost.newTabSpec("Tab6");
		tbspc6.setIndicator("    ���а�    ");
		tbspc6.setContent(R.id.tab6);
		tabhost.addTab(tbspc6);

		// ���а� ������_tab7
		TabSpec tbspc7 = tabhost.newTabSpec("Tab7");
		tbspc7.setIndicator("    ���а�    ");
		tbspc7.setContent(R.id.tab7);
		tabhost.addTab(tbspc7);

		// �����/�߱��� ������_tab8
		TabSpec tbspc8 = tabhost.newTabSpec("Tab8");
		tbspc8.setIndicator(" �����/�߱��� ");
		tbspc8.setContent(R.id.tab8);
		tabhost.addTab(tbspc8);

		// �Ǳⱳ��/�缭/���ǽ� ������_tab9
		TabSpec tbspc9 = tabhost.newTabSpec("Tab9");
		tbspc9.setIndicator(" �Ǳⱳ��/�缭/���ǽ� ");
		tbspc9.setContent(R.id.tab9);
		tabhost.addTab(tbspc9);

		// ������ ������_tab10
		TabSpec tbspc10 = tabhost.newTabSpec("Tab10");
		tbspc10.setIndicator("    ������    ");
		tbspc10.setContent(R.id.tab10);
		tabhost.addTab(tbspc10);

	}
	@Override
	public void onBackPressed() {
		finish();
		overridePendingTransition(R.anim.bottom_to_top_in, R.anim.bottom_to_top_out);
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	            // app icon in action bar clicked; go home
	        	/*
	            Intent intent = new Intent(this, Main.class);
	            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            startActivity(intent);
	            */
	        	finish();
	            overridePendingTransition(R.anim.bottom_to_top_in, R.anim.bottom_to_top_out);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
}
