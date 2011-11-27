package com.hotelmayura;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import com.hotelmayura.database.DatabaseAdapter;

public class ReviewsMain extends Activity
{	
	private final Context CONTEXT = this; 
	private ListView reviewsList;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reviews_main);
        
        DatabaseAdapter dbAdapter = new DatabaseAdapter(CONTEXT);
        
        reviewsList = (ListView)findViewById(R.id.reviews_list);

        dbAdapter.open();
        Cursor c = dbAdapter.fetchRows("Reviews", new String[]{"_id","name"}, null, null);
        dbAdapter.close();
        
        int[] to = {R.id.reviewer_name};
        String[] from = {"name"}; 
        
        ReviewsListAdapter r = new ReviewsListAdapter(CONTEXT, R.id.reviews_list, c, from, to);
        reviewsList.setAdapter(r);
        
        
    }
}