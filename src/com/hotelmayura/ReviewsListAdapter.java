package com.hotelmayura;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ReviewsListAdapter extends SimpleCursorAdapter
{
	Cursor c=null;
	
	public ReviewsListAdapter(Context context, int layout, Cursor c, String[] from, int[] to) 
	{
		super(context, layout, c, from, to);
		this.c = c;
	}


	@Override
    public View getView(int position, View convertView, ViewGroup parent) 
    {
        LayoutInflater inflater = ((Activity)parent.getContext()).getLayoutInflater();
        View row;

        row= inflater.inflate(R.layout.reviews_list_layout, parent, false);
        
        c.moveToPosition(position);
        
        TextView review_number = (TextView) row.findViewById(R.id.review_no);
        review_number.setText("Review " + (position+1));
        
        TextView reviewerName = (TextView) row.findViewById(R.id.reviewer_name);
        reviewerName.setText("- "+c.getString(c.getColumnIndex("name")));
        
        
		return row;
    }        
}
