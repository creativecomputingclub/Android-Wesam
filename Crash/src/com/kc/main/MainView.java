package com.kc.main;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;

import com.kc.inter.Drawable;
import com.kc.inter.Updatable;
import com.kc.tools.Animator;
import com.kc.tools.Benchmark;
import com.kc.tools.BitmapBreaker;
import com.kc.tools.WinTool;

public class MainView extends View implements Updatable, Drawable{
	Benchmark BM;
	WinTool WT;
	Animator A;
	Bitmap BB;
	public MainView(Context C) {
		super(C);
		BM = new Benchmark();
		WT = new WinTool(C);
		BB = BitmapFactory.decodeResource(this.getResources(),0x7f020000);
		Log.i("KC",""+BB);
		A = new Animator(		  60,
								  new RectF(0,0,1024,512),
								  BB,
								  BitmapBreaker.split(0, 0, 1024, 512, 4, 2));
	}
	@Override
	public void Update(long mi) {
		A.Update(mi);
	}
	@Override
	public void Draw(Canvas C) {
		A.Draw(C);
	}
	@Override
	public void onDraw(Canvas C) {
		super.onDraw(C);
		super.postInvalidate();
		BM.update();
		Update(BM.getMillisecondsElapsed());
		Draw(C);
	}
	
	
}
