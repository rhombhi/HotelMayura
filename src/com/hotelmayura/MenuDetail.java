package com.hotelmayura;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

public class MenuDetail extends Activity 
{
	private Context CONTEXT = this;
	private ListView menuDetailList;
	private TextView title;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_detail);
     
        title = (TextView)findViewById(R.id.menu_detail_title);
        menuDetailList = (ListView) findViewById(R.id.menu_detail_list);

        
        String itemName = ((Activity) CONTEXT).getIntent().getExtras().getString("itemName");
        Log.v(CONTEXT.getClass().getSimpleName()+"--","tiem name:"+itemName);
        title.setText(itemName);
        
        Resources res = getResources();

        TypedArray dItems = res.obtainTypedArray(R.array.appetizers_items);
        String items[]= new String[dItems.length()];
        for(int i=0;i<dItems.length();i++)
        	items[i]=dItems.getString(i);

        TypedArray dDescription = res.obtainTypedArray(R.array.appetizers_description);
        String description[]= new String[dDescription.length()];
        for(int i=0;i<dDescription.length();i++)
        	description[i]=dDescription.getString(i);

        TypedArray dPrices = res.obtainTypedArray(R.array.appetizers_prices);
        String prices[]= new String[dPrices.length()];
        for(int i=0;i<dPrices.length();i++)
        	prices[i]=dPrices.getString(i);

//        int icons[]= res.getIntArray(R.array.menu_items_drawables);
        
        MenuDetailListAdapter m = new MenuDetailListAdapter(CONTEXT, R.layout.menu_detail_list_layout, R.id.item_name, items, description, prices);
        menuDetailList.setAdapter(m);

    }
}