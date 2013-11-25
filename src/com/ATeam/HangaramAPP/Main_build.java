package com.ATeam.HangaramAPP;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

import org.holoeverywhere.addon.Addons;
import org.holoeverywhere.widget.Toast;

import com.ATeam.HangaramAPP.Main.Work;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Main_build extends ActionBarActivity {
	TextView lunchTV, dinnerTV;
	boolean PressBack = false, isActivityAlive = true;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.magazine_main_build);
		setActionBar();
		setButtons();
		getTextViews();
		TodayMealTextPusher();
		ScheTextPusher();
		setCustomFonts();
	}

	public void setCustomFonts() {

		TextView txt;
		Typeface sn = Typeface.createFromAsset(getAssets(),
				"fonts/SeoulNamsanB.ttf");
		txt = (TextView) findViewById(R.id.Sche);
		txt.setTypeface(sn);
		txt = (TextView) findViewById(R.id.Sche_p);
		txt.setTypeface(sn);
		txt = (TextView) findViewById(R.id.lunchTV);
		txt.setTypeface(sn);
		txt = (TextView) findViewById(R.id.dinnerTV);
		txt.setTypeface(sn);
		txt = (TextView) findViewById(R.id.NextPeriodTV);
		txt.setTypeface(sn);
		txt = (TextView) findViewById(R.id.NextPlanTV);
		txt.setTypeface(sn);
		Typeface ng = Typeface.createFromAsset(getAssets(),
				"fonts/NANUMBARUNGOTHIC.ttf");
		txt = (TextView) findViewById(R.id.Sche_p2);
		txt.setTypeface(ng);
		txt = (TextView) findViewById(R.id.Sche_p1);
		txt.setTypeface(ng);
		txt = (TextView) findViewById(R.id.lunchTV1);
		txt.setTypeface(ng);
		txt = (TextView) findViewById(R.id.lunchTV2);
		txt.setTypeface(ng);
		txt = (TextView) findViewById(R.id.dinnerTV2);
		txt.setTypeface(ng);
		txt = (TextView) findViewById(R.id.dinnerTV1);
		txt.setTypeface(ng);
		txt = (TextView) findViewById(R.id.NextPeriodTV1);
		txt.setTypeface(ng);
		txt = (TextView) findViewById(R.id.NextPeriodTV2);
		txt.setTypeface(ng);

	}

	@Override
	public void onBackPressed() {

		if (PressBack == true) {
			isActivityAlive = false;
			finish();
			overridePendingTransition(R.anim.zoom_out_still,
					R.anim.zoom_out_enter);
		} else {
			Toast t = Toast.makeText(Main_build.this, "�ٽ� ������ �Ѱ������� �����մϴ�.",
					2000);
			t.show();
			Handler PressBackCheck = new Handler();
			PressBackCheck.postDelayed(new Runnable() {
				public void run() {
					if (isActivityAlive == true) {
						PressBack = false;
					}
				}
			}, 2000);
			PressBack = true;
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		ByeBye();
	}

	public void ByeBye() {
		int AppShutdownNoti = 4;
		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		PendingIntent intent = PendingIntent.getActivity(Main_build.this, 0,
				new Intent(Main_build.this, Today_meal.class), 0);

		Notification noti;
		noti = new NotificationCompat.Builder(getApplicationContext())
				.setTicker("�Ѱ������� �̿����ּż� �����մϴ�.\n���õ� ��ſ� �Ϸ�Ǽ���!")
				.setContentIntent(intent).setSmallIcon(R.drawable.ic_launcher)
				.build();

		nm.notify(AppShutdownNoti, noti);
		nm.cancel(AppShutdownNoti);

	}

	public void setActionBar() {
		
		 SpannableString s = new SpannableString(getString(R.string.$app_name));
		    s.setSpan(new TypefaceSpan(this, "SeoulNamsanB.ttf"), 0, s.length(),
		            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		ActionBar ab = getSupportActionBar();
		ab.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME
				| ActionBar.DISPLAY_SHOW_TITLE);
		ab.setTitle(s);
		ab.setHomeButtonEnabled(false);
		ab.setDisplayUseLogoEnabled(true);
	}

	public void setButtons() {
		ImageButton bpod = (ImageButton) findViewById(R.id.BabIB);
		bpod.setOnClickListener(new ImageButton.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(Main_build.this, Today_meal.class));
			}
		});
		bpod = (ImageButton) findViewById(R.id.ScheIB);
		bpod.setOnClickListener(new ImageButton.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(Main_build.this, Dday.class));
			}
		});

	}

	public void getTextViews() {
		lunchTV = (TextView) findViewById(R.id.lunchTV);
		dinnerTV = (TextView) findViewById(R.id.dinnerTV);
	}

	public void TodayMealTextPusher() {
		DbAdapter myHelper = new DbAdapter(this);
		myHelper.open("READ");

		Calendar calendar = Calendar.getInstance();
		int Y, D, M, W;
		int intdate;
		String plunch, pdinner;

		Y = calendar.get(Calendar.YEAR);
		M = calendar.get(Calendar.MONTH);
		D = calendar.get(Calendar.DAY_OF_MONTH);
		W = calendar.get(Calendar.DAY_OF_WEEK);
		M++;

		Log.i("Net", "�Ͼ��! " + Y + (M) + D);

		lunchTV.setText("���� ������ �ش� ��¥ �޽������� ���ε���� �ʾҽ��ϴ�.");
		dinnerTV.setText("���� ���ѳ��� ���ε� �ϵ��� �ϰڽ��ϴ�.");

		intdate = (Y * 10000 + M * 100 + D);

		Cursor cursor = myHelper.fetchd("bab");

		if (myHelper.getid("bab", "isbabcheck").equals("nodata") == true) {

			lunchTV.setText(getString(R.string.Act_Today_meal));
			dinnerTV.setText("���� ��⿡ ����� �޽� ������ �����ϴ�");
			return;
		}
		if (myHelper.getid("bab", "recdate") != null) {
			if (myHelper.getid("bab", "recdate").equals("NP") == true) {
				lunchTV.setText("��Ʈ��ũ ������ ���� ������Ʈ�� �ߴܵǾ����ϴ�");
				dinnerTV.setText("����� ��Ʈ��ũ ���� ��Ȳ�� �ٽ� Ȯ�����ּ���");
				return;
			} else {
				// recdate = Integer.valueOf(myHelper.getid("bab", "recdate"));
				// Log.i("Net", "[ERROR] : ���� ���� " + intdate + "//" + recdate);
				/*
				 * if (intdate > recdate) { Mlunch.setText("������ " + recdate +
				 * "�ڷ� ����Ǿ����ϴ�");
				 * Mdinner.setText("��Ʈ��ũ�� �����Ͻ� ��, ����� <�޽����� ������Ʈ> ��ư�� ���� ������Ʈ�� ���ּ���"
				 * ); return; }
				 */}
		} else {
			lunchTV.setText("��Ʈ��ũ ������ ���� ������Ʈ�� �ߴܵǾ����ϴ�");
			dinnerTV.setText("����� ��Ʈ��ũ ���� ��Ȳ�� �ٽ� Ȯ�����ּ���");
		}
		plunch = pdinner = "nodata";
		String strdate = Integer.toString(intdate);

		cursor.moveToFirst();
		plunch = pdinner = "nodata";

		do {
			// Log.i("Net", "* : " + cursor.getString(0) +
			// cursor.getString(1)
			// + cursor.getString(2));
			if (cursor.getString(1).equals(strdate + ".lunch") == true) {

				plunch = cursor.getString(2);
				Log.i("Net", "���� DB ã��! : " + plunch);
			} else if (cursor.getString(1).equals(strdate + ".dinner") == true) {
				Log.i("Net", "���� DB ã��! : " + pdinner);
				pdinner = cursor.getString(2);
			}
		} while (cursor.moveToNext());

		if (W == 1 || W == 7) {
			lunchTV.setText("���� �Դϴ�");
			dinnerTV.setText("���� �Դϴ�");
		} else if (plunch.equals("nodata")) { // DB�ȿ� ������ ���� ���
			lunchTV.setText("�޽� ������ �����ϴ�.");
			dinnerTV.setText("�޽� ������ �����ϴ�.");
		} else {
			lunchTV.setText(plunch);
			dinnerTV.setText(pdinner);

			if (plunch.equals("NP")) {
				lunchTV.setText("�޽��� �����ϴ�.");
			}
			if (pdinner.equals("NP")) {
				dinnerTV.setText("�޽��� �����ϴ�.");
			}
		}
		Log.i("Net", "�޽� ǥ�� �Ϸ�, " + plunch + pdinner);
		cursor.close();
		myHelper.close();
	}

	public final static Comparator<Work> myComparator = new Comparator<Work>() {

		private final Collator collator = Collator.getInstance();

		public int compare(Work arg0, Work arg1) {
			// TODO Auto-generated method stub
			return collator.compare(arg0.getDates(), arg1.getDates());
		}
	};

	public void ScheTextPusher() {

		TextView Sche, Sche_p;

		DbAdapter myHelper = new DbAdapter(getApplicationContext());
		myHelper.open("READ");
		Calendar calendar = Calendar.getInstance();
		int Y, D, M;
		String dates, events, dates_p, events_p;
		ArrayList<Work> todo = new ArrayList<Work>();
		ArrayList<Work> todo_p = new ArrayList<Work>();

		Y = calendar.get(Calendar.YEAR);
		M = calendar.get(Calendar.MONTH);
		D = calendar.get(Calendar.DAY_OF_MONTH);
		M++;
		int intdate = (Y * 10000 + M * 100 + D);

		Sche = (TextView) findViewById(R.id.Sche);
		Sche_p = (TextView) findViewById(R.id.Sche_p);

		Sche.setText("���� ���������� ����Ǿ����� �ʽ��ϴ�. ");
		Sche.setSelected(true);
		Sche_p.setText("������ �����Ͻ÷��� �����ʽÿ�.");
		Sche_p.setSelected(true);

		Cursor cursor = myHelper.fetchd("sche");
		cursor.moveToFirst();

		int i = 0;
		if (cursor.getCount() != 0) {

			do {
				dates = cursor.getString(2);
				events = cursor.getString(1);
				Y = Integer.valueOf(dates) / 10000;
				int k = Integer.valueOf(dates) % 10000;
				M = k / 100;
				D = Integer.valueOf(dates) % 100;
				Work p = new Work(events, dates, Y, M, D, false);
				todo.add(p);
			} while (cursor.moveToNext());
			Collections.sort(todo, myComparator);

			do {

				Work p1 = todo.get(i);
				Log.i("Net", "�������� ��¥�� " + p1.get_place());
				dates = p1.get_place();

				if (Integer.valueOf(dates) >= intdate) {
					Y = Integer.valueOf(dates) / 10000;
					int k = Integer.valueOf(dates) % 10000;
					M = k / 100;
					D = Integer.valueOf(dates) % 100;
					events = p1.get_works();

					Sche.setText("[ " + Y + "�� " + M + "�� " + D + "��" + " ] "
							+ events);
					Log.i("Net", "+ : " + events + dates + "<common> " + i);
					break;
				}
				i++;

			} while (i != todo.size());
		}
		cursor = myHelper.fetchd("sche_private");
		cursor.moveToFirst();

		i = 0;
		if (cursor.getCount() != 0) {

			do {
				dates_p = cursor.getString(2);
				events_p = cursor.getString(1);
				Y = Integer.valueOf(dates_p) / 10000;
				int k = Integer.valueOf(dates_p) % 10000;
				M = k / 100;
				D = Integer.valueOf(dates_p) % 100;
				Work p = new Work(events_p, dates_p, Y, M, D, false);
				todo_p.add(p);
			} while (cursor.moveToNext());
			Collections.sort(todo_p, myComparator);

			do {
				Work p1 = todo_p.get(i);
				Log.i("Net", "�������� ��¥�� " + p1.get_place());
				dates_p = p1.get_place();

				if (Integer.valueOf(dates_p) >= intdate) {
					Y = Integer.valueOf(dates_p) / 10000;
					int k = Integer.valueOf(dates_p) % 10000;
					M = k / 100;
					D = Integer.valueOf(dates_p) % 100;
					events_p = p1.get_works();

					Sche_p.setText("[ " + Y + "�� " + M + "�� " + D + "��" + " ] "
							+ events_p);
					Log.i("Net", "+ : " + events_p + dates_p + "<private> " + i);
					break;
				}
				i++;
			} while (i != todo_p.size());
		}
		cursor.close();
		myHelper.close();
	}

	public class Work {
		private int Y, M, D;
		private String works;
		private String place;
		private boolean isPrivate;

		public Work(String _works, String _place, int _Y, int _M, int _D,
				boolean _isPrivate) {
			this.works = _works;
			this.place = _place;
			this.Y = _Y;
			this.M = _M;
			this.D = _D;
			this.isPrivate = _isPrivate;
		}

		public boolean isPrivate() {
			return isPrivate;
		}

		public String getDates() {
			return Y * 10000 + M * 100 + D + "";
		}

		public int getY() {
			return Y;
		}

		public int getM() {
			return M;
		}

		public int getD() {
			return D;
		}

		public String get_works() {
			return works;
		}

		public String get_place() {
			return place;
		}

	}
}
