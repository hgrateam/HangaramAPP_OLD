package com.ATeam.HangaramAPP;

import android.util.Log;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// �߻�Ŭ���� android.database.sqlite.SQLiteOpenHelper ���
public class DbAdapter {
	// ������

	private SQLiteDatabase mdb;
	private Context mcontext;
	private DBopenhelper mdbhelper;

	public DbAdapter(Context context) {
		this.mcontext = context;
	}

	private static class DBopenhelper extends SQLiteOpenHelper {
		DBopenhelper(Context context) {
			// ����Ʈ��, DB����, Ŀ����Ŀ��(ǥ��Ŀ�� null), ����
			super(context, "HGRAPP.db", null, 1);
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

	public DbAdapter open(String a) throws SQLException {
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

	public long insertd(String table, String name, String tf) {
		Log.i("Net", "���̺� " + table + " �� " + name + " / " + tf + "�� �߰��Ͽ����ϴ�.");
		ContentValues values = new ContentValues();
		values.put("tf", tf);
		values.put("name", name);
		return mdb.insert(table, null, values);

	}

	public void create(String table) {
		Log.i("Net", table + "���̺� ����!");
		mdb.execSQL("CREATE TABLE IF NOT EXISTS " + table
				+ " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "name TEXT, tf TEXT);");

		Cursor cursor = mdb.query(table, null, null, null, null, null, null);
		
		// �ʱ�ȭ
		if (table.equals("config") == true) {
			insertd("config", "ISNOTICEUPDATE", "true");
			insertd("config", "ISFIRSTHELP", "true");
			insertd("config", "themeSet", "default");
		}
		if (table.equals("timeTableLock") == true) {
			if (cursor.getCount() != 1){
			insertd("timeTableLock", "isTimeTableLocked", "false");
			}
		}
		if (table.equals("note") == true) {
			if (cursor.getCount() != 1){
			insertd("note", "noteText", "�޸� �Է��ϼ���.");
			}
		}
		
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

	public boolean update(String table, long rowId, String name, String tf) {
		Log.i("Net", "���̺� " + table + " �� " + rowId + "��° �� ������ " + name
				+ "���� " + tf + "�� �ٲپ����ϴ�.");
		ContentValues args = new ContentValues();
		args.put("tf", tf);
		args.put("name", name);

		return mdb.update(table, args, "_id=" + rowId, null) > 0;
	}

	public String getid(String table, String name) {
		// create(table);
		Cursor cursor = mdb.query(table, null, null, null, null, null, null);
		cursor.moveToFirst();

		if (cursor.getCount() == 0) {
			return "nodata";
		}
		do {
			if (cursor.getString(1).equals(name) == true) {
				return cursor.getString(2);
			}
		} while (cursor.moveToNext());

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