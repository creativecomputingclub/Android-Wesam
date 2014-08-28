package com.wes.crash;

import com.kc.tools.Z;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Bomb extends BaseGameObject {
	
	
	public Bomb(Root root,Bitmap bomb, float x, float y, float w, float h) {
		super(root,bomb, x, y, w, h);
	}
	public void Update(long mi) {
		super.Update(mi);
	}
	public void Draw(Canvas C) {
		super.Draw(C);
	}
	public void doPressLogic(){
		Rect TES = new Rect((int)root.getPressX(),(int)root.getPressY(),(int)root.getPressX(),(int)root.getPressY());
		if(root.isIspress() == true) {
			boolean b = isColliding(TES, 20);
			if (b == true) {
				setIsdead(true);
			}
		}
	}
	public void doRemovalLogic() {
		if (getY() > Z.WT.getScreenHeight()){
			setIsdead(true);
		}
	}

}
