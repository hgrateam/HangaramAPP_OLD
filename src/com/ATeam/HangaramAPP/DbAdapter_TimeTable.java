package com.ATeam.HangaramAPP;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbAdapter_TimeTable {
	
	
	
		// ������

		private SQLiteDatabase mdb;
		private Context mcontext;
		private DBopenhelper mdbhelper;

		public DbAdapter_TimeTable(Context context) {
			this.mcontext = context;
		}

		private static class DBopenhelper extends SQLiteOpenHelper {
			DBopenhelper(Context context) {
				// ����Ʈ��, DB����, Ŀ����Ŀ��(ǥ��Ŀ�� null), ����
				super(context, "HGRAPP_TimeTable.db", null, 1);
			}

			// DB�� ó�� ����� ����
			@Override
			public void onCreate(SQLiteDatabase db) {
				/*
				 * Log.i("Net", "���̺� ����!");
				 * db.execSQL("CREATE TABLE IF NOT EXISTS config " +
				 * "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
				 * "name TEXT, tf TEXT);");
				 */}

			@Override
			// �̹������ϴ� DB�� ���׷��̵�
			public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
				/*
				 * Log.i("Net", "���׷��̵�!");
				 * db.execSQL("DROP TABLE IF EXISTS config"); onCreate(db);
				 */}
		}

		public DbAdapter_TimeTable open(String a) throws SQLException {
			mdbhelper = new DBopenhelper(mcontext);
			if (mdb != null)
				mdb.close();

			if (a.equals("READ") == true) {
				mdb = mdbhelper.getReadableDatabase();
			} else if (a.equals("WRITE") == true) {
				mdb = mdbhelper.getWritableDatabase();
			}
			return this;
		}

		public long insertd(String table, 
							String weekofday,
							String period1, 
							String period2, 
							String period3, 
							String period4, 
							String period5, 
							String period6){
			
			ContentValues values = new ContentValues();
			values.put("WeekOfDay", weekofday);
			values.put("Period1", period1);
			values.put("Period2", period2);
			values.put("Period3", period3);
			values.put("Period4", period4);
			values.put("Period5", period5);
			values.put("Period6", period6);
			return mdb.insert(table, null, values);

		}

		public void create(String table) {
			Log.i("Net", table + "���̺� ����!");
			mdb.execSQL("CREATE TABLE IF NOT EXISTS " + table
					+ " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "weekofday TEXT, Period1 TEXT, Period2 TEXT, Period3 TEXT, Period4 TEXT, Period5 TEXT, Period6 TEXT);");

			// �ʱ�ȭ
			Cursor cursor = mdb.query(table, null, null, null, null, null, null);

			if (cursor.getCount() != 7){
				insertd("TimeTable", "Sunday", "period1", "period2", "period3", "period4", "period5", "period6");
				insertd("TimeTable", "Monday", "period1", "period2", "period3", "period4", "period5", "period6");
				insertd("TimeTable", "Tuesday", "period1", "period2", "period3", "period4", "period5", "period6");
				insertd("TimeTable", "Wednesday", "period1", "period2", "period3", "period4", "period5", "period6");
				insertd("TimeTable", "Thursday", "period1", "period2", "period3", "period4", "period5", "period6");
				insertd("TimeTable", "Friday", "period1", "period2", "period3", "period4", "period5", "period6");
				insertd("TimeTable", "Saturday", "period1", "period2", "period3", "period4", "period5", "period6");
			}
			cursor.close();
		}

		public boolean deleted(String table, long rowId) {
			return mdb.delete(table, "_id=" + rowId, null) > 0;

		}

		public void deletetable(String table) {
			mdb.execSQL("drop table " + table);
			// return mdb.query("setting", null, null, null, null,
			// null, null);
		}

		public Cursor fetchd(String table) {
			return mdb.query(table, null, null, null, null, null, null);
		}

		public Cursor select(String table) {
			return mdb.rawQuery(table
					+ " name from sqlite_master WHERE type='table'", null);
		}

		public long update(String table, long rowId,
							  String weekofday,
							  String period1, 
							  String period2, 
							  String period3, 
							  String period4, 
							  String period5, 
							  String period6) {
			
			Log.i("Net", "���̺� " + table + " �� " + rowId + "��°  ����.");
			
			ContentValues args = new ContentValues();
			args.put("WeekOfDay", weekofday);
			args.put("Period1", period1);
			args.put("Period2", period2);
			args.put("Period3", period3);
			args.put("Period4", period4);
			args.put("Period5", period5);
			args.put("Period6", period6);

			return mdb.update(table, args, "_id=" + rowId, null);
		}

		public String getid(String table, String weekofday, int peroid) {
			// create(table);
			Cursor cursor = mdb.query(table, null, null, null, null, null, null);
			cursor.moveToFirst();

			if (cursor.getCount() == 0) {
				cursor.close();
				return "nodata";
			}
			do {
				if (cursor.getString(1).equals(weekofday) == true) {
					
					String s = cursor.getString(peroid + 1);
					cursor.close();
					return s;
				}
			} while (cursor.moveToNext());

			cursor.close();
			return "nodata";
		}

		public boolean isTableExists(String tableName) {
			Cursor cursor = mdb.rawQuery(
					"select DISTINCT tbl_name from sqlite_master where tbl_name = '"
							+ tableName + "'", null);
			if (cursor != null) {
				if (cursor.getCount() > 0) {
					return true;
				}
			}
			return false;
		}

		public boolean checktableinit(String table) {
			open("READ");
			Cursor csr_config = mdb.rawQuery("SELECT count(*) FROM " + table, null);
			csr_config.moveToFirst();
			int csr_cnt = csr_config.getInt(0);
			close();

			if (csr_cnt > 0)
				return false;
			return true;

			/*
			 * Log.i("Net", table+"�� ��� ���� : "+csr_config.getCount()); if
			 * (csr_config.getCount() == 0) return true;
			 * 
			 * return false;
			 */
		}

		// SQLiteDatabase �ڿ�����
		public void close() {
			mdb.close();
		}

	}

