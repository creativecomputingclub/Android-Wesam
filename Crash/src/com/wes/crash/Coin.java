package com.wes.crash;

import android.graphics.Bitmap;

import com.kc.tools.Vector;

public class Coin extends BaseGameObject {
	Vector JumpVector;
	Vector GravityVector;
	Vector getAngle;
	boolean HasJumped = false;
	public Coin(Bitmap Coin,float x, float y, float w, float h, float jvy, float gvy) {
		super(Coin,x,y,w,h);
		getAngle = new Vector((float)(Math.random()*Math.PI));
		getAngle.scale(.045f,1);
		JumpVector = new Vector(getAngle.getX(),jvy);
		GravityVector = new Vector(getAngle.getX(),gvy);
	}
	public void update(long mi) {
		super.Update(mi);
		if (!HasJumped) {
			FrameVector.add(JumpVector.getX(),JumpVector.getY());
			HasJumped = true;
		}
		FrameVector.add(GravityVector.getX(),GravityVector.getY());
	}
	
}
