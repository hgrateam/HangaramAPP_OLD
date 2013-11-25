package com.ATeam.HangaramAPP;


import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class Teachers_info extends ActionBarActivity {

	
	Teachers_list aActivity = (Teachers_list)Teachers_list.Teachers_list;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		

		setTheme(R.style.Default);
		setContentView(R.layout.teachers_info);
		
		String data = Teachers_list.instance.DATA ;
		
		final ActionBar ab = getSupportActionBar();
    	ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
		ab.setDisplayHomeAsUpEnabled(true);
    	ab.setTitle(data);
    	ab.setLogo(R.drawable.teachers_w);
		ab.setDisplayUseLogoEnabled (true);
		
		
		
		int posit = Teachers_list.instance.POS ;
		int Click_dat = Teachers_list.instance.Click_dat;
		
		
		

		if(Click_dat == 1){
			
			if (posit == 0){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("�̻���");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("�ʴ뱳��");
			}
			

			if (posit == 1){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("�Ϲݻ�ȸ");
			}
			
			if (posit == 2){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("����");
			}
			
			if (posit == 3){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("��������");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			
		}
		else if(Click_dat == 2){
			
			if(posit == 0){
				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("�л�Ȱ����������");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("ü��");
			}
			
			else if(posit == 1){
				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("��������");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("����");
			}
			
			else if(posit == 2){
				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("�������� ����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("�Ϲݻ�ȸ,����");
			}
			
			else if(posit == 3){
				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("��������");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("��ǻ��");
			}			
			else if(posit == 4){
				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("��������");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			
			
			else if(posit == 5){
				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("��������");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			
			
			else if(posit == 6){
				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("�����н�����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			
			
			else if(posit == 7){
				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("�л�����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
		}
		
		else if(Click_dat == 3){		
		
		if (posit == 0){

			ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
			BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
			TPic.setImageDrawable(img);

			TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
			TTxt1.setText(data);
			
			TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
			TTxt2.setText("Adviser ����");
			
			TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
			TTxt3.setText("����,����");
		}
		
		
		else if (posit == 1){
			
			ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
			BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
			TPic.setImageDrawable(img);
			
			TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
			TTxt1.setText(data);
			
			TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
			TTxt2.setText("1�� Adviser(2,3)");
			
			TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
			TTxt3.setText("����");
		}
		else if (posit == 2){

			ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
			BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
			TPic.setImageDrawable(img);

			TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
			TTxt1.setText(data);
			
			TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
			TTxt2.setText("2�� Adviser");
			
			TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
			TTxt3.setText("�Ϻ���");
			
		}
		else if (posit == 3){

			ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
			BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
			TPic.setImageDrawable(img);

			TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
			TTxt1.setText(data);
			
			TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
			TTxt2.setText("3�� Adviser");
			
			TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
			TTxt3.setText("����");
			
		}
		else if (posit == 4){

			ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
			BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
			TPic.setImageDrawable(img);
			
			TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
			TTxt1.setText(data);
			
			TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
			TTxt2.setText("4�� Adviser");
			
			TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
			TTxt3.setText("����");
		}
		else if (posit == 5){

			ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
			BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
			TPic.setImageDrawable(img);
			
			TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
			TTxt1.setText(data);
			
			TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
			TTxt2.setText("5�� Adviser");
			
			TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
			TTxt3.setText("����");
		}
		else if (posit == 6){

			ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
			BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
			TPic.setImageDrawable(img);
			
			TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
			TTxt1.setText(data);
			
			TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
			TTxt2.setText("6�� Adviser");
			
			TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
			TTxt3.setText("ü��");
			
		}
		else if (posit == 7){

			ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
			BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
			TPic.setImageDrawable(img);
			
			TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
			TTxt1.setText(data);
			
			TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
			TTxt2.setText("7�� Adviser");
			
			TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
			TTxt3.setText("����");
		}
		else if (posit == 8){

			ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
			BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
			TPic.setImageDrawable(img);

			TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
			TTxt1.setText(data);
			
			TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
			TTxt2.setText("9�� Adviser(2,3) \n1�� Adviser(1)");
			
			TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
			TTxt3.setText("�ѹ�");
		}
		else if (posit == 9){

			ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
			BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
			TPic.setImageDrawable(img);

			TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
			TTxt1.setText(data);
			
			TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
			TTxt2.setText("10�� Adviser(2,3) \n8�� Adviser(1)");
			
			TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
			TTxt3.setText("����");
		}
		
		}
		else if(Click_dat == 4){
			if (posit == 0){
				
				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			
			else if (posit == 1){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			
			else if (posit == 2){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			
			else if (posit == 3){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			
		}
		
		else if(Click_dat == 5){
			
			if (posit == 0){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			
			else if (posit == 1){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			
			else if (posit == 2){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("��ȸ");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			
			else if (posit == 3){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			
			
		}
		else if (Click_dat == 6){
			
			if (posit == 0){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 1){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 2){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 3){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 4){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 5){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 6){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			
			
		}
		else if(Click_dat == 7){
			
			if (posit == 0){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("ȭ��");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 1){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 2){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 3){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("ȭ��");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 4){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 5){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("��������");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			
		}
		else if(Click_dat == 8){
			
			if (posit == 0){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 1){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 2){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 3){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 4){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 5){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 6){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 7){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("�߱���");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			
		}
		
		else if(Click_dat == 9){
			
			if (posit == 0){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("�̼�");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 1){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 2){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("�ѱ�����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 3){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("ü��");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 4){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("�缭");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 5){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("��ȭ");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 6){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("����");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 7){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("���Ǳ���");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 8){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("���Ǳ���");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			
			
		}
		
		else if(Click_dat == 10){
			
			if (posit == 0){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("������");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 1){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("������");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 2){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("������");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 3){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("������");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 4){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("������");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 5){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("������");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 6){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("������");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 7){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("������");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			else if (posit == 8){

				ImageView TPic = (ImageView) findViewById(R.id.Teachers_Pic);
				BitmapDrawable img = (BitmapDrawable) getResources().getDrawable(R.drawable.hgrapp);
				TPic.setImageDrawable(img);

				TextView TTxt1 = (TextView) findViewById(R.id.Teachers_NAME);
				TTxt1.setText(data);
				
				TextView TTxt2 = (TextView) findViewById(R.id.Teachers_PART);
				TTxt2.setText("������");
				
				TextView TTxt3 = (TextView) findViewById(R.id.Teachers_SUBJ);
				TTxt3.setText("");
			}
			
		}
		else{
			finish();
		}
		
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
	        	aActivity.finish();
	            finish();
	            overridePendingTransition(R.anim.bottom_to_top_in, R.anim.bottom_to_top_out);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
}
