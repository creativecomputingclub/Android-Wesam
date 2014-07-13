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
import com.wes.crash.Pacer;
public class MainView extends View implements Updatable, Drawable{
	Benchmark BM;
	public static WinTool WT;
	public static Bitmap Coin_Image,Dirt_Image,Bubble_Image;
	ArrayList<BaseGameObject> BL;
	Pacer P;
	public MainView(Context C) {
		super(C);
		BM = new Benchmark();
		WT = new WinTool(C);
		Coin_Image = BitmapFactory.decodeResource(this.getResources(), R.drawable.coin);
		Dirt_Image = BitmapFactory.decodeResource(this.getResources(), R.drawable.tiledirt);
		Bubble_Image = BitmapFactory.decodeResource(this.getResources(), R.drawable.bubble);
		BL = new ArrayList<BaseGameObject>();
		P = new Pacer(BL,5000);
	}
	public void Update(long mi) {
		P.Update(mi);
		for (BaseGameObject BG : BL) BG.Update(mi);
	}
	public void Draw(Canvas C) {
		for (BaseGameObject BG : BL) BG.Draw(C);
	}
	public void onDraw(Canvas C) {
		super.onDraw(C);
		super.postInvalidate();
		BM.update();
		Update(BM.getMillisecondsElapsed());
		Draw(C);
	}
}
