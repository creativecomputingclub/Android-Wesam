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
	
	// **Only declare in class space**, do not assign or do any calculations here
	// Do it in the constructor
	//int Measuredwidth = wt.getScreenWidth();
	//int padding = bmp.getWidth(); 
	//private int left = (int)(Math.random() * (Measuredwidth - padding)); 
	private int left;
	
	//constructor
	public MyView(Context context) {
		super(context);
		wt = new WinTool(context);// This is how you create a WinTool object
		bmp = BitmapFactory.decodeResource(getResources(), 0x7f020000);
		MT = new MyTimer(5);// Please use com.kc.tools.Timer
		AR = new ArrayList<Bitmap>();
		for(int i = 0; i < 30; i++) {
			AR.add(bmp);
			// Adding 30 of the same image to an arraylist?
		}
		/*
		 * This is where Measuredwidth, padding and left should be assigned. like
		 * Measuredwidth = wt.getScreenWidth();
		 * 
		 * **Please NOTE**
		 * ASSIGNMENT
		 * var = 10;
		 * DECLARATION
		 * int var;
		 * BOTH
		 * int var = 10;
		 */
		left = 0;
	}
	
	public void onDraw(Canvas C) {
		super.postInvalidate();
		Log.i("key", "Draw");
		C.drawBitmap(bmp, left, 0, null);
		update();
	}
	
	public void update() {
		
	}
	/*You're missing the Benchmark utility for the game loop
	 * Take a look at com.kc.main.MainView
	 * I suggest you move everything in here to there
	 * 	public void onDraw(Canvas C) {
		super.onDraw(C);
		super.postInvalidate();
		BM.update();
		Update(BM.getMillisecondsElapsed());
		Draw(C);
	}
	 */
	
}
