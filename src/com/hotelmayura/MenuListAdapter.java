package com.hotelmayura;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class MenuListAdapter extends ArrayAdapter<String>
{
	private String[] titles;
	private Drawable[] icons;
	
	public MenuListAdapter(Context context, int resource, int textViewResourceId, String []titles, Drawable[] icons) 
	{
		super(context, resource, textViewResourceId, titles);
		this.titles = titles;
		this.icons=icons;
	}


	@Override
    public View getView(int position, View convertView, ViewGroup parent) 
    {
        LayoutInflater inflater = ((Activity)parent.getContext()).getLayoutInflater();
        View row;

        row= inflater.inflate(R.layout.menu_list_layout, parent, false);
        
        Button itemPicture = (Button) row.findViewById(R.id.item_pic);
        itemPicture.setBackgroundDrawable(icons[position]);
        
        TextView itemName = (TextView) row.findViewById(R.id.item_name);
        itemName.setText(titles[position]);
        
        
		return row;
    }        
}
