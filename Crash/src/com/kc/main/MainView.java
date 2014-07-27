package com.kc.main;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
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
	ArrayList<BaseGameObject> Bubbles;
	ArrayList<Coin>Coins;
	BaseGameObject BG;
	Pacer Pb;
	float x, y;
	boolean ispress;
	public MainView(Context C) {
		super(C);
		try{
			Thread.sleep(33);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BM = new Benchmark();
		WT = new WinTool(C);
		Coin_Image = BitmapFactory.decodeResource(this.getResources(), R.drawable.coin);
		Dirt_Image = BitmapFactory.decodeResource(this.getResources(), R.drawable.tiledirt);
		Bubble_Image = BitmapFactory.decodeResource(this.getResources(), R.drawable.bubble);
		
		Bubbles = new ArrayList<BaseGameObject>();
		Coins = new ArrayList<Coin>();
		Pb = new Pacer(Bubble_Image,Bubbles,500,154f,148f);
		Pb.setMinspeed(-.5f);
		Pb.setMaxspeed(-.9f);
		Pb.setLimit(10);
		Pb.getT().setThreshold(1000);
	}
	public void Update(long mi) {
		for (int j = Coins.size()-1; j > -1; j--) {
			Coin BGO = Coins.get(j);
			BGO.Update(mi);
			if (BG.getY() > WT.getScreenHeight()){
				Coins.remove(BGO);
				continue;
			}
			if(ispress == true) {
				boolean b = BGO.getCoords().contains((int)x,(int)y);
				if(b == true){
					//BGO.getT().start();
					Coins.remove(BGO);
					//BGO.getT().reset();
					ispress = false;
				}
				/*if(b == true && BGO.isCanbepressed() == true) {
					ispress = false;
				}if(b == true && BGO.isCanbepressed() == false){
						
				}*/
			}
		}
		Pb.Update(mi);
		for (int i = Bubbles.size()-1; i > -1; i--) {
			BG = Bubbles.get(i);
			BG.Update(mi);
			if (BG.getY() < -WT.getScreenHeight()){
				Bubbles.remove(BG);
				continue;
			}
			if(ispress == true) {
				boolean b = BG.getCoords().contains((int)x,(int)y);	
				if(b == true) {
					Coins.add(new Coin(Coin_Image, x, y, 200f, 193f, -1.5f,.1f));
					Bubbles.remove(BG);
					ispress = false;
				}
			}
		}
		//Co.Update(mi);	
		
	}
	public void Draw(Canvas C) {
		for (BaseGameObject BG : Bubbles) BG.Draw(C);
		for (int i = 0; i < Coins.size(); i++) Coins.get(i).Draw(C);
		Paint P = new Paint();
		P.setTextSize(100f);
		//P.setStrokeMiter(10f);
		//P.setStrokeWidth(10f);
		P.setARGB(255,0,0,0);
		C.drawText(""+Coins.size(),100,100,P);
		//Co.Draw(C);
	}
	public void onDraw(Canvas C) {
		super.onDraw(C);
		super.postInvalidate();
		BM.update();
		Update(BM.getMillisecondsElapsed());
		Draw(C);
	}
	public boolean onTouchEvent(MotionEvent event) {
		x = event.getX();
		y = event.getY();
		switch(event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				ispress = true;
			break;
			case MotionEvent.ACTION_UP:
			ispress = false;
			break;
		}
		return true;
	}
	
}
