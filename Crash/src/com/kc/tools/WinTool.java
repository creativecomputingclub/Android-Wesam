package com.kc.tools;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

public class WinTool{
	int ScreenWidth, ScreenHeight;
	public WinTool(Context C) {
		measureScreen(C);
	}
	public void measureScreen(Context C) {
		WindowManager WM = (WindowManager)C.getSystemService(Context.WINDOW_SERVICE);
		Display D = WM.getDefaultDisplay();
		Point P = new Point();
		D.getSize(P);
		ScreenWidth = P.x;
		ScreenHeight = P.y;
	}
	public int getScreenWidth() {
		return ScreenWidth;
	}
	public void setScreenWidth(int screenWidth) {
		ScreenWidth = screenWidth;
	}
	public int getScreenHeight() {
		return ScreenHeight;
	}
	public void setScreenHeight(int screenHeight) {
		ScreenHeight = screenHeight;
	}
	public void onLayout(boolean c, int l, int t, int r, int b) {
		setScreenWidth(r);
		setScreenHeight(b);
	}
	
}
