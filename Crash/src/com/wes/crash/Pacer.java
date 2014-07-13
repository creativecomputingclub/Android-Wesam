package com.wes.crash;

import java.util.ArrayList;

import android.graphics.Canvas;

import com.kc.inter.Drawable;
import com.kc.inter.Updatable;
import com.kc.main.MainView;
import com.kc.tools.ResetTimer;
import com.kc.tools.Vector;

public class Pacer implements Updatable, Drawable{
	ArrayList<BaseGameObject> BL;
	ResetTimer T;
	public Pacer(final ArrayList<BaseGameObject> BL, double thr) {
		this.BL = BL;
		T = new ResetTimer(thr) {
			public void reset() {
				super.reset();
				BaseGameObject Temp;
				float w = 245*.6f;
				float h = 269*.6f;
				float x = (float) (Math.random()*(MainView.WT.getScreenWidth()-w));
				float y = -(float)(Math.random()*(MainView.WT.getScreenHeight()))-h;
				Temp = new BaseGameObject(MainView.Bubble_Image,x,y,w,h);
				Temp.setFrameVector(new Vector(0,(float)(Math.random())));
				BL.add(Temp);
			}
		};
	}
	public void Update(long mi) {
		T.Update(mi);
	}
	public void Draw(Canvas C) {
		
	}
}
