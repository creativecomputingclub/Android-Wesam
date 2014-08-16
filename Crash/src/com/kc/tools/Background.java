package com.kc.tools;

import com.kc.main.MainView;
import com.wes.crash.BaseGameObject;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;


public class Background {
	BaseGameObject BG1, BG2;
	public Background(Bitmap Image, float x, float y, float speed){
		BG1 = new BaseGameObject(Image, x, y,MainView.WT.ScreenWidth, 2048);
		BG1.setFVY(speed);
		BG2 = new BaseGameObject(Image, x,MainView.WT.ScreenHeight,MainView.WT.ScreenWidth, 2048);
		BG2.setFVY(speed);
	}
	public void Update(long mi){
		BG1.Update(mi);
		BG2.Update(mi);
		//if BG1 has whitespace set BG2 to bottom of BG1
		float sh = MainView.WT.ScreenHeight;
		if (BG1.getY() <= -2048) {
			BG1.setY(sh);
		}
	}	
	public void Draw(Canvas C){
		BG1.Draw(C);
		BG2.Draw(C);
	}
}