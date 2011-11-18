package com.hotelmayura;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Menu extends Activity 
{
	private Context CONTEXT = this;
	private ListView menuList;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        
        menuList = (ListView) findViewById(R.id.menu_list);
        
        int icons[]=
        {
        		R.drawable.appetizers, R.drawable.vegeterian_dishes, R.drawable.dosas,
        		R.drawable.mayura_uttapam, R.drawable.chicken_dishes, R.drawable.other_meat_and_sea_food,
        		R.drawable.lunch_and_dinner_specials, R.drawable.mayura_specials, R.drawable.rice_dishes,
        		R.drawable.desserts, R.drawable.baverages, R.drawable.indian_breads,
        		R.drawable.indian_side_orders, R.drawable.indian_soups_and_salads, R.drawable.beers,
        		R.drawable.wine
        };
        
        Resources res = getResources();

        TypedArray mi = res.obtainTypedArray(R.array.menu_items);
        
        String items[]= new String[mi.length()];
        for(int i=0;i<mi.length();i++)
        	items[i]=mi.getString(i);

        
        MenuListAdapter m = new MenuListAdapter(CONTEXT, R.layout.menu_list_layout, R.id.item_name, items, icons);
        menuList.setAdapter(m);
        
        menuList.setOnItemClickListener(new OnItemClickListener()
        {
			@Override
			public void onItemClick(AdapterView<?> adapView, View v, int position, long id) 
			{
				String itemName=(((TextView)v.findViewById(R.id.item_name)).getText()).toString();
				Log.v(CONTEXT.getClass().getSimpleName()+"--","tiem name:"+itemName);
				Intent menuDetailIntent = new Intent(CONTEXT,MenuDetail.class);
				menuDetailIntent.putExtra("itemName", itemName);
				startActivity(menuDetailIntent);
			}
		});
        
    }
}