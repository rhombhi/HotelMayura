package com.hotelmayura;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

public class Dashboard extends Activity 
{
	private Context CONTEXT = this;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        
        Integer[] mThumbIds = {
        		R.drawable.menu, R.drawable.contact_us,
        		R.drawable.about_us, R.drawable.survey
        };

        GridView gridview = (GridView) findViewById(R.id.dashboard_gridview);
        ImageAdapter i = new ImageAdapter(this);
        i.setmThumbIds(mThumbIds);
        gridview.setAdapter(i);

        gridview.setOnItemClickListener(new OnItemClickListener() 
        {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int index, long arg3) 
			{
				switch(index)
				{
				case 0:
					Intent menuIntent = new Intent(CONTEXT, Menu.class);
					startActivity(menuIntent);
					break;
				case 1:
					Intent contactUsIntent = new Intent(CONTEXT, ContactUsTabs.class);
					startActivity(contactUsIntent);
					break;
				case 2:
					Intent aboutUsIntent = new Intent(CONTEXT, AboutUs.class);
					startActivity(aboutUsIntent);
					break;
				case 3:
					Intent reviewsIntent = new Intent(CONTEXT, ReviewsMain.class);
					startActivity(reviewsIntent);
					break;
				default:
					Log.v(CONTEXT.getClass().getSimpleName()+"--", ""+index);
					break;
				}
		    }
        });

    }
}