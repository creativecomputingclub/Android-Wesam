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
import android.widget.ImageView;

import com.kc.tools.WinTool;
import com.kc.tools.Timer;

public class MyView extends View {
	
	Ball ball;
	Timer MT;
	WinTool wt;
	
	int padding = 0;
	int MeasuredWidth = 0;
	
	private Bitmap bmp;
	private int left;
	
	//constructor
	public MyView(Context context) {
		super(context);
		wt = new WinTool(context);// This is how you create a WinTool object
		bmp = BitmapFactory.decodeResource(getResources(), 0x7f020000);
		MT = new Timer();
		
		//making the ball randomly pop on the screen
		MeasuredWidth = wt.getScreenWidth();
		padding = bmp.getWidth(); 
		left = (int)(Math.random() * (MeasuredWidth - padding)); 
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
