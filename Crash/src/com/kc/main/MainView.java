package com.kc.main;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

import com.kc.inter.Drawable;
import com.kc.inter.Updatable;
import com.kc.tools.Background;
import com.kc.tools.Benchmark;
import com.kc.tools.WinTool;
import com.wes.crash.BaseGameObject;
import com.wes.crash.Coin;
import com.wes.crash.GlassSphere;
import com.wes.crash.R;
public class MainView extends View implements Updatable, Drawable{
	Benchmark BM;
	public static WinTool WT;
	public static Bitmap Coin_Image,Dirt_Image,Sphere_Image,Background_Image;
	Background BG1, BG2;
	ArrayList<BaseGameObject> BL;
	ArrayList<Coin>Coins;
	BaseGameObject BG;
	ClassicPacer Pb;
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
		Sphere_Image = BitmapFactory.decodeResource(this.getResources(), R.drawable.bubble);
		Background_Image = BitmapFactory.decodeResource(this.getResources(), R.drawable.background);
		Background_Image = Bitmap.createScaledBitmap(Background_Image, WT.getScreenWidth(), 2048, true);
		BG1 = new Background(Background_Image,0,0,3);
		BG2 = new Background(Background_Image,0,2048,3);
		BL = new ArrayList<BaseGameObject>();
		Coins = new ArrayList<Coin>();
		Pb = new ClassicPacer(Sphere_Image,BL,500,154f,148f) {
			public void addToList(BaseGameObject BGO) {
				if (BGO instanceof Coin) {	
					Coins.add((Coin)BGO);
					BL.add(BGO);
				}
				if (BGO instanceof GlassSphere) {
					System.out.println("SPHERE ADDED");
					//Coins.add((Coin)BGO);
					BL.add(BGO);
				}
			}
		};
		Pb.setMinspeed(-.5f);
		Pb.setMaxspeed(-.9f);
		Pb.setLimit(10);
		Pb.getT().setThreshold(1000);
	}
	public void remove(BaseGameObject BGO) {
		BL.remove(BGO);
		Coins.remove(BGO);
	}
	public void Update(long mi) {
		BG1.Update(mi);
		BG2.Update(mi);
		Rect TES = new Rect((int)x,(int)y,(int)x,(int)y);
		for (int j = Coins.size()-1; j > -1; j--) {
			Coin BGO = Coins.get(j);
			BGO.Update(mi);
			if (BG.getY() > WT.getScreenHeight()){
				remove(BGO);
				continue;
			}
			if(ispress == true) {
				boolean b = BGO.isColliding(TES);
				if(b == true){
					Coins.remove(BGO);
					ispress = false;
				}
			}
		}
		Pb.Update(mi);
		for (int i = BL.size()-1; i > -1; i--) {
			BG = BL.get(i);
			BG.Update(mi);
			if (BG.getY() > WT.getScreenHeight()){
				remove(BG);
				continue;
			}
			if(ispress == true) {
				boolean b = BG.isColliding(TES);	
				if(b == true) {
					Coins.add(new Coin(Coin_Image, x, y, 200f, 193f, -1.5f,.1f));
					remove(BG);
					ispress = false;
				}
			}
		}	
		
	}
	public void Draw(Canvas C) {
		BG1.Draw(C);
		BG2.Draw(C);
		for (BaseGameObject BG : BL) BG.Draw(C);
		for (int i = 0; i < Coins.size(); i++) Coins.get(i).Draw(C);
		Paint P = new Paint();
		P.setTextSize(100f);
		P.setARGB(255,0,0,0);
		C.drawText(""+Coins.size(),100,100,P);
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
