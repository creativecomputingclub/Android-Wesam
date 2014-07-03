package com.wes.crash;

import java.util.ArrayList;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;

import com.kc.tools.WinTool;;

public class MyView extends View {
	
	Ball ball;
	MyTimer MT;
	private Bitmap bmp;
	ArrayList<Bitmap> AR;
	WinTool wt;
	
	int Measuredwidth = wt.getScreenWidth();
	int padding = bmp.getWidth(); 
	
	private int left = (int)(Math.random() * (Measuredwidth - padding)); 
	
	
	
	public MyView(Context context) {
		super(context);
		bmp = BitmapFactory.decodeResource(getResources(), 0x7f020000);
		MT = new MyTimer(5);
		AR = new ArrayList<Bitmap>();
		for(int i = 0; i < 30; i++)
			AR.add(bmp);
	}
	
	public void onDraw(Canvas C) {
		super.postInvalidate();
		Log.i("key", "Draw");
		C.drawBitmap(bmp, left, 0, null);
		update();
	}
	
	public void update() {
		
	}
	
}
