package com.ex.HangaramAPP;

import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

public class Main<CustomDialogActivity> extends Activity {

	public ViewPager mPager;
	public String ptitle, ptext;
	
	private OnClickListener mBTN_viewnotice = new OnClickListener() {
		public void onClick(View v) {
			// 노티스 보여주기
			
			AlertDialog.Builder ab=new AlertDialog.Builder(Main.this);
			    ab.setMessage(ptext);
			        ab.setPositiveButton("확인", null);
			        ab.show();

		}
	};

	private OnClickListener mBTN_toPrincipleWall = new OnClickListener() {
		public void onClick(View v) {
			startActivity(new Intent(Intent.ACTION_VIEW,
					Uri.parse("https://www.facebook.com/sanjinii")));
		}
	};
	private OnClickListener mBTN_toHGR_15th = new OnClickListener() {
		public void onClick(View v) {
			startActivity(new Intent(Intent.ACTION_VIEW,
					Uri.parse("http://www.facebook.com/groups/hangaram15th/")));
		}
	};
	private OnClickListener mBTN_toHGR = new OnClickListener() {
		public void onClick(View v) {
			startActivity(new Intent(Intent.ACTION_VIEW,
					Uri.parse("http://www.hangaram.hs.kr/")));
		}
	};
	private OnClickListener mBTN_toHGRency = new OnClickListener() {
		public void onClick(View v) {
			startActivity(new Intent(Intent.ACTION_VIEW,
					Uri.parse("https://www.facebook.com/hangarampedia")));
		}
	};
	private OnClickListener mBTN_todayMeal = new OnClickListener() {
		public void onClick(View v) {
			startActivity(new Intent(Main.this, Parsing.class));
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewpager_main);

		mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(new mainPagerAdapter(getApplicationContext()));
	}

	private class mainPagerAdapter extends PagerAdapter {

		private LayoutInflater mInflater;

		public mainPagerAdapter(Context con) {
			super();
			mInflater = LayoutInflater.from(con);

		}

		@Override
		public int getCount() {
			return 2;
		}

		@Override
		public Object instantiateItem(View pager, int position) {
			View v = null;
			if (position == 0) {
				
				
				
				v = mInflater.inflate(R.layout.main, null);
				// 공지사항을 파싱해 온다
				v.findViewById(R.id.noticebutton).setOnClickListener(mBTN_viewnotice);
				
				try {
					URL url = new URL("http://bluepeal.raonnet.com/inf.xml");
					Log.i("Net", "파싱 시작");
					XmlPullParserFactory parserCreator = XmlPullParserFactory
							.newInstance();
					XmlPullParser parser = parserCreator.newPullParser();

					parser.setInput(url.openStream(), null);

					int parserEvent = parser.getEventType();
					while (parserEvent != XmlPullParser.END_DOCUMENT) {
						if (parserEvent == XmlPullParser.START_TAG) {
							if (parser.getName().equals("notice")) {
								ptitle = parser.getAttributeValue(null,
										"title");
								ptext = parser.getAttributeValue(null,
										"text");
								Log.i("Net", "공지사항을 찾음ㅋ" + ptitle);
								TextView nv = (TextView) v
										.findViewById(R.id.noticeview);
								nv.setText(ptitle);

							}
						} else if (parser.getEventType() == XmlPullParser.TEXT) {
							Log.i("Net", "서버가삐짐ㅋ");
						}
						parserEvent = parser.next();
					}
				} catch (Exception e) {
					// 안됨ㅋ
				}

			} else {
				v = mInflater.inflate(R.layout.metro_view_menu, null);
				v.findViewById(R.id.toPrincipleWall).setOnClickListener(
						mBTN_toPrincipleWall);
				v.findViewById(R.id.HGR_15th).setOnClickListener(
						mBTN_toHGR_15th);
				v.findViewById(R.id.toHGR).setOnClickListener(mBTN_toHGR);
				v.findViewById(R.id.toHGRency).setOnClickListener(
						mBTN_toHGRency);
				v.findViewById(R.id.todayMeal).setOnClickListener(
						mBTN_todayMeal);
			}
			((ViewPager) pager).addView(v, 0);

			return v;
		}

		@Override
		public void destroyItem(View pager, int position, Object view) {
			((ViewPager) pager).removeView((View) view);
		}

		@Override
		public boolean isViewFromObject(View view, Object obj) {
			// TODO Auto-generated method stub
			return view == obj;
		}

	}

	// 여기서부터 옵션메뉴 관련 내용
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		createMenu(menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return applyMenuChoice(item) || super.onOptionsItemSelected(item);
	}

	private void createMenu(Menu menu) {
		menu.add(0, 1, 0, "개발팀 정보");
		menu.add(0, 2, 0, "옵션");
		menu.add(0, 3, 0, "도움말");
		menu.add(0, 4, 0, "업데이트 확인");
	}

	private boolean applyMenuChoice(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			startActivity(new Intent(this, Devteam_info.class));
			finish();
			overridePendingTransition(R.anim.bottom_to_top_in,
					R.anim.bottom_to_top_out);
			return true;
			/*
		case 2:
			startActivity(new Intent(this, Option.class));
			finish();
			overridePendingTransition(R.anim.bottom_to_top_in,
					R.anim.bottom_to_top_out);
			return true;
*/
		case 4:
			startActivity(new Intent(this, chk_UPDATE.class));
			return true;
		}
		return false;
	}
}