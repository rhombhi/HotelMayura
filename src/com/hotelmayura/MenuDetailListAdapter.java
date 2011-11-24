package com.hotelmayura;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class MenuDetailListAdapter extends ArrayAdapter<String>
{

	private Context CONTEXT;
	private String[] titles;
	private String[] description;
	private String[] prices;
	
	public MenuDetailListAdapter(Context context, int resource, int textViewResourceId, String []titles, String []description, String []prices) 
	{
		super(context, resource, textViewResourceId, titles);
		this.CONTEXT=context;
		this.titles = titles;
		this.description = description;
		this.prices = prices;
	}


	@Override
    public View getView(int position, View convertView, ViewGroup parent) 
    {
        LayoutInflater inflater = ((Activity)parent.getContext()).getLayoutInflater();
        View row;

        row= inflater.inflate(R.layout.menu_detail_list_layout, parent, false);
        
        String in=titles[position].toLowerCase();
        in=in.replace(" ", "_").replace("(", "").replace(")", "").replace(",", "");
        Log.v(CONTEXT.getClass().getSimpleName()+"--","in:"+in);
        
        Resources res = CONTEXT.getResources();

        int drawableId = res.getIdentifier(in, "drawable", "com.hotelmayura");
        
        Button itemPicture = (Button) row.findViewById(R.id.detail_item_pic);
        itemPicture.setBackgroundResource(drawableId);
        
        TextView itemName = (TextView) row.findViewById(R.id.detail_item_name);
        itemName.setText(titles[position]);
        
        TextView itemDescription = (TextView) row.findViewById(R.id.detail_item_description);
        itemDescription.setText(description[position]);
        
        TextView itemPrice = (TextView) row.findViewById(R.id.detail_item_price);
        itemPrice.setText(prices[position]);
        
		return row;
    }        
}
