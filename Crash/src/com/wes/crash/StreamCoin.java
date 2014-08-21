package com.wes.crash;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.kc.tools.Vector;

public class StreamCoin extends BaseGameObject {
	Vector vector;
	
	public StreamCoin(Bitmap Stream, float x, float y, float w, float h) {
		super(Stream, x, y, w, h);
		vector = new Vector(x,y);
	}
	public void Update(long mi) {
		super.Update(mi);
	}
	public void Draw(Canvas C) {
		super.Draw(C);
	}

}
