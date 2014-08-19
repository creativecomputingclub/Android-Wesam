package com.kc.main;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.Point;

import com.wes.crash.GlassSphere;
import com.wes.crash.BaseGameObject;
import com.wes.crash.Coin;
import com.wes.crash.Pacer;

public class ClassicPacer extends Pacer {
	
	public ClassicPacer(Bitmap image, ArrayList<BaseGameObject> BL, double thr,float w, float h) {
		super(image, BL, thr, w, h);

	}
	public void spawnObject() {
		BaseGameObject BGO = null;
		final int so = SpawnObect;
		setSpawnLocation(super.NORTH);
		switch(so) {
			case COIN:{
				float w = 100;
				float h = 100;
				Point P = getLocation(loc,w,h);
				BGO = new Coin(MainView.Coin_Image,P.x,P.y,w,h, -1.5f, .1f);
				break;
			}
			case GLASS_SPHERE:{
				float w = 154;
				float h = 148;
				Point P = getLocation(super.NORTH,w,h);
				BGO = new GlassSphere(MainView.Sphere_Image,P.x,P.y,w,h);
				BGO.setFVY(.8f);
				break;
			}
		}
		addToList(BGO);
	}
	
	
	
	
	
	public Point getLocation(int l, float w, float h) {
		int x = 0;
		int y = 0;
		switch(l){
			case NORTH:{
				x = (int)(Math.random()*(MainView.WT.getScreenWidth()-w));
				y = (int)-h;
				break;
			}
			case SOUTH:{
				x = (int)(Math.random()*(MainView.WT.getScreenWidth()-w));
				y = (int)((MainView.WT.getScreenHeight())+h);
				break;
			}
			case EAST:{
				x = (int) ((MainView.WT.getScreenWidth())+w);
				y = (int)(Math.random())*(MainView.WT.getScreenHeight());
				break;
			}
			case WEST:{
				x = (int)-w;
				y = (int)(Math.random())*(MainView.WT.getScreenHeight());
				break;
			}
		}
		Point P = new Point();
		P.set(x, y);
		return P;
	}

}
