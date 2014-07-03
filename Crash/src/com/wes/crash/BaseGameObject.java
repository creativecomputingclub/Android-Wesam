package com.wes.crash;

import android.graphics.Canvas;

import com.kc.inter.Drawable;
import com.kc.inter.Updatable;

public class BaseGameObject implements Updatable, Drawable{
	//Here is what the Base Object should look like. Every object will have a vector and an image.
	// Every object knows how to update and draw
	// Vector
	// Image
	public BaseGameObject() {
		
	}
	@Override
	public void Update(long mi) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Draw(Canvas C) {
		// TODO Auto-generated method stub
		
	}

}
