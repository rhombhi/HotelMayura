package com.hotelmayura;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.hotelmayura.database.DatabaseAdapter;

public class ReviewsMain extends Activity
{	
	private final Context CONTEXT = this; 

	private AlertDialog.Builder reviewsAlert;
	private ListView reviewsList;
	private Button submit;
    DatabaseAdapter dbAdapter = new DatabaseAdapter(CONTEXT);
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reviews_main);
        
        
        reviewsAlert = new AlertDialog.Builder(CONTEXT);
        reviewsList = (ListView)findViewById(R.id.reviews_list);
        submit = (Button) findViewById(R.id.submit_new);

//      dbAdapter.close();
        
        reviewsList.setOnItemClickListener(new OnItemClickListener()
        {
			@Override
			public void onItemClick(AdapterView<?> adapview, View view, int position, long id) 
			{
		        dbAdapter.open();
		        final Cursor c = dbAdapter.fetchRows("Reviews", new String[]{"_id","name","ambience","qos","food","comments"}, null, null);
		        
		        int[] to = {R.id.reviewer_name};
		        String[] from = {"name"}; 
		        
		        ReviewsListAdapter r = new ReviewsListAdapter(CONTEXT, R.id.reviews_list, c, from, to);
		        reviewsList.setAdapter(r);
		        
		        while(c.moveToNext())
		        	Log.v(this.getClass().getSimpleName()+"--", "on: "+c.getString(c.getColumnIndex("name")));

		        c.moveToPosition(position);
				String s = "Ambience: "+c.getString(c.getColumnIndex("ambience")) +"\n" + "Quality of Service: "+c.getString(c.getColumnIndex("qos")) +"\n" +"Food: "+c.getString(c.getColumnIndex("food")) +"\n" +"Comments: "+c.getString(c.getColumnIndex("comments")) +"\n";
				
				reviewsAlert.setTitle(""+c.getString(c.getColumnIndexOrThrow("name"))+"'s Review")
							.setMessage(s)
							.setPositiveButton("OK", new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface arg0, int arg1) 
								{
									
								}
							});
				reviewsAlert.show();
			}
		});
        
        submit.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View arg0) 
			{
				Intent reviewsIntent = new Intent(CONTEXT, Reviews.class);
				startActivity(reviewsIntent);
			}
		});
 
        
    }

	@Override
	public void onResume() 
	{
		super.onResume();
		if(dbAdapter!=null)
		{
			dbAdapter.open();
			final Cursor c = dbAdapter.fetchRows("Reviews", new String[]{"_id","name","ambience","qos","food","comments"}, null, null);

			int[] to = {R.id.reviewer_name};
			String[] from = {"name"}; 
			ReviewsListAdapter r = new ReviewsListAdapter(CONTEXT, R.id.reviews_list, c, from, to);
			reviewsList.setAdapter(r);
		}
	}
}