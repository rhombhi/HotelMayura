package com.hotelmayura;

import android.app.Activity;
import android.content.Context;
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
        
        String itemName = ((Activity) CONTEXT).getIntent().getExtras().getString("itemName");
        Log.v(CONTEXT.getClass().getSimpleName()+"--","tiem name:"+itemName);
        title.setText(itemName);
    }
}