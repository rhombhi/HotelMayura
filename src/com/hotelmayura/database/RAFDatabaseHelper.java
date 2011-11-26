package com.hotelmayura.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class RAFDatabaseHelper extends SQLiteOpenHelper 
{
	private static final String DATABASE_NAME = "ReferAFriend";

	private static final int DATABASE_VERSION = 1;
	
//	private static final String PERSON_TABLE_NAME = "Person";
//	private static final String CONTACT_TABLE_NAME = "Contact";
//
//	private static final String PERSON_TABLE_CREATE = "create table "+PERSON_TABLE_NAME+" (_id integer primary key autoincrement, " + "name text not null, status integer not null, sum_times integer not null);";
//	private static final String CONTACT_TABLE_CREATE = "create table "+CONTACT_TABLE_NAME+" (_id integer primary key , " + "name text not null, times integer not null);";
	
	private String[] tableNames;
	public RAFDatabaseHelper(Context context, String[] tableNames, Columns[][] members) 
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.tableNames=tableNames;
	}
	public RAFDatabaseHelper(Context context) 
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) 
	{
		Log.v("","-->>"+database.getPath());
//		createTables(tableNames, members, database);
	}

	public void createTables(String[] tableNames, Columns[][] members, SQLiteDatabase database)
	{
		for(int i=0; i<tableNames.length; i++)
		{
			String tableCreate = "create table if not exists "+tableNames[i]+" ("+members[i][0].name + " " + members[i][0].type+" " + members[i][0].constraint + " autoincrement, ";
			int j;
			for(j=1;j<members[i].length-1;j++)
				tableCreate+=  members[i][j].name +" " + members[i][j].type + " " + members[i][j].constraint +", ";
			tableCreate+= members[i][j].name +" " + members[i][j].type + " " + members[i][j].constraint+") ";
			Log.v(this.getClass().getSimpleName()+"--",""+tableCreate);
			database.execSQL(tableCreate);
		}
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion,int newVersion) 
	{
		Log.w(RAFDatabaseHelper.class.getName(), "Upgrading database from version " + oldVersion + " to "+ newVersion + ", which will destroy all old data");
		for(int i=0;i<tableNames.length;i++)
			database.execSQL("DROP TABLE IF EXISTS "+tableNames[i]);
		onCreate(database);
	}
	
	public void deleteDatabase(Context context)
	{
		context.deleteDatabase(DATABASE_NAME);
	}
}
