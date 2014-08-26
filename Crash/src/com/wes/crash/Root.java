package com.wes.crash;

import java.util.ArrayList;

import android.graphics.Canvas;

import com.kc.main.ClassicPacer;

public class Root {
	ClassicPacer pb;
	ArrayList<BaseGameObject> BaseGameObjects;
	ArrayList<Coin>Coins;
	ArrayList<Bomb>Bombs;
	float PressX, PressY;
	boolean ispress;
	public Root() {
		BaseGameObjects = new ArrayList<BaseGameObject>();
		Coins = new ArrayList<Coin>();
		Bombs = new ArrayList<Bomb>();
	}
	public void draw(Canvas C) {
		for (BaseGameObject BG : BaseGameObjects) BG.Draw(C);
		for (int i = 0; i < Coins.size(); i++) Coins.get(i).Draw(C);
		for (int i = 0; i < Bombs.size(); i++) Bombs.get(i).Draw(C);
	}
	public ClassicPacer getPb() {
		return pb;
	}

	public void setPb(ClassicPacer pb) {
		this.pb = pb;
	}

	public ArrayList<BaseGameObject> getBGOS() {
		return BaseGameObjects;
	}

	public ArrayList<Coin> getCoins() {
		return Coins;
	}

	public ArrayList<Bomb> getBombs() {
		return Bombs;
	}
	public float getPressX() {
		return PressX;
	}
	public float getPressY() {
		return PressY;
	}
	public void setPressX(float pressX) {
		PressX = pressX;
	}
	public void setPressY(float pressY) {
		PressY = pressY;
	}
	public boolean isIspress() {
		return ispress;
	}
	public void setIspress(boolean ispress) {
		this.ispress = ispress;
	}

}
