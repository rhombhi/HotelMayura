package com.hotelmayura;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class Reviews extends Activity
{
	private Button submit;
	private RatingBar food;
	private RatingBar ambience;
	private RatingBar qos;
	private EditText text;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reviews);
        
        submit =(Button) findViewById(R.id.button1);
        food = (RatingBar) findViewById(R.id.ratingBar1);
        ambience = (RatingBar) findViewById(R.id.ratingBar2);
        qos = (RatingBar) findViewById(R.id.ratingBar3);
        text = (EditText)findViewById(R.id.editText1);
        text.setText("Enter Comments here");

        submit.setOnClickListener(new OnClickListener() 
        {
        	@Override
        	public void onClick(View v) 
        	{
        		food.clearFocus();
        		food.setRating(0);
        		ambience.setRating(0);
        		qos.setRating(0);
        		text.setText("");
        	}
        });
    }
}