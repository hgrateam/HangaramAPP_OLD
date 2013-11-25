package com.ATeam.HangaramAPP;

import java.util.ArrayList;

import org.holoeverywhere.widget.Spinner;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Calc extends ActionBarActivity {

	/** Called when the activity is first created. */
	@SuppressWarnings("unused")
	private TextView subch, spinhelp1, spinhelp2, s_nullspace, s_nullspace2;
	private Button gocalc;
	private Spinner subs;
	private boolean FLAG;
	private ArrayAdapter<String> adapter;
	private EditText ET1, ET2, ET3, ET4, DT1, subpos;
	private LinearLayout scoreview;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setTheme(R.style.Default);
		setContentView(R.layout.calc);
		setvisible(View.INVISIBLE);
		
	       final ActionBar actionBar = getSupportActionBar();
	       actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
	       actionBar.setDisplayHomeAsUpEnabled(true);
	       actionBar.setTitle(getString(R.string.Act_Calc));
	       actionBar.setLogo(R.drawable.calc_w);
	       actionBar.setDisplayUseLogoEnabled (true);
	       
	       

		subs = (Spinner) findViewById(R.id.subspin);
		spinhelp1 = (TextView) findViewById(R.id.spinhelp1);

		ArrayList<String> list;
		list = new ArrayList<String>();
		list.add("���� ����");
		list.add("����/���� (���� 4ȸ)");
		list.add("�� �� ���� (���� 2ȸ)");
		
		String[] array = new String[] {"���� ����", "����/���� (���� 4ȸ)", "�� �� ���� (���� 2ȸ)"};

		SpinnerAdapter spinAD = new SpinnerAdapter(this,
    			android.R.layout.simple_spinner_item, array);
		
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		subs.setAdapter(spinAD);

		subs.setOnItemSelectedListener(molis);
		// TODO Auto-generated method stub
	}

	private org.holoeverywhere.widget.AdapterView.OnItemSelectedListener molis = new org.holoeverywhere.widget.AdapterView.OnItemSelectedListener() {
		public void onItemSelected(org.holoeverywhere.widget.AdapterView<?> parent, View view,
				int position, long id) {

			// EditText �ʱ�ȭ

			ET1.setText("");
			ET2.setText("");
			ET3.setText("");
			ET4.setText("");
			DT1.setText("");
			subpos.setText("");

			if (position == 0) {
				setvisible(View.INVISIBLE);
				spinhelp1.setVisibility(View.VISIBLE);
				spinhelp1.setText("���� ������ �� �ֽʽÿ�");
				Log.i("Net", "���� ����");
			} else {
				spinhelp1.setVisibility(View.INVISIBLE);
				setvisible(View.VISIBLE);
				if (position == 1) { // ����/��� �� ���
					Log.i("Net", "���� ����");
					FLAG = false;
					s_nullspace.setText("1������/�߰����/2������/�⸻��� ���� (0~100)");
					ET3.setEnabled(true);
					ET4.setEnabled(true);
				} else if (position == 2) {
					Log.i("Net", "�׿�");
					ET3.setEnabled(false);
					ET4.setEnabled(false);
					FLAG = true;
					s_nullspace.setText("�߰����/�⸻��� ����  (0~100)");
				}
			}
		}

		public void onNothingSelected(org.holoeverywhere.widget.AdapterView<?> parent) {
			// TODO Auto-generated method stub
			setvisible(View.INVISIBLE);
			spinhelp1.setVisibility(View.VISIBLE);
			spinhelp1.setText("���� ������ �� �ֽʽÿ�");
			Log.i("Net", "���� ����");

		}
	};

	public void setvisible(int a) {
		gocalc = (Button) findViewById(R.id.gocalc);
		gocalc.setOnClickListener(mBTN_gocalc);
		ET1 = (EditText) findViewById(R.id.ET1);
		ET2 = (EditText) findViewById(R.id.ET2);
		ET3 = (EditText) findViewById(R.id.ET3);
		ET4 = (EditText) findViewById(R.id.ET4);
		DT1 = (EditText) findViewById(R.id.DT1);
		subpos = (EditText) findViewById(R.id.subpos);
		spinhelp1 = (TextView) findViewById(R.id.spinhelp1);
		spinhelp2 = (TextView) findViewById(R.id.spinhelp2);
		s_nullspace = (TextView) findViewById(R.id.s_nullspace);
		s_nullspace2 = (TextView) findViewById(R.id.s_nullspace2);

		scoreview = (LinearLayout) findViewById(R.id.scoreview);
		scoreview.setVisibility(a);
		
		s_nullspace2.setText("������ ���� (0~�������)");
	}

	private OnClickListener mBTN_gocalc = new OnClickListener() {
		public void onClick(View v) {
			// ��Ƽ�� �����ֱ�
			boolean checknull = false;
			int a, b, c, d, pos, e;
			int sa, sb, sc;
			AlertDialog.Builder ab = new AlertDialog.Builder(Calc.this);
			if (subpos.getText().toString().equals("") == true)
				checknull = true;

			if (ET1.getText().toString().equals("") == true)
				checknull = true;
			if (ET2.getText().toString().equals("") == true && FLAG == false)
				checknull = true;
			if (ET3.getText().toString().equals("") == true && FLAG == false)
				checknull = true;

			if (checknull == true) {
				ab.setMessage("����� �� ��ġ�� �Է����ֽʽÿ�. ������� �����մϴ�.");
				ab.setPositiveButton("Ȯ��", null);
				ab.show();
				return;
			}
			
			
			checknull = false;

			a = Integer.parseInt(ET1.getText().toString());
			b = Integer.parseInt(ET2.getText().toString());
			e = Integer.parseInt(DT1.getText().toString());
			pos = Integer.parseInt(subpos.getText().toString());

			if (FLAG == false) { // ���� 4��

				c = Integer.parseInt(ET3.getText().toString());
				d = Integer.parseInt(ET4.getText().toString());

				// sa = ���� ���� sb = �������� sc= �� ����

				sa = e;
				sb = a * (100 - pos) / 400 + b * (100 - pos) / 400 + c
						* (100 - pos) / 400 + d * (100 - pos) / 400;
				sc = sa + sb;
				ab.setMessage("���� : ����(" + sa + "/" + pos + ") + ����(" + sb
						+ "/" + (100 - pos) + ") = (" + sc + "/100)");
				ab.setPositiveButton("Ȯ��", null);
				ab.show();
			} else if (FLAG == true) { // ���� 2��

				sa = e;
				sb = a * (100 - pos) / 200 + b * (100 - pos) / 200;
				sc = sa + sb;

				ab.setMessage("���� : ����(" + sa + "/" + pos + ") + ����(" + sb
						+ "/" + (100 - pos) + ") = (" + sc + "/100)");
				ab.setPositiveButton("Ȯ��", null);
				ab.show();
			}

		}
	};
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
	        	finish();
	            overridePendingTransition(R.anim.bottom_to_top_in, R.anim.bottom_to_top_out);
	            
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

public class SpinnerAdapter extends ArrayAdapter<String> {
    Context context;
    String[] items = new String[] {};
 
    public SpinnerAdapter(final Context context,
            final int textViewResourceId, final String[] objects) {
        super(context, textViewResourceId, objects);
        this.items = objects;
        this.context = context;
    }
 
    /**
     * ���ǳ� Ŭ���� �������� View�� ����
     */
    @Override
    public View getDropDownView(int position, View convertView,
            ViewGroup parent) {
 
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(
                    android.R.layout.simple_spinner_dropdown_item, parent, false);
        }
 
        TextView tv = (TextView) convertView
                .findViewById(android.R.id.text1);
        tv.setText(items[position]);
        tv.setTextColor(Color.WHITE);
        //tv.setTextSize(25);
        return convertView;
    }
 
    /**
     * �⺻ ���ǳ� View ����
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(
                    android.R.layout.simple_spinner_item, parent, false);
        }
 
        TextView tv = (TextView) convertView
                .findViewById(android.R.id.text1);
        tv.setText(items[position]);
        //tv.setTextColor(Color.BLUE);
        //tv.setTextSize(15);
        return convertView;
    }
}
}
