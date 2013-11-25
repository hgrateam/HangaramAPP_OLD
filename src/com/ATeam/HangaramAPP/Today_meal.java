package com.ATeam.HangaramAPP;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;

import org.holoeverywhere.app.AlertDialog;
import org.holoeverywhere.app.ProgressDialog;
import org.holoeverywhere.widget.Toast;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Today_meal extends ActionBarActivity {

	Toast mToast;
	ProgressDialog dialog;
	boolean isConnected;
	private ProgressDialog mProgressDialog;
	Context mContext;
	int IsAPhone = 0;
	boolean IsParsing = false;
	DbAdapter myHelper = null;

	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setTheme(R.style.TodayMeal);
		setContentView(R.layout.today_meal);
		mContext = this;
		myHelper = new DbAdapter(this);

		myHelper.open("WRITE");
		myHelper.create("bab");
		myHelper.close();
		myHelper.open("READ");
		
		setActionBar();
		setCustomFonts();
		Refresh();

	}

	public void setActionBar() {

		SpannableString s = new SpannableString(
				getString(R.string.Act_Today_meal));
		s.setSpan(new TypefaceSpan(this, "SeoulNamsanB.ttf"), 0, s.length(),
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		final ActionBar ab = getSupportActionBar();
		ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME
				| ActionBar.DISPLAY_SHOW_TITLE);
		ab.setDisplayHomeAsUpEnabled(true);
		ab.setTitle(s);
		ab.setLogo(R.drawable.meal_w);
		ab.setDisplayUseLogoEnabled(true);

	}

	public void setCustomFonts(){
		TextView txt;
		Typeface sn = Typeface.createFromAsset(getAssets(),
				"fonts/SeoulNamsanB.ttf");
		txt = (TextView) findViewById(R.id.strlunch);
		txt.setTypeface(sn);
		txt = (TextView) findViewById(R.id.strdinner);
		txt.setTypeface(sn);
	}
	
	public boolean NetStatCHK() {

		ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo mobile = manager
				.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		NetworkInfo wifi = manager
				.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

		try {

			if (mobile != null) {
				if (mobile.isConnected() || wifi.isConnected()) {
					return true;
				}
				return false;
			}
		} catch (Exception e) {
		}
		return false;
	}

	public void mod() {
		if (D == 1) {
			if ((M) == 1) {
				M = 12;
				D = 31;
				Y--;
			} else {
				M--;
				if ((M) == 2 || (M) == 4 || (M) == 6 || (M) == 9 || (M) == 11)
					D = 30;
				else
					D = 31;
			}
		} else
			D--;
	}

	public void showToast(String str) {
		if (mToast == null) {
			mToast = Toast.makeText(Today_meal.this, str, Toast.LENGTH_SHORT);
		} else {
			mToast.setText(str);
		}
		mToast.show();

	}

	public void pod() {

		Cursor cursor = myHelper.fetchd("bab");
		cursor.moveToFirst();

		if (cursor.getCount() != 0) {
			do {
				if (cursor.getString(1).equals("recdate")) {

					int raw = Integer.valueOf(cursor.getString(2));
					recdate = raw;
					break;
				}
			} while (cursor.moveToNext());
		}

		if (Integer.valueOf(recdate) <= Y * 10000 + M * 100 + D) {
			showToast("�� �̻� �޽������� �������� �ʽ��ϴ�. �޽������� ������Ʈ ���ּ���.");
			// return;
		}
		if ((M) == 2 || (M) == 4 || (M) == 6 || (M) == 9 || (M) == 11) {
			if (D == 30) {
				D = 1;
				if ((M) == 12) {
					M = 1;
					Y++;
				} else
					M++;
			} else
				D++;
		} else {
			if (D == 31) {
				D = 1;
				if ((M) == 12) {
					M = 1;
					Y++;
				}

				else
					M++;
			} else
				D++;
		}
	}

	public void showDate() {
		TextView noticedate = (TextView) findViewById(R.id.dateview);
		noticedate.setText(Y + "�� " + M + "�� " + D + "�� " + YI[getYI(Y, M, D)]
				+ "����");
		dd = Integer.toString(Y * 10000 + (M) * 100 + D);

	}

	public void Refresh() {

		Y = calendar.get(Calendar.YEAR);
		M = calendar.get(Calendar.MONTH);
		D = calendar.get(Calendar.DAY_OF_MONTH);
		M++;

		Log.i("Net", "�Ͼ��! " + Y + (M) + D);
		dd = Integer.toString(Y * 10000 + (M) * 100 + D);
		TextView noticedate = (TextView) findViewById(R.id.dateview);
		noticedate.setText(Y + "�� " + M + "�� " + D + "�� " + YI[getYI(Y, M, D)]
				+ "����");

		update(dd);

	}

	public int getYI(int Y, int M, int D) {

		int a, b, c, d;
		if (M < 3) {
			a = ((Y - 1) / 100);
			b = (Y - 1) % (a * 100);
			c = 12 + M;
			d = D;
		} else {
			a = ((Y) / 100);
			b = (Y) % (a * 100);
			c = M;
			d = D;
		}
		int e = (((21 * a) / 4) + (5 * b / 4) + (26 * (c + 1) / 10) + d - 1) % 7;
		return e;

	}

	public void update(String dd2) {
		Log.i("Net", "update �� ����Ǿ����ϴ�.");
		Mlunch = (TextView) findViewById(R.id.strlunch);
		Mdinner = (TextView) findViewById(R.id.strdinner);
		//
		Log.i("Net", dd2);

		Mlunch.setText("���� ������ �ش� ��¥ �޽������� ���ε���� �ʾҽ��ϴ�.");
		Mdinner.setText("���� ���ѳ��� ���ε� �ϵ��� �ϰڽ��ϴ�.");
		Log.i("Net", dd + "���� �޽������� �����ϴ�");

		intdate = (Y * 10000 + M * 100 + D);

		Cursor cursor = myHelper.fetchd("bab");

		if (myHelper.getid("bab", "isbabcheck").equals("nodata") == true) {

			Mlunch.setText("���� ��⿡ ����� �޽� ������ �����ϴ�");
			Mdinner.setText("��Ʈ��ũ�� �����Ͻ� ��, ����� <�޽����� ������Ʈ> ��ư�� ���� ������Ʈ�� ���ּ���");
			return;
		}
		if (myHelper.getid("bab", "recdate") != null) {
			if (myHelper.getid("bab", "recdate").equals("NP") == true) {
				Mlunch.setText("��Ʈ��ũ ������ ���� ������Ʈ�� �ߴܵǾ����ϴ�");
				Mdinner.setText("����� ��Ʈ��ũ ���� ��Ȳ�� �ٽ� Ȯ�����ּ���");
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
			Mlunch.setText("��Ʈ��ũ ������ ���� ������Ʈ�� �ߴܵǾ����ϴ�");
			Mdinner.setText("����� ��Ʈ��ũ ���� ��Ȳ�� �ٽ� Ȯ�����ּ���");
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

		if (getYI(Y, M, D) == 0 || getYI(Y, M, D) == 6) {
			Mlunch.setText("���� �Դϴ�");
			Mdinner.setText("���� �Դϴ�");
		} else if (plunch.equals("nodata")) { // DB�ȿ� ������ ���� ���
			Mlunch.setText("�޽� ������ �����ϴ�.");
			Mdinner.setText("�޽� ������ �����ϴ�.");
		} else {
			Mlunch.setText(plunch);
			Mdinner.setText(pdinner);

			if (plunch.equals("NP")) {
				Mlunch.setText("�޽��� �����ϴ�.");
			}
			if (pdinner.equals("NP")) {
				Mdinner.setText("�޽��� �����ϴ�.");
			}
		}
		Log.i("Net", "�޽� ǥ�� �Ϸ�, " + plunch + pdinner);

	}

	private int Y, D, M;
	private int intdate, recdate;
	private TextView Mlunch, Mdinner;
	private String dd, plunch, pdinner;
	private String[] YI = { "��", "��", "ȭ", "��", "��", "��", "��" };
	Calendar calendar = Calendar.getInstance();

	@Override
	public void onBackPressed() {
		finish();
		overridePendingTransition(R.anim.bottom_to_top_in,
				R.anim.bottom_to_top_out);

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		myHelper.close();
	}

	public class LoadingParsing extends AsyncTask<Void, String, Void> {

		protected void onCancelled() {
			super.onCancelled();
		}

		@Override
		protected void onPreExecute() {
			Log.i("Net", "AsyncTask ���� - ���̾�α� ����");

			mProgressDialog = new ProgressDialog(Today_meal.this);
			mProgressDialog.setTitle("�޽� ���� ������Ʈ");
			mProgressDialog.setCancelable(false);
			mProgressDialog
					.setMessage("�޽� ������ �������� �����޾� ��� ���ο� �����ϰ� �ֽ��ϴ�. \n�� �۾��� �Ϸ�Ǹ� �ֱ� �����ϱ��� ��Ʈ��ũ ������� �޽��� Ȯ���� �� �ֽ��ϴ�.");
			mProgressDialog.show();
		}

		@Override
		protected void onPostExecute(Void result) {
			Log.i("Net", "AsyncTask ���� - ���̾�α� ����");

			mProgressDialog.dismiss();
			Refresh();

			if ((myHelper.getid("bab", "isbabcheck")).equals("NetError") == true) {
				showToast("���� ���̽� ���� �������Դϴ�.");
			} else {
				showToast("����� �޽������� �б� ������ ���� ����� �� �ִٴ� ���� �����Ͽ� �ֽñ� �ٶ��ϴ�.");
			}
		}

		@Override
		protected void onProgressUpdate(String... str) {
			Log.i("Net", "AsyncTask ������");
			showToast(str[0]);

			super.onProgressUpdate();

		}

		@Override
		protected Void doInBackground(Void... arg0) {
			Log.i("Net", "AsyncTask ��׶��忡�� �۾���");

			Calendar calendar = Calendar.getInstance();
			int Y, M, D, recdate;
			Y = calendar.get(Calendar.YEAR);
			M = calendar.get(Calendar.MONTH);
			M++;
			D = calendar.get(Calendar.DAY_OF_MONTH);
			BabParse updater = new BabParse(mContext);

			updater.parse(Y, M, true);

			// mProgressDialog.dismiss();
			// TODO Auto-generated method stub
			return null;

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_today_meal, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// app icon in action bar clicked; go home
			finish();
			overridePendingTransition(R.anim.bottom_to_top_in,
					R.anim.bottom_to_top_out);
			return true;

		case R.id.Help:
			Toast.makeText(
					Today_meal.this,
					"���� ���� ����� <�޽����� ������Ʈ> ��ư�� ���� �����͸� �����մϴ�. \n�� �� �ʿ��Ͻôٸ� ���ΰ�ħ�� ���� ������ ǥ���ϰ� �մϴ�.",
					Toast.LENGTH_SHORT).show();
			return true;

		case R.id.Act_Parsing_meal:

			if (NetStatCHK() == true) {
				new LoadingParsing().execute();
				Refresh();
			} else {
				AlertDialog.Builder ab = new AlertDialog.Builder(
						Today_meal.this);
				ab.setMessage(getString(R.string.NetStat_error));
				ab.setPositiveButton("Ȯ��", null);
				ab.show();
			}
			return true;
		case R.id.PreDay:
			mod();
			showDate();
			Log.i("Net", "-1�� ��ư�� ����");
			update(dd);
			return true;
		case R.id.NextDay:
			pod();
			showDate();
			Log.i("Net", "+1�� ��ư�� ����");
			update(dd);
			return true;
		case R.id.Today:
			Refresh();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}

// http://kkoseul.tistory.com/30
// http://devsw.tistory.com/60