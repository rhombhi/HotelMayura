package com.hotelmayura;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splashscreen extends Activity 
{
	private Context CONTEXT = this;
	private Handler handler = new Handler();
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        
        handler.postDelayed(exitSplashScreen, 3000);
    }
    
	private Runnable exitSplashScreen = new Runnable() 
	{
		public void run() 
		{
			Intent dashBoardIntent = new Intent(CONTEXT, Dashboard.class);
			startActivity(dashBoardIntent);
		}
	};

}