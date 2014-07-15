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
	public Pacer(final Bitmap image, final ArrayList<BaseGameObject> BL, double thr, final float w, final float h) {
		this.BL = BL;
		T = new ResetTimer(thr) {
			public void reset() {
				super.reset();
				BaseGameObject Temp;
				float f = (float)(Math.random())+.2f;
				if(f >= .81f) f = .8f;
				float x = (float) (Math.random()*(MainView.WT.getScreenWidth()-w));
				float y = -(float)(Math.random()*(MainView.WT.getScreenHeight()))-h;
				Temp = new BaseGameObject(image,x,y,w,h);
				Temp.setFrameVector(new Vector(0,f));
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
