package com.wes.crash;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.kc.inter.Drawable;
import com.kc.inter.Updatable;
import com.kc.main.MainView;
import com.kc.tools.ResetTimer;
import com.kc.tools.Vector;

public class Pacer implements Updatable, Drawable{
	ArrayList<BaseGameObject> BL;
	ResetTimer T;
	float limit;
	float minspeed;
	public Pacer(final Bitmap image, final ArrayList<BaseGameObject> BL, double thr, final float w, final float h) {
		this.BL = BL;
		limit = 10f;
		minspeed = .4f;
		T = new ResetTimer(thr) {
			public void reset() {
				if (BL.size() < limit) {
					super.reset();
					BaseGameObject Temp;
					float f = (float)(Math.random()-minspeed)+minspeed;
					float x = (float) (Math.random()*(MainView.WT.getScreenWidth()-w));
					float y = -(float)(Math.random()*(MainView.WT.getScreenHeight()))-h;
					Temp = new BaseGameObject(image,x,y,w,h);
					Temp.setFrameVector(new Vector(0,f));
					BL.add(Temp);
				}
			}
		};
	}
	public void Update(long mi) {
		T.Update(mi);
	}
	public void Draw(Canvas C) {
		
	}
	public ResetTimer getT() {
		return T;
	}
	public void setT(ResetTimer t) {
		T = t;
	}
	public float getLimit() {
		return limit;
	}
	public void setLimit(float limit) {
		this.limit = limit;
	}
	public float getMinspeed() {
		return minspeed;
	}
	public void setMinspeed(float minspeed) {
		this.minspeed = minspeed;
	}
	
}
