package com.wes.crash;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.kc.tools.Timer;
import com.kc.tools.Vector;
import com.kc.tools.Z;

public class Coin extends BaseGameObject {
	Vector JumpVector;
	Vector GravityVector;
	Vector getAngle;
	Timer T;
	boolean HasJumped = false;
	boolean canbepressed;
	public Coin(Root root,Bitmap Coin,float x, float y, float w, float h, float jvy, float gvy) {
		super(root,Coin,x,y,w,h);
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
	public void doPressLogic() {
		Rect TES = new Rect((int)root.getPressX(),(int)root.getPressY(),(int)root.getPressX(),(int)root.getPressY());
		if(root.isIspress() == true) {
			boolean b = isColliding(TES, 20);
			if (b == true && isCanbepressed()) {
				if(Z.score == Z.SCORE_RED_RANDOM) Z.score -= Z.SCORE_RED_DECREASE;
				else if(Z.score <= Z.SCORE_NORMAL_HIGH) Z.score += Z.SCORE_NORMAL_INCREASE;
				else if(Z.score >= Z.SCORE_BLUE_LOW && Z.score <= Z.SCORE_BLUE_HIGH) Z.score += Z.SCORE_BLUE_INCREASE;
				else if(Z.score >= Z.SCORE_GREEN_LOW) Z.score += Z.SCORE_GREEN_INCREASE;
				setIsdead(true);
				root.setIspress(false);
			}
		}
	}
	public void doRemovalLogic() {
		if (getY() > Z.WT.getScreenHeight()){
			setIsdead(true);
		}
	}
}
