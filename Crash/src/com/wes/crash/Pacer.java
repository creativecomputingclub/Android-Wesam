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
	float limit, y, x;
	float minspeed, maxspeed;
	public int loc;
	public int SpawnObect;
	public static final int COIN = 0, GLASS_SPHERE = 1;
	public static final int NORTH = 0, SOUTH = 1, EAST = 2, WEST = 3;
	public Pacer(final Bitmap image, final ArrayList<BaseGameObject> BL, double thr, final float w, final float h) {
		this.BL = BL;
		limit = 10f;
		minspeed = .4f;
		maxspeed = 1f;
		setSpawnObject(GLASS_SPHERE);
		T = new ResetTimer(thr) {
			public void reset(){
				if (BL.size() < limit) {
					super.reset();
					spawnObject();
					System.out.println(System.currentTimeMillis());
				}
			}
		};
	}
	public void spawnObject(){
		
		addToList(null);
	}
	public void addToList(BaseGameObject BGO) {
		
	}
	public void getLocation(){
		
	}
	public void Update(long mi) {
		T.Update(mi);
	}
	public void Draw(Canvas C) {
		
	}
	public void setSpawnLocation(int loc) {
		this.loc = loc;

	}
	public void setSpawnObject(int o) {
		SpawnObect = o;
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
	public float getMaxspeed() {
		return maxspeed;
	}
	public void setMaxspeed(float maxspeed) {
		this.maxspeed = maxspeed;
	}
	
}
