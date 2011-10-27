package com.hotelmayura;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
        
        String items[]=
        {
        		"Appetizers", "Vegeterian Dishes", "Dosas",
        		"Mayura Utthapam", "Chicken Dishes", "Other meat and sea food",
        		"Lunch and Dinner Specials", "Mayura specials", "Rice Dishes",
        		"Desserts", "Baverages", "Indian Breads", 
        		"Indian Side Orders", "Indian Soups and Salads", "Beers",
        		"Wine"
        		
        };
        
        MenuListAdapter m = new MenuListAdapter(CONTEXT, R.layout.menu_list_layout, R.id.item_name, items, icons);
        menuList.setAdapter(m);
        
    }
}