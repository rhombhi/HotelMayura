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
        
        String in=itemName.toLowerCase();
        in=in.replace(" ", "_");
        Log.v(CONTEXT.getClass().getSimpleName()+"--","in:"+in);
        
        Resources res = getResources();

        int itemId = res.getIdentifier(in+"_items", "array", "com.hotelmayura");
        TypedArray dItems = res.obtainTypedArray(itemId);
        String items[]= new String[dItems.length()];
        for(int i=0;i<dItems.length();i++)
        	items[i]=dItems.getString(i);

        int descriptionId = res.getIdentifier(in+"_description", "array", "com.hotelmayura");
        TypedArray dDescription = res.obtainTypedArray(descriptionId);
        String description[]= new String[dDescription.length()];
        for(int i=0;i<dDescription.length();i++)
        	description[i]=dDescription.getString(i);

        int priceId = res.getIdentifier(in+"_prices", "array", "com.hotelmayura");
        TypedArray dPrices = res.obtainTypedArray(priceId);
        String prices[]= new String[dPrices.length()];
        for(int i=0;i<dPrices.length();i++)
        	prices[i]=dPrices.getString(i);

//        int icons[]= res.getIntArray(R.array.menu_items_drawables);
        
        MenuDetailListAdapter m = new MenuDetailListAdapter(CONTEXT, R.layout.menu_detail_list_layout, R.id.item_name, items, description, prices);
        menuDetailList.setAdapter(m);

    }
}