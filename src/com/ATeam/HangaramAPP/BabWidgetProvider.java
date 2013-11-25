package com.ATeam.HangaramAPP;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.PendingIntent;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.ATeam.HangaramAPP.Today_meal.LoadingParsing;

import android.app.ProgressDialog;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;

public class BabWidgetProvider extends AppWidgetProvider {

	int Y, M, D, H, mwidgetid;
	Context mcontext;
	String showbabtxt;
	RemoteViews mviews;
	AppWidgetManager mwidgetmanager;
	boolean isConnected, isError;

	/*
	 * @Override public void onReceive(Context context, Intent intent) { String
	 * action = intent.getAction(); if
	 * (AppWidgetManager.ACTION_APPWIDGET_UPDATE.equals(action)) { Bundle extras
	 * = intent.getExtras(); if (extras != null) { int[] appWidgetIds = extras
	 * .getIntArray(AppWidgetManager.EXTRA_APPWIDGET_IDS); if (appWidgetIds !=
	 * null && appWidgetIds.length > 0) { this.onUpdate(context,
	 * AppWidgetManager.getInstance(context), appWidgetIds); } } } else if
	 * (AppWidgetManager.ACTION_APPWIDGET_DELETED.equals(action)) { Bundle
	 * extras = intent.getExtras(); if (extras != null &&
	 * extras.containsKey(AppWidgetManager.EXTRA_APPWIDGET_ID)) { final int
	 * appWidgetId = extras .getInt(AppWidgetManager.EXTRA_APPWIDGET_ID);
	 * this.onDeleted(context, new int[] { appWidgetId }); } } else if
	 * (AppWidgetManager.ACTION_APPWIDGET_ENABLED.equals(action)) {
	 * this.onEnabled(context); } else if
	 * (AppWidgetManager.ACTION_APPWIDGET_DISABLED.equals(action)) {
	 * this.onDisabled(context); } }
	 */
	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {

		appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(
				context, getClass()));
		super.onUpdate(context, appWidgetManager, appWidgetIds);

		final int N = appWidgetIds.length;

		for (int i = 0; i < N; i++) {
			int appWidgetId = appWidgetIds[i];
			updateAppWidget(context, appWidgetManager, appWidgetId);
		}

	}

	@Override
	public void onEnabled(Context context) {
		PackageManager pm = context.getPackageManager();
		pm.setComponentEnabledSetting(new ComponentName(
				"com.ATeam.HangaramAPP", "com.ATeam.HangaramAPP.BabWidgetProvider"),
				PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
				PackageManager.DONT_KILL_APP);

	}

	public void updateAppWidget(Context context,
			AppWidgetManager appWidgetManager, int appWidgetId) {

		long now = System.currentTimeMillis();
		Date date = new Date(now);
		SimpleDateFormat sdfNow = new SimpleDateFormat("HH");
		H = Integer.valueOf(sdfNow.format(date));

		isError = false;
		mcontext = context;
		RemoteViews views = new RemoteViews(context.getPackageName(),
				R.layout.bablayout);
		publishshowbab();

		if (isError == true)
			views.setTextViewText(R.id.showbab, showbabtxt);
		else {
			if (H >= 0 && H <= 13) {
				views.setTextViewText(R.id.showbab, "<" + M + "/" + D
						+ "/ " + "����>\n" + showbabtxt);
			} else {
				views.setTextViewText(R.id.showbab, "<" + M + "/" + D
						+ "/ " + "����>\n" + showbabtxt);
			}
		}
		Intent intent = new Intent();
		intent.addCategory(Intent.CATEGORY_BROWSABLE);
		intent.setComponent(new ComponentName("com.ATeam.HangaramAPP",
				"com.ATeam.HangaramAPP.Today_meal"));

		PendingIntent pendingintent = PendingIntent.getActivity(context, 0,
				intent, 0);
		views.setOnClickPendingIntent(R.id.showbab, pendingintent);

		appWidgetManager.updateAppWidget(appWidgetId, views);

	}

	public class LoadingParsing extends AsyncTask<Void, Void, Void> {

		protected void onCancelled() {
			super.onCancelled();
		}

		@Override
		protected void onPreExecute() {
			Log.i("Net", "[����]AsyncTask ���� - ���̾�α� ����");

		}

		@Override
		protected void onPostExecute(Void result) {
			Log.i("Net", "[����]AsyncTask ���� - ���̾�α� ����");

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
			BabParse updater = new BabParse(mcontext);

			updater.parse(Y, M, true);

			// mProgressDialog.dismiss();
			// TODO Auto-generated method stub
			return null;
/*			Calendar calendar = Calendar.getInstance();
			int Y, M, D, recdate;
			Y = calendar.get(Calendar.YEAR);
			M = calendar.get(Calendar.MONTH);
			M++;
			D = calendar.get(Calendar.DAY_OF_MONTH);
			String todate = null;
			todate = Integer.toString(Y * 10000 + (M) * 100 + D);

			DbAdapter myHelper = null;
			myHelper = new DbAdapter(mcontext);

			String pdate, plunch, pdinner;
			pdate = "NP";

			myHelper.open("READ");
			Cursor cursor = myHelper.fetchd("bab");
			int cnt = cursor.getCount();
			if (myHelper.getid("bab", "isbabcheck").equals("nodata") == true) {
				recdate = 0;
			} else {
				recdate = Integer.valueOf(myHelper.getid("bab", "recdate"));
			}
			myHelper.close();
			myHelper.open("WRITE");
			try {
				// Log.i("Net", "bab ���̺� �ֱ� ���� ��¥ : " + recdate);
				URL url = new URL("http://bluepeal.raonnet.com/sch.xml");

				XmlPullParserFactory parserCreator = XmlPullParserFactory
						.newInstance();
				XmlPullParser parser = parserCreator.newPullParser();

				parser.setInput(url.openStream(), null);

				int parserEvent = parser.getEventType();
				while (parserEvent != XmlPullParser.END_DOCUMENT) {
					if (parserEvent == XmlPullParser.START_TAG) {
						if (parser.getName().equals("inf")) {
							pdate = parser.getAttributeValue(null, "date");
							plunch = parser.getAttributeValue(null, "lunch");
							pdinner = parser.getAttributeValue(null, "dinner");
							// row name = pdate+.lunch or pdata.dinner
							if (plunch.equals("NULL") != true) {
								if (Integer.valueOf(pdate) > Integer
										.valueOf(recdate)) {
									myHelper.insertd("bab", pdate + ".lunch",
											plunch);
									myHelper.insertd("bab", pdate + ".dinner",
											pdinner);
								}
							}
						}

					} else if (parser.getEventType() == XmlPullParser.TEXT) {

					}
					parserEvent = parser.next();
				}
			} catch (Exception e) {
				// ����
			}

			myHelper.close();
			myHelper.open("WRITE");
			Log.i("Net", "���� �غ���");
			cursor = myHelper.fetchd("bab");
			Log.i("Net", "bab ���� ����");
			cursor.moveToFirst();
			Log.i("Net", "Ŀ���ʱ�ȭ");
			int i = 1;
			boolean flag = false;
			do {
				if (cursor.getString(1).equals("recdate") == true) {
					Log.i("Net", i + "��° ���� Ŭ����, recdate");

					myHelper.update("bab", i, "recdate", pdate);
				} else if (cursor.getString(1).equals("isbabcheck") == true) {
					Log.i("Net", i + "��° ���� Ŭ����, isbabcheck");
					myHelper.update("bab", i, "isbabcheck", "true");
					flag = true;
				}

				i++;
			} while (cursor.moveToNext());

			if (flag == false) {
				myHelper.insertd("bab", "recdate", pdate);
				myHelper.insertd("bab", "isbabcheck", "true");
			}

			myHelper.close();

			// mProgressDialog.dismiss();
			// TODO Auto-generated method stub
			return null;
			*/
		}

	}

	public void publishshowbab() {

		NetStatCHK();
		Calendar calendar = Calendar.getInstance();

		Y = calendar.get(Calendar.YEAR);
		M = calendar.get(Calendar.MONTH);
		D = calendar.get(Calendar.DAY_OF_MONTH);
		M++;
		String strdate = Integer.toString(Y * 10000 + (M) * 100 + D);
		;
		DbAdapter myHelper = null;
		myHelper = new DbAdapter(mcontext);

		myHelper.open("READ");

		Cursor cursor = myHelper.fetchd("bab");
		int cnt = cursor.getCount();
		boolean Isfinddata = false;
		Log.i("Net", "����] " + cnt + "���� DB �� �����Ѵ�.");
		cursor.moveToFirst();
		for (int i = 0; i < cnt; i++) {
			Log.i("Net", "����] " + cursor.getString(1));
			if (H >= 0 && H <= 13) {
				if (cursor.getString(1).equals(strdate + ".lunch")) {
					showbabtxt = cursor.getString(2);
					Isfinddata = true;
					break;
				}
			} else {
				if (cursor.getString(1).equals(strdate + ".dinner")) {
					showbabtxt = cursor.getString(2);
					Isfinddata = true;
					break;
				}

			}
			cursor.moveToNext();
		}
		myHelper.close();

		if (Isfinddata == false) {

			if (getYI(Y, M, D) == 0 || getYI(Y, M, D) == 6) {
			showbabtxt = "������ �����Դϴ�.";
			return;
			}
			if (isConnected == false) {
			isError = true;
			showbabtxt = "��Ʈ��ũ�� ����Ǿ� ���� �ʽ��ϴ�. 30�еڿ� ��õ� �˴ϴ�.";
			return;
			}

			isError = true;
			showbabtxt = "�޽� ������ �������� �ʽ��ϴ�. �޽� ������Ʈ�� �����մϴ�. ��ø� ��ٷ��ּ���.";
			new LoadingParsing().execute();
			return;
			}

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

	public void NetStatCHK() {

		int IsAPhone = 0;
		
		ConnectivityManager manager = (ConnectivityManager) mcontext
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo mobile = manager
				.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		NetworkInfo wifi = manager
				.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

		Log.i("Net", "isConnected�� " + isConnected);

		try {

			if (mobile != null) {
				if (mobile.isConnected() || wifi.isConnected()) {
					isConnected = true;
				} else {
					isConnected = false;
				}
				IsAPhone = 1;
			}
		} catch (Exception e) {
		}

	}

}

/*
 * . OnUpdate() : ������ ����ڰ� ������ �ð��� �Ǿ� �ڵ����� ������Ʈ �Ǵ� ��쿡 ȣ��ǰų� ������ ������Ʈ �ؾ��ϴ� ��찡
 * �߻��� �� ȣ��˴ϴ�. 2. onDelete() : ������ ����ȭ�鿡�� ������ �� ȣ��˴ϴ�. 3. onEnabled() :
 * HOST(����ȭ��)�� ������ ó�� �߰��� ��� ȣ��˴ϴ�. �����ͺ��̽��� ���ų� �ٸ� �߰� �۾��� ����� �ϴ� ��� �̰��� �����մϴ�.
 * 4. onDisabled() : ����ȭ�鿡�� ������ ������ ������ ��ġ�Ǿ� �ִٰ� �ϸ�, �� �� ���� ������ ������ ������ �� ȣ��˴ϴ�.
 * 5. onReceive() : ����ȭ�鿡 �ִ� ��� ������ �̺�Ʈ�� �����մϴ�.
 */