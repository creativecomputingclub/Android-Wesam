package com.kc.main;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

import com.kc.inter.Drawable;
import com.kc.inter.Updatable;
import com.kc.tools.Animator;
import com.kc.tools.Benchmark;
import com.kc.tools.Timer;
import com.kc.tools.WinTool;
import com.wes.crash.Ball;
import com.wes.crash.BaseGameObject;
import com.example.crash.*;
public class MainView extends View implements Updatable, Drawable{
	Benchmark BM;
	WinTool WT;
	Animator A;
	Bitmap Cat_Image, Ball_Image;
	Ball ball;
	Timer MT;
	BaseGameObject BG,BG2;
	
	public MainView(Context C) {
		super(C);
		BM = new Benchmark();
		WT = new WinTool(C);
		Cat_Image = BitmapFactory.decodeResource(this.getResources(), R.drawable.cat);
		Ball_Image = BitmapFactory.decodeResource(this.getResources(), R.drawable.tiledirt);
		BG = new BaseGameObject(Ball_Image,100,100,50,50);
		BG2 = new BaseGameObject(Cat_Image,0,0,25,25);
		ball = new Ball(Ball_Image);
		//A = new Animator(		  60,
		//						  new RectF(0,0,1024,512),
		//						  BB,
		//						  BitmapBreaker.split(0, 0, 1024, 512, 4, 2));
	}
	@Override
	public void Update(long mi) {
		//A.Update(mi);
		//Dont assign here
		BG.Update(mi);
		ball.Update();
	}
	@Override
	public void Draw(Canvas C) {
		//A.Draw(C);
		//I want to see Images consolidated to the BGO
		BG.Draw(C);
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
