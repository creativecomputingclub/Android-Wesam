package com.wes.crash;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.kc.inter.Drawable;
import com.kc.inter.Updatable;

public class BaseGameObject implements Updatable, Drawable {
	// Here is what the Base Object should look like. Every object will have a
	// vector and an image.
	// Every object knows how to update and draw
	// Vector
	// **Image**
	Bitmap image;
	float x, y, w, h;
	Rect Coords;

	public BaseGameObject(Bitmap image, float x, float y, float w, float h) {
		this.image = image;
		Coords = new Rect((int) x, (int) y, (int) (x + w), (int) (y + h));
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	@Override
	public void Update(long mi) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Draw(Canvas C) {
		C.drawBitmap(image, null, Coords, null);

	}
}
