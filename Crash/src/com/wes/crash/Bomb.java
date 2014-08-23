package com.wes.crash;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Bomb extends BaseGameObject {
	
	
	public Bomb(Bitmap bomb, float x, float y, float w, float h) {
		super(bomb, x, y, w, h);
	}
	public void Update(long mi) {
		
	}
	public void Draw(Canvas C) {
		super.Draw(C);
	}

}
