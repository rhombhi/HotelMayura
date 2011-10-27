package com.hotelmayura;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter 
{
    private Context mContext;
    private Integer[] mThumbIds;

    public Integer[] getmThumbIds() {
		return mThumbIds;
	}

	public void setmThumbIds(Integer[] mThumbIds) {
		this.mThumbIds = mThumbIds;
	}

	public ImageAdapter(Context c) 
    {
        mContext = c;
    }

    public int getCount() 
    {
        return mThumbIds.length;
    }

    public Object getItem(int position) 
    {
        return null;
    }

    public long getItemId(int position) 
    {
        return 0;
    }

	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		ImageView imageView;
        if (convertView == null) 
        {  
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 300, Gravity.CENTER));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(50, 50, 50, 50);
            
        } 
        else 
        {
            imageView = (ImageView) convertView;
        }
        //imageView.setBackgroundColor(14606046);
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
	}
}