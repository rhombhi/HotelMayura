package com.hotelmayura;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.hotelmayura.database.DatabaseAdapter;

public class Reviews extends Activity
{
	private Context CONTEXT = this;

	private Button submit;
	private RatingBar food;
	private RatingBar ambience;
	private RatingBar qos;
	private EditText comments;
	private EditText name;
	
	private DatabaseAdapter dbAdapater;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reviews);

        dbAdapater = new DatabaseAdapter(CONTEXT);
        
        submit =(Button) findViewById(R.id.submit);
        food = (RatingBar) findViewById(R.id.food);
        ambience = (RatingBar) findViewById(R.id.ambience);
        qos = (RatingBar) findViewById(R.id.qos);
        comments = (EditText)findViewById(R.id.comments);
        name = (EditText)findViewById(R.id.name);
        
        comments.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View arg0) 
			{
				comments.setSelection(0);
			}
		});

        comments.addTextChangedListener(new TextWatcher()
        {
			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) 
			{
				Log.v(this.getClass().getSimpleName()+"--", "on");

			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) 
			{
					Log.v(this.getClass().getSimpleName()+"--", "before");
					if((comments.getText()).toString().equals("Additional comments"))
					{
						comments.setText(null);
					}
			}
			
			@Override
			public void afterTextChanged(Editable arg0) 
			{
				Log.v(this.getClass().getSimpleName()+"--", "after");
			}
		});

        name.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View arg0) 
			{
				name.setSelection(0);
			}
		});

        name.addTextChangedListener(new TextWatcher()
        {
			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) 
			{
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) 
			{
				if((name.getText()).toString().equals("Annonymous"))
				{
					name.setText(null);
				}
			}
			
			@Override
			public void afterTextChanged(Editable arg0) 
			{
				
			}
		});

        submit.setOnClickListener(new OnClickListener() 
        {
        	@Override
        	public void onClick(View v) 
        	{
        		dbAdapater.open();
        		
        		ContentValues cv = dbAdapater.createContentValues("name",""+name.getText(),"ambience",ambience.getRating(),"qos",qos.getRating(),"food",food.getRating(),"comments", ""+comments.getText());
        		dbAdapater.createRow("Reviews", cv);
        		
        		dbAdapater.close();
        		
        		food.clearFocus();
        		food.setRating(0);
        		ambience.setRating(0);
        		qos.setRating(0);
        		comments.setText("");
        	}
        });
    }
}