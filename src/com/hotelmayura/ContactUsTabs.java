package com.hotelmayura;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class ContactUsTabs extends TabActivity 
{
	private Context CONTEXT = this;
	
	private TabHost tabHost;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us_tabs);
        
        tabHost=getTabHost();
        
        TabSpec laSpec, ccSpec;
        Intent la, cc;
        
        la=new Intent(CONTEXT,ContactUsLA.class);
        cc=new Intent(CONTEXT,ContactUsCC.class);
        
        laSpec=tabHost.newTabSpec("la")
        .setIndicator("Los Angeles")
        .setContent(la);

        ccSpec=tabHost.newTabSpec("cc")
        .setIndicator("Culver City")
        .setContent(cc);
        
        tabHost.addTab(laSpec);
        tabHost.addTab(ccSpec);
        
        tabHost.setCurrentTabByTag("la");

        
    }
}