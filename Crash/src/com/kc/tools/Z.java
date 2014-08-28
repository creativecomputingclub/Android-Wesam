package com.kc.tools;

import android.graphics.Bitmap;

public class Z {
	public static WinTool WT;
	public static Bitmap Coin_Image,Dirt_Image,Sphere_Image,Background_Image,Red_Coin,Green_Coin,Blue_Coin,Bomb_Image;
	public static int score;
	public static int SCORE_NORMAL_HIGH = 9;
	public static int SCORE_BLUE_LOW = 10, SCORE_BLUE_HIGH = 49;
	public static int SCORE_GREEN_LOW = 50;
	public static int SCORE_RED_RANDOM = (int) (Math.random()*10)*10;
	public static int SCORE_NORMAL_INCREASE = 1;
	public static int SCORE_BLUE_INCREASE = 5;
	public static int SCORE_GREEN_INCREASE = 10;
	public static int SCORE_RED_DECREASE = 50;
	public static int SCORE_BOMB_APPEAR_FIRST = (int) (Math.random()*10);
	//public static int SCORE_BOMB_APPEAR_SECOND = (int) (Math.random()*10);
}
