package com.kc.main;

import android.content.Context;
import android.content.Intent;
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
import com.kc.tools.Bouncing;
import com.kc.tools.WinTool;
import com.kc.tools.Z;
import com.wes.crash.BaseGameObject;
import com.wes.crash.Bomb;
import com.wes.crash.Coin;
import com.wes.crash.DeadActivity;
import com.wes.crash.GlassSphere;
import com.wes.crash.MainActivity;
import com.wes.crash.R;
import com.wes.crash.Root;
import com.wes.crash.ToMainView;
public class MainView extends View implements Updatable, Drawable{
	Benchmark BM;
	Root root;
	Background BG1;
	ClassicPacer Pb;
	int deathCount = 0;
	Context mainActivity;
	public MainView(Context C) {
		super(C);
		mainActivity = C;
		root = new Root();
		BM = new Benchmark();
		Z.WT = new WinTool(C);
		Z.score = 0;
		Z.Coin_Image = BitmapFactory.decodeResource(this.getResources(), R.drawable.coin);
		Z.Red_Coin = BitmapFactory.decodeResource(this.getResources(), R.drawable.redcoin);
		Z.Green_Coin = BitmapFactory.decodeResource(this.getResources(), R.drawable.greencoin);
		Z.Blue_Coin = BitmapFactory.decodeResource(this.getResources(), R.drawable.bluecoin);
		Z.Bomb_Image = BitmapFactory.decodeResource(this.getResources(), R.drawable.bomb);
		Z.Dirt_Image = BitmapFactory.decodeResource(this.getResources(), R.drawable.tiledirt);
		Z.Sphere_Image = BitmapFactory.decodeResource(this.getResources(), R.drawable.bubble);
		Z.Background_Image = getScaledBitmap(R.drawable.rbhv1_new,Z.WT.getScreenWidth(),2048);
		BG1 = new Background(Z.Background_Image,400,.0005f);
		Pb = new ClassicPacer(root,Z.Sphere_Image,root.getBGOS(),800,154f,148f) {
			public void addToList(BaseGameObject BGO) {
				if (BGO instanceof Coin) {	
					root.getCoins().add((Coin)BGO);
				}
				if (BGO instanceof GlassSphere) {
					root.getBGOS().add(BGO);
				}
				if (BGO instanceof Bomb) {
					root.getBombs().add((Bomb)BGO);
					System.out.println("add bomb");
				}
			}
		};
	}
	public void Update(long mi) {
		if(deathCount != 10){
			BG1.Update(mi);
			Pb.Update(mi);
			for (int j = root.getCoins().size()-1; j > -1; j--) {
				Coin C = root.getCoins().get(j);
				C.Update(mi);
				C.doPressLogic();
				C.doRemovalLogic();
				if (C.isIsdead()) root.getCoins().remove(C);
				if (C.isNotOnScreen()) root.getBGOS().remove(C);
			}
			for (int i = root.getBGOS().size()-1; i > -1; i--) {
				BaseGameObject BG = root.getBGOS().get(i);
				BG.Update(mi);
				BG.doPressLogic();
				BG.doRemovalLogic();
				if (BG.isIsdead()) root.getBGOS().remove(BG);
				if (BG.isNotOnScreen()){
					deathCount++;
					root.getBGOS().remove(BG);
				}
			}
			for (int i = root.getBombs().size()-1; i > -1; i--) {
				Bomb BG = root.getBombs().get(i);
				BG.Update(mi);
				BG.doPressLogic();
				BG.doRemovalLogic();
				if (BG.isIsdead()) root.getBombs().remove(BG);
				if (BG.isNotOnScreen()) root.getBGOS().remove(BG);
			}
		}
		if(deathCount == 10){
			onDead();
		}
	}
	public void Draw(Canvas C) {
		Paint P1 = new Paint();
		P1.setARGB(255,0,0,0);
		C.drawRect(new Rect(0,0,Z.WT.getScreenWidth(),Z.WT.getScreenHeight()),P1);
		BG1.Draw(C);
		root.draw(C);
		Paint P = new Paint();
		P.setTextSize(100f);
		P.setARGB(255,255,255,255);
		C.drawText(""+Z.score,100,100,P);
		C.drawText(""+deathCount,1500,100,P);
	}
	public void onDraw(Canvas C) {
		super.onDraw(C);
		super.postInvalidate();
		BM.update();
		Update(BM.getMillisecondsElapsed());
		Draw(C);
	}
	public void onDead(){
		Intent i = new Intent(mainActivity,DeadActivity.class);
		mainActivity.startActivity(i);
	}
	public boolean onTouchEvent(MotionEvent event) {
		root.setPressX(event.getX());
		root.setPressY(event.getY());
		switch(event.getAction()) {
			case MotionEvent.ACTION_DOWN: {
				root.setIspress(true);
				break;
			}
			case MotionEvent.ACTION_UP: {
				root.setIspress(false);
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
