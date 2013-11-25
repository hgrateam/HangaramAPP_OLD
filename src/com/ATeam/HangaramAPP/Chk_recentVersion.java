package com.ATeam.HangaramAPP;

import java.net.URL;

import org.holoeverywhere.app.AlertDialog;
import org.holoeverywhere.widget.Toast;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.ATeam.HangaramAPP.Today_meal.LoadingParsing;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class Chk_recentVersion {
	Toast mToast;
	//boolean isConnected;
	public static String ptitle;
	//int IsAPhone = 0;
	private Context mContext;
	static String pmessage = null;
	
	// BLUR ȿ��
	
	public Chk_recentVersion(Context context){
		
		this.mContext = context;
	}
	
	
	public Chk_recentVersion ChkNotice(boolean isConnected, int IsAPhone) {
		Log.i("Net","ChkNotice()�� ����ƴ粲?");
		//new Handler();

		DbAdapter myHelper;
		myHelper = new DbAdapter(mContext);

		myHelper.open("WRITE");
		myHelper.create("version_check");
		myHelper.close();

		String nowversion =  mContext.getString(R.string.$app_ver);
		myHelper.open("READ");
		String finalversion = myHelper.getid("version_check", "versionid");
		myHelper.close();
		// ó������ ����Ǿ���.

		if (finalversion.equals("nodata") == true) {

			myHelper.open("WRITE");
			myHelper.update("version_check", 1, "versionid", nowversion);
			myHelper.close();
		} else {
			if (finalversion.equals(nowversion) != true) {
				showToast("���� ���� " + finalversion + "���� " + nowversion
						+ " ���� ���� �Ǿ����ϴ�.");
			}
			myHelper.open("WRITE");
			Log.i("Net", "���� �غ���");
			Cursor cursor = myHelper.fetchd("version_check");
			Log.i("Net", "version_check ���� ����");
			cursor.moveToFirst();
			Log.i("Net", "Ŀ���ʱ�ȭ");
			int i = 1;
			boolean flag = false;
			do {
				if (cursor.getString(1).equals(finalversion) == true) {
					myHelper.update("version_check", i, "versionid", nowversion);
					break;
				}
				i++;
			} while (cursor.moveToNext());
			myHelper.close();
		}
		if (isConnected == true || IsAPhone == 0) {
		
		//new noticeGetter().execute();
			checknotice();
			Try(mContext);
		
		} else {
			ptitle = mContext.getString(R.string.NetStat_error);
			
		}
		return this;
		
		
		
	}

	public void showToast(String str) {
		if (mToast == null) {
			mToast = Toast.makeText(mContext, str,
					Toast.LENGTH_SHORT);
		} else {
			mToast.setText(str);
		}
		mToast.show();

	}
	

	
	public void checknotice() {
		
			try {
				URL url = new URL("http://bluepeal.raonnet.com/inf.xml");
				Log.i("Net", "�Ľ� ����");
				XmlPullParserFactory parserCreator = XmlPullParserFactory
						.newInstance();
				XmlPullParser parser = parserCreator.newPullParser();

				parser.setInput(url.openStream(), null);

				int parserEvent = parser.getEventType();
				while (parserEvent != XmlPullParser.END_DOCUMENT) {
					if (parserEvent == XmlPullParser.START_TAG) {
						if (parser.getName().equals("notice")) {
							ptitle = parser.getAttributeValue(null, "title");

							Log.d("Net", "AsyncTask ���� - checknotice()����");
							

						}
					} else if (parser.getEventType() == XmlPullParser.TEXT) {
					}
					parserEvent = parser.next();
				}
			} catch (Exception e) {
				// �ȵʤ�
			}
		
		// ���������� �Ľ��� �´�
		Log.i("Net", "�������� : " + ptitle);
	}
	
	

	public void Try(Context con) {
		Log.i("Net","Try()�� ����ƴ粲?");
		try {
			URL url = new URL("http://bluepeal.raonnet.com/inf.xml");
			Log.i("Net", "�Ľ� ����");
			XmlPullParserFactory parserCreator = XmlPullParserFactory
					.newInstance();
			XmlPullParser parser = parserCreator.newPullParser();

			parser.setInput(url.openStream(), null);
			Log.i("Net","Try(try())�� ����ƴ粲?");
			int parserEvent = parser.getEventType();
			while (parserEvent != XmlPullParser.END_DOCUMENT) {

				if (parserEvent == XmlPullParser.START_TAG) {

					if (parser.getName().equals("inf")) {

						pmessage = parser.getAttributeValue(null,
								"message_new");
						
						pmessage = pmessage.replace("{","<");
						pmessage = pmessage.replace("}",">");
						pmessage = pmessage.replace("|",con.getResources().getString(R.string.mal));
						
						Log.i("Net", "pmessage��" +pmessage);
						
						/*
						
						AlertDialog.Builder ab=new AlertDialog.Builder(Chk_recentVersion.this);
					 	ab.setMessage(Html.fromHtml(pmessage));
					 		ab.setPositiveButton("Ȯ��", null);
							ab.setTitle("��������"); 
							ab.setIcon(R.drawable.ic_launcher);
					 		ab.show();
					*/
					}
				} else if (parser.getEventType() == XmlPullParser.TEXT) {
					// Toast toast = Toast.makeText(this, "������ �������� �ʽ��ϴ�",
					// Toast.LENGTH_SHORT);
					// toast.show();
					// Log.i("Net", "������������");
				}

				parserEvent = parser.next();
			}

		} catch (Exception e) {
			Log.i("Net", "�������� �������� ��Ʈ��ũ�� �����Ͻÿ� ��");
		}
		
		
		// �ȵʤ�
	}
}
