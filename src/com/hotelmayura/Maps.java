package com.hotelmayura;

import java.util.List;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class Maps extends MapActivity
{
	private MapView mapView;
    private MapController mc;
    private GeoPoint p;
	
    class MapOverlay extends com.google.android.maps.Overlay
    {

		@Override
		public boolean draw(Canvas canvas, MapView mapView, boolean shadow, long when) 
		{
            super.draw(canvas, mapView, shadow);                   
            
            Point screenPts = new Point();
            mapView.getProjection().toPixels(p, screenPts);
 
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.pushpin);            
            canvas.drawBitmap(bmp, screenPts.x, screenPts.y-50, null);         
            return true;
		}
    } 
    
    @Override
	protected void onCreate(Bundle arg0) 
	{
		super.onCreate(arg0);
		setContentView(R.layout.maps);
		
        mapView = (MapView) findViewById(R.id.mapView);
        mapView.setBuiltInZoomControls(true);
        
        mc = mapView.getController();
        String coordinates[] = {"34.020174", "-118.404272"};
        double lat = Double.parseDouble(coordinates[0]);
        double lng = Double.parseDouble(coordinates[1]);
 
        p = new GeoPoint((int) (lat * 1E6), (int) (lng * 1E6));
 
        mc.animateTo(p);
        mc.setZoom(17); 
        
        MapOverlay mapOverlay = new MapOverlay();
        List<Overlay> listOfOverlays = mapView.getOverlays();
        listOfOverlays.clear();
        listOfOverlays.add(mapOverlay);        
 
        mapView.invalidate();
	}

	@Override
	protected boolean isRouteDisplayed() 
	{
		return false;
	}

}
