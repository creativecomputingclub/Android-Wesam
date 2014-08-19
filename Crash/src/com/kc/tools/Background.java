package com.kc.tools;

import com.kc.main.MainView;
import com.wes.crash.BaseGameObject;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;


public class Background {
	Bitmap Image;
	float speed;
	float CurrentX;
	float CurrentY;
	float ImageWidth;
	float ImageHeight;
	float ScreenHeight;
	float ScreenWidth;
	float Buffer;
	float Middle;
	public Background(Bitmap Image,float speed){
		this.Image = Image;
		this.speed = .1f;
		CurrentX = 0;
		CurrentY = 0;
		Log.i("KC","IH: " + Image.getHeight());
		ScreenWidth = MainView.WT.ScreenWidth;
		ImageWidth = MainView.WT.ScreenWidth;
		ImageHeight = 2048;
		ScreenHeight = MainView.WT.ScreenHeight;
		Buffer = 500;
		this.speed = Buffer / 1500;
		Middle = 1205;
		//for (int i = 0; i < ImageWidth; i++) Image.setPixel(i, (int) (Middle),Color.GREEN);
	}
	public void Update(long mi){
		float add = speed*mi;
		if ((CurrentY + add >= Middle)) CurrentY = 0;
		else CurrentY += add;
	}	
	public void Draw(Canvas C){
		int bottom = (int)(CurrentY + Buffer);
		Rect Source = new Rect(0,(int)CurrentY,(int)ImageWidth,bottom);
		Rect Destination = new Rect(0,0,(int)ScreenWidth,(int)ScreenHeight);
		C.drawBitmap(Image, Source, Destination, null);
	}
}