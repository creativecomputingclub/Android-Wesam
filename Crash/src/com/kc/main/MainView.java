package com.kc.main;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

import com.example.crash.R;
import com.kc.inter.Drawable;
import com.kc.inter.Updatable;
import com.kc.tools.Benchmark;
import com.kc.tools.WinTool;
import com.wes.crash.BaseGameObject;
import com.wes.crash.Coin;
import com.wes.crash.Pacer;
public class MainView extends View implements Updatable, Drawable{
	Benchmark BM;
	public static WinTool WT;
	public static Bitmap Coin_Image,Dirt_Image,Bubble_Image;
	ArrayList<BaseGameObject> BL;
	Pacer Pb,pc;
	Coin Co;
	public MainView(Context C) {
		super(C);
		BM = new Benchmark();
		WT = new WinTool(C);
		Coin_Image = BitmapFactory.decodeResource(this.getResources(), R.drawable.coin);
		Co = new Coin(Coin_Image,300f,300f,171f,166f,-1.5f,.1f);
		/*
		Dirt_Image = BitmapFactory.decodeResource(this.getResources(), R.drawable.tiledirt);
		Bubble_Image = BitmapFactory.decodeResource(this.getResources(), R.drawable.bubble);
		BL = new ArrayList<BaseGameObject>();
		Pb = new Pacer(Bubble_Image,BL,1000,154f,148f);
		Pb.setMinspeed(.8f);
		Pb.setLimit(10);
		Pb.getT().setThreshold(1000);
		pc = new Pacer(Coin_Image,BL,5000,171f,166f);
		*/
	}
	public void Update(long mi) {
		/*
		Pb.Update(mi);
		pc.Update(mi);
		for (int i = BL.size()-1; i > -1; i--) {
			BaseGameObject BG = BL.get(i);
			BG.Update(mi);
			if (BG.getY() > WT.getScreenHeight()) BL.remove(BG);
		}
		*/
		Co.update(mi);
	}
	public void Draw(Canvas C) {
		/*
		for (BaseGameObject BG : BL) BG.Draw(C);
		Paint P = new Paint();
		P.setTextSize(100f);
		//P.setStrokeMiter(10f);
		//P.setStrokeWidth(10f);
		P.setARGB(255,0,0,0);
		C.drawText(""+BL.size(),100,100,P);
		*/
		Co.Draw(C);
	}
	public void onDraw(Canvas C) {
		super.onDraw(C);
		super.postInvalidate();
		BM.update();
		Update(BM.getMillisecondsElapsed());
		Draw(C);
	}
}
