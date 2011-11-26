package com.hotelmayura;

import com.hotelmayura.database.RAFDatabaseAdapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

public class ReviewsMain extends Activity
{	
	private final Context CONTEXT = this; 
	private ListView reviewsList;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reviews_main);
        
        RAFDatabaseAdapter dbAdapter = new RAFDatabaseAdapter(CONTEXT);
        
        reviewsList = (ListView)findViewById(R.id.reviews_list);

        dbAdapter.open();
        dbAdapter.fetchRows("Reviews", new String[]{"name"}, null, null);
        dbAdapter.close();
        
        
    }
}