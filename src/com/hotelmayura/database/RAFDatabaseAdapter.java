package com.hotelmayura.database;

import java.io.File;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class RAFDatabaseAdapter 
{
	private Context CONTEXT;
	private SQLiteDatabase database;
	private RAFDatabaseHelper dbHelper;
	
	private static final String DB_PATH="/data/data/com.directv.referafriend/databases/ReferAFriend";
	
	public RAFDatabaseAdapter(Context context) 
	{
		this.CONTEXT = context;
	}

	public RAFDatabaseAdapter open()
	{
		dbHelper = new RAFDatabaseHelper(CONTEXT);
		database = dbHelper.getWritableDatabase();
		return this;
	}

	public RAFDatabaseAdapter create(String[] tableNames, Columns[][] members) throws SQLException 
	{
		dbHelper.createTables(tableNames, members, database);
		return this;
	}
	
	public void close() 
	{
		dbHelper.close();
	}
	
	public long createRow(String tableName, ContentValues values) 
	{
		return database.insert(tableName, null, values);
	}

	public long createRowOrThrow(String tableName, ContentValues values) 
	{
		return database.insertOrThrow(tableName, null, values);
	}

	public boolean updateRow(String tableName,ContentValues values, String where)
	{
		return database.update(tableName, values, where, null) > 0;
	}

	public boolean deleteRow(String tableName, String where) 
	{
		return database.delete(tableName, where, null) > 0;
	}

	public void deleteTable(String tableName) 
	{
		database.execSQL("DROP TABLE IF EXISTS " + tableName);
	}
	
	public void delete() 
	{
		database.delete("CircleFriends", null, null);
		database.delete("Circles", "name!='Friends' AND name!='Referred' AND name!='Ignored' AND name!='DIRECTV Friends'", null);
		database.delete("RecentActivity", null, null);
		database.delete("Accounts", null, null);
		database.delete("Friends", null, null);
		ContentValues cv = createContentValues("value","0");
		database.update("Profile", cv, "name='account_no'", null);
	}
	
	public Cursor fetchAllRows(String tableName, String[]colNames) 
	{
		return database.query(tableName, colNames, null, null, null, null, null);
	}
	//query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit)
	public Cursor fetchRows(String tableName, String[]colNames, String condition, String orderBy) 
	{
		return database.query(tableName, colNames, condition, null, null, null, orderBy);
	}

	public boolean databaseExists()
	{
		File dbFile = new File(DB_PATH );
		return dbFile.exists();
	}
	
	public ContentValues createContentValues( Object... args) 
	{
		ContentValues values = new ContentValues();
		for(int i=0;i<args.length;i=i+2)
			values.put(""+args[i], args[i+1].toString());
		return values;
	}

}
