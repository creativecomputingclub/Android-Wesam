package com.kc.main;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.Point;

import com.kc.tools.Timer;
import com.kc.tools.Z;
import com.wes.crash.BaseGameObject;
import com.wes.crash.Bomb;
import com.wes.crash.Coin;
import com.wes.crash.GlassSphere;
import com.wes.crash.Pacer;
import com.wes.crash.Root;

public class ClassicPacer extends Pacer {
	Root root;
	float speed = .6f;
	public ClassicPacer(Root root,Bitmap image, ArrayList<BaseGameObject> BL, double thr,float w, float h) {
		super(image, BL, thr, w, h);
		this.root = root;
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
				BGO = new Coin(root,Z.Coin_Image,P.x,P.y,w,h, -1.5f, .1f);
				break;
			}
			case GLASS_SPHERE:{
				float w = 154;
				float h = 148;
				Point P = getLocation(super.NORTH,w,h);
				BGO = new GlassSphere(root,Z.Sphere_Image,P.x,P.y,w,h);
				BGO.setFVY(speed);
				if (Math.random()*100 >= 80) super.setSpawnObject(BOMB);
				speed += .01;
				if (speed >= 2) {
					speed = 2f;
				}
				break;
			}
			case BOMB: {
				float w = 141;
				float h = 172;
				Point P = getLocation(super.NORTH,w,h);
				BGO = new Bomb(root,Z.Bomb_Image,P.x,P.y,w,h);
				BGO.setFVY(.8f);
				super.setSpawnObject(GLASS_SPHERE);
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
				x = (int)(Math.random()*(Z.WT.getScreenWidth()-w));
				y = (int)-h;
				break;
			}
			case SOUTH:{
				x = (int)(Math.random()*(Z.WT.getScreenWidth()-w));
				y = (int)((Z.WT.getScreenHeight())+h);
				break;
			}
			case EAST:{
				x = (int) ((Z.WT.getScreenWidth())+w);
				y = (int)(Math.random())*(Z.WT.getScreenHeight());
				break;
			}
			case WEST:{
				x = (int)-w;
				y = (int)(Math.random())*(Z.WT.getScreenHeight());
				break;
			}
		}
		Point P = new Point();
		P.set(x, y);
		return P;
	}

}
