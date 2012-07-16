package com.Ateam.HangaramAPP;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
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
			super(context, "Setting2.db", null, 1);
		}

		// DB�� ó�� ����� ����
		@Override
		public void onCreate(SQLiteDatabase db) {
			Log.i("Net","���̺� ����!");
			db.execSQL("CREATE TABLE setting "
					+ "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "name TEXT, tf TEXT);");
		}

		@Override
		// �̹������ϴ� DB�� ���׷��̵�
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.i("Net","���׷��̵�!");
			db.execSQL("DROP TABLE IF EXISTS setting");
			onCreate(db);
		}
	}

	public DbAdapter open(String a) throws SQLException {
		mdbhelper = new DBopenhelper(mcontext);
		if(a.equals("READ")==true){
			mdb = mdbhelper.getReadableDatabase();
		}
		else if(a.equals("WRITE")==true){
			mdb = mdbhelper.getWritableDatabase();
		}
		return this;
	}

	public long insertd(String tf, String name) {
		ContentValues values = new ContentValues();
		values.put("tf", tf);
		values.put("name", name);
		Log.i("Net","���� �־���");
		return mdb.insert("setting", null, values);

	}

	public boolean deleted(long rowId) {
		return mdb.delete("setting", "_id=" + rowId, null) > 0;

	}

	public Cursor fetchd() {
		return mdb.query("setting", null, null, null, null,
				null, null);
	}

	public boolean updated(long rowId, String tf,String name) {
		ContentValues args = new ContentValues();
		args.put("tf", tf);
		args.put("name", name);

		return mdb.update("setting", args, "_id=" + rowId, null) > 0;
	}

	// SQLiteDatabase �ڿ�����
	public void close() {
		mdb.close();
	}

}