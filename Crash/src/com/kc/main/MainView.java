package com.kc.main;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.kc.inter.Drawable;
import com.kc.inter.Updatable;
import com.kc.tools.Benchmark;
import com.kc.tools.WinTool;

public class MainView extends View implements Updatable, Drawable{
	Benchmark BM;
	WinTool WT;
	public MainView(Context C) {
		super(C);
		BM = new Benchmark();
		WT = new WinTool(C);
	}
	public void Update(long mi) {
		
	}
	public void Draw(Canvas C) {
		Paint P = new Paint();
		P.setARGB(255, 0, 255, 0);
		C.drawRect(0, 0, WT.getScreenWidth(), WT.getScreenHeight(), P);
	}
	public void onDraw(Canvas C) {
		super.onDraw(C);
		super.postInvalidate();
		BM.update();
		Update(BM.getMillisecondsElapsed());
		Draw(C);
	}
	
	
}
