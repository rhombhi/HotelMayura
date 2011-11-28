package com.hotelmayura;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.hotelmayura.database.Columns;
import com.hotelmayura.database.DatabaseAdapter;

public class Splashscreen extends Activity 
{
	private Context CONTEXT = this;
	private Handler handler = new Handler();
	
	private boolean shouldResume=false;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        
        DatabaseAdapter dbAdapter = new DatabaseAdapter(CONTEXT);
        
    	dbAdapter.open();

		String[] tableNames={"Reviews"};
		
		String[][] names = new String[tableNames.length][];
		String[][] types = new String[tableNames.length][];
		String[][] constraints = new String[tableNames.length][];
		
		names[0] = new String[]{"_id","name", "ambience", "qos", "food", "comments"};
		types[0] = new String[]{"integer","text","integer","integer","integer","text"};
		constraints[0] = new String[]{"primary key", "", "", "", "", ""};

		Columns[][] members=new Columns[tableNames.length][];
		for(int i=0;i<tableNames.length;i++)
		{
			members[i]= new Columns[types[i].length];
			for(int j =0;j<types[i].length;j++)
			{
//				Log.v(this.getClass().getSimpleName()+"--", "i="+i+"..j="+j);
				members[i][j]=new Columns(names[i][j],types[i][j],constraints[i][j]);
				Log.v(this.getClass().getSimpleName()+"--", i+".."+j+".."+members[i][j].name+members[i][j].type+members[i][j].constraint);
			}
		}
		dbAdapter.create(tableNames, members);
		dbAdapter.close();        
        handler.postDelayed(exitSplashScreen, 2000);
    }
    
	private Runnable exitSplashScreen = new Runnable() 
	{
		public void run() 
		{
			Intent dashBoardIntent = new Intent(CONTEXT, Dashboard.class);
			startActivity(dashBoardIntent);
		}
	};

	@Override
	protected void onResume() 
	{
		super.onResume();
		
		if(shouldResume)
	        handler.postDelayed(exitSplashScreen, 3000);

		shouldResume=true;
	}

	@Override
	public void onBackPressed() 
	{
		super.onBackPressed();
		handler.removeCallbacks(exitSplashScreen);
	}

	
	
}