package com.hotelmayura;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactUsLA extends Activity 
{
	private Context CONTEXT = this;

	private ImageView map;
	private TextView phoneno;
	private Button phoneIcon;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us_la);
     
        map =(ImageView)findViewById(R.id.map_image_la);
        phoneno = (TextView)findViewById(R.id.phone_la);
        phoneIcon = (Button)findViewById(R.id.phone_icon_la);
        
        phoneIcon.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View arg0) 
			{
				String url = "tel:"+phoneno.getText();
			    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(url));
			    startActivity(intent);
			}
		});
        
        map.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View arg0) 
			{
				Intent mapIntent = new Intent(CONTEXT, Maps.class);
				Bundle b = new Bundle();
			    b.putString("page", "LA");
			    mapIntent.putExtras(b);
				startActivity(mapIntent);
			}
		});
    }
}