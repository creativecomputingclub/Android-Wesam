package com.wes.crash;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.kc.tools.WinTool;

public class Ball extends BaseGameObject { // I made the super class BGO. Ball
											// now inherits the functionality
	float x, y;
	int speedX = 0;
	int speedY = 0;
	private boolean falling = true;
	WinTool wt;
	int left;

	public Ball(Bitmap Copy) {
		super(Copy, 0, 0, 0, 0);
		// TODO Auto-generated constructor stub
	}

	public void Update() {
		if (falling == true)
			speedY = 10;
	} 
	public void Draw(Canvas C) {
		super.Draw(C);
	}

}
