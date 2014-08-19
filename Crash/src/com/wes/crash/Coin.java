package com.wes.crash;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.kc.tools.Timer;
import com.kc.tools.Vector;

public class Coin extends BaseGameObject {
	Vector JumpVector;
	Vector GravityVector;
	Vector getAngle;
	Timer T;
	boolean HasJumped = false;
	boolean canbepressed;
	public Coin(Bitmap Coin,float x, float y, float w, float h, float jvy, float gvy) {
		super(Coin,x,y,w,h);
		getAngle = new Vector((float)(Math.random()*Math.PI));
		getAngle.scale(.8f,1.5f);
		JumpVector = new Vector(getAngle.getX(),jvy);
		GravityVector = new Vector(0,gvy);
	}
	public void Update(long mi) {
		super.Update(mi);
		if (!HasJumped) {
			FrameVector.add(JumpVector.getX(),JumpVector.getY());
			HasJumped = true;
		}
		FrameVector.add(GravityVector.getX(),GravityVector.getY());
		if (FrameVector.getY() > 0) canbepressed = true;
	}
	public void Draw(Canvas C) {
		super.Draw(C);
	}
	public Timer getT() {
		return T;
	}
	public void setT(Timer t) {
		T = t;
	}
	public boolean isCanbepressed() {
		return canbepressed;
	}
	public void setCanbepressed(boolean canbepressed) {
		this.canbepressed = canbepressed;
	}
}
