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
	public static int SCORE_NORMAL_HIGH = 9;
	public static int SCORE_RED_LOW = 10, SCORE_RED_HIGH = 49;
	public static int SCORE_GREEN_LOW = 50;
	public static int SCORE_NORMAL_INCREASE = 1;
	public static int SCORE_RED_INCREASE = 5;
	public static int SCORE_GREEN_INCREASE = 10;
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
		Background_Image = getScaledBitmap(R.drawable.bghv1_new,WT.getScreenWidth(),2048);
		BG1 = new Background(Background_Image,400,.0005f);
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
				if (b == true && BGO.isCanbepressed()) {
					if(score <= SCORE_NORMAL_HIGH) score += SCORE_NORMAL_INCREASE;
					else if(score >= SCORE_RED_LOW && score <= SCORE_RED_HIGH) score += SCORE_RED_INCREASE;
					else if(score >= SCORE_GREEN_LOW) score += SCORE_GREEN_INCREASE;
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
				if (b == true) {
					float bgx = BG.getX();
					float bgy = BG.getY();
					float bgw = BG.getW();
					float bgh = BG.getH();
					float ret = .98f;
					float coinw = bgw * ret;
					float coinh = bgh * ret;
					float midx = bgx + (bgw/2);
					float midy = bgy + (bgh/2);
					float coinx = midx - (coinw/2);
					float coiny = midy - (coinh/2);	
					Bitmap Image = null;
					if(score <= SCORE_NORMAL_HIGH) Image = Coin_Image;
					else if(score >= SCORE_RED_LOW && score <= SCORE_RED_HIGH) Image = Red_Coin;
					else if(score >= SCORE_GREEN_LOW) Image = Green_Coin;
					Coins.add(new Coin(Image,coinx,coiny,coinw,coinh, -1.5f,.1f));
					remove(BG);
					ispress = false;
				}
			}
		}
		
	}
	public void Draw(Canvas C) {
		Paint P1 = new Paint();
		P1.setARGB(255,0,0,0);
		C.drawRect(new Rect(0,0,WT.getScreenWidth(),WT.getScreenHeight()),P1);
		BG1.Draw(C);
		for (BaseGameObject BG : BL) BG.Draw(C);
		for (int i = 0; i < Coins.size(); i++) Coins.get(i).Draw(C);
		Paint P = new Paint();
		P.setTextSize(100f);
		P.setARGB(255,255,255,255);
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
			case MotionEvent.ACTION_DOWN: {
				ispress = true;
				break;
			}
			case MotionEvent.ACTION_UP: {
				ispress = false;
				break;
			}
		}
		return true;
	}
	public Bitmap getScaledBitmap(int id, int w, int h) {
		return Bitmap.createScaledBitmap(
				BitmapFactory.decodeResource(this.getResources(),id),
				w,h,true);
	}
}
