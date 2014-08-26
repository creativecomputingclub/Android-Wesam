package com.wes.crash;

import com.kc.tools.Z;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class GlassSphere extends BaseGameObject { 
	
	public GlassSphere(Root root,Bitmap copy, float x, float y, float w, float h) {
		super(root,copy,x,y,w,h);

	}
	public void Update() {

	} 
	public void Draw(Canvas C) {
		super.Draw(C);
		
	}
	public void doPressLogic() {
		Rect TES = new Rect((int)root.getPressX(),(int)root.getPressY(),(int)root.getPressX(),(int)root.getPressY());
		if(root.isIspress() == true) {
			boolean b = isColliding(TES, 20);
			if (b == true) {
				float bgx = getX();
				float bgy = getY();
				float bgw = getW();
				float bgh = getH();
				float ret = 1.2f;
				float coinw = bgw * ret;
				float coinh = bgh * ret;
				float midx = bgx + (bgw/2);
				float midy = bgy + (bgh/2);
				float coinx = midx - (coinw/2);
				float coiny = midy - (coinh/2);	
				Bitmap Image = null;
				boolean RedCoinAppeared = false;
				if(Z.score == Z.SCORE_RED_RANDOM) {
					Image = Z.Red_Coin;
					RedCoinAppeared = true;
				}
				else if(Z.score <= Z.SCORE_NORMAL_HIGH) Image = Z.Coin_Image;
				else if(Z.score >= Z.SCORE_BLUE_LOW && Z.score <= Z.SCORE_BLUE_HIGH) Image = Z.Blue_Coin;
				else if(Z.score >= Z.SCORE_GREEN_LOW) Image = Z.Green_Coin;
				root.getBGOS().add(new Coin(root,Image,coinx,coiny,coinw,coinh, -1.5f,.1f));
				setIsdead(true);
				root.setIspress(false);
				if(RedCoinAppeared == true) {
					Z.SCORE_RED_RANDOM = (int) (Math.random()*100)*10;
					RedCoinAppeared = false;
				}
			}
		}
	}
	public void doRemovalLogic() {
		if (getY() > Z.WT.getScreenHeight()){
			setIsdead(true);
		}
	}

}
