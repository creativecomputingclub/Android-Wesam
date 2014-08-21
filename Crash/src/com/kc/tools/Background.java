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
	public Background(Bitmap Image,int Buffer,float BufferChange){
		this.Image = Image;
		CurrentX = 0;
		CurrentY = 0;
		ScreenWidth = MainView.WT.ScreenWidth;
		ImageWidth = MainView.WT.ScreenWidth;
		ImageHeight = Image.getHeight();
		ScreenHeight = MainView.WT.ScreenHeight;
		Middle = ImageHeight/2;
		if (Buffer > Middle) Buffer = (int)Middle;
		this.Buffer = Buffer;
		this.speed = Buffer*BufferChange;
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