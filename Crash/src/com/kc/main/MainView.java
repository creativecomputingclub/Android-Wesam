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
import com.wes.crash.StreamCoin;
public class MainView extends View implements Updatable, Drawable{
	Benchmark BM;
	public static WinTool WT;
	public static Bitmap Coin_Image,Dirt_Image,Sphere_Image,Background_Image,Red_Coin,Green_Coin;
	Background BG1;
	ArrayList<BaseGameObject> BL;
	ArrayList<Coin>Coins;
	BaseGameObject BG;
	ClassicPacer Pb;
	StreamCoin Sc;
	float x, y, score;
	boolean ispress;
	public MainView(Context C) {
		super(C);
		BM = new Benchmark();
		WT = new WinTool(C);
		
		score = 0;
		Coin_Image = BitmapFactory.decodeResource(this.getResources(), R.drawable.coin);
		Red_Coin = BitmapFactory.decodeResource(this.getResources(), R.drawable.redcoin);
		Green_Coin = BitmapFactory.decodeResource(this.getResources(), R.drawable.greencoin);
		Dirt_Image = BitmapFactory.decodeResource(this.getResources(), R.drawable.tiledirt);
		Sphere_Image = BitmapFactory.decodeResource(this.getResources(), R.drawable.bubble);
		Background_Image = BitmapFactory.decodeResource(this.getResources(), R.drawable.bg2);
		Background_Image = Bitmap.createScaledBitmap(Background_Image, WT.getScreenWidth(), 2048, true);
		BG1 = new Background(Background_Image,.1f);
		BL = new ArrayList<BaseGameObject>();
		Coins = new ArrayList<Coin>();
		Sc = new StreamCoin(Coin_Image,100,0,156,176);
		Pb = new ClassicPacer(Sphere_Image,BL,500,154f,148f) {
			public void addToList(BaseGameObject BGO) {
				if (BGO instanceof Coin) {	
					Coins.add((Coin)BGO);
					BL.add(BGO);
				}
				if (BGO instanceof GlassSphere) {
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
		Rect TES = new Rect((int)x,(int)y,(int)x,(int)y);
		for (int j = Coins.size()-1; j > -1; j--) {
			Coin BGO = Coins.get(j);
			BGO.Update(mi);
			if (BG.getY() > WT.getScreenHeight()){
				remove(BGO);
				continue;
			}
			/*(score >= 10){
				BGO.getT().start();
			}
			while(score >= 10 && BGO.getT().getMilliseconds() <= 10000) {
					
					BGO.getT().stop();
				}*/
			if(ispress == true) {
				boolean b = BGO.isColliding(TES);
				if(b == true && BGO.isCanbepressed() && score < 10){
					Coins.remove(BGO);
					score++;
					ispress = false;
				}else if(b == true && BGO.isCanbepressed() && score >= 10 && score < 50){
					Coins.remove(BGO);
					score += 5;
					ispress = false;
				}else if(b == true && BGO.isCanbepressed() && score >= 50){
					Coins.remove(BGO);
					score += 10;
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
				float bgx = BG.getX();
				float bgy = BG.getY();
				float bgw = BG.getW();
				float bgh = BG.getH();
				float ret = 1.2f;
				float coinw = bgw * ret;
				float coinh = bgh * ret;
				float midx = bgx + (bgw/2);
				float midy = bgy + (bgh/2);
				float coinx = midx - (coinw/2);
				float coiny = midy - (coinh/2);	
				if(b == true && score < 10) {
					Coins.add(new Coin(Coin_Image,coinx,coiny,coinw,coinh, -1.5f,.1f));
					remove(BG);
					ispress = false;
				}else if(b == true && score >= 10 && score < 50) {
					Coins.add(new Coin(Red_Coin,coinx,coiny,coinw,coinh, -1.5f,.1f));
					remove(BG);
					ispress = false;
				}else if(b == true && score >= 15) {
					Coins.add(new Coin(Green_Coin,coinx,coiny,coinw,coinh, -1.5f,.1f));
					remove(BG);
					ispress = false;
				}
			}
		}
		
	}
	public void Draw(Canvas C) {
		BG1.Draw(C);
		for (BaseGameObject BG : BL) BG.Draw(C);
		for (int i = 0; i < Coins.size(); i++) Coins.get(i).Draw(C);
		Paint P = new Paint();
		P.setTextSize(100f);
		P.setARGB(255,0,0,0);
		C.drawText(""+score,100,100,P);
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
