package com.wes.crash;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.kc.inter.Drawable;
import com.kc.inter.Updatable;
import com.kc.tools.Vector;

public class BaseGameObject implements Updatable, Drawable {
	Bitmap image;
	float x, y, w, h;
	Vector FrameVector;
	Rect Coords;
	Root root;
	boolean isdead;
	public BaseGameObject(Root root, Bitmap image, float x, float y, float w, float h) {
		this.root = root;
		FrameVector = new Vector();
		this.image = image;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		Coords = new Rect((int) x, (int) y, (int) (x + w), (int) (y + h));
	}
	public void Update(long mi) {
		x += FrameVector.getX()*mi;
		y += FrameVector.getY()*mi;
		Coords = new Rect((int)x,(int)y,(int)(x + w),(int)(y + h));
	}
	public void Draw(Canvas C) {
		C.drawBitmap(image, null,Coords, null);
	}
	public boolean isColliding(Rect R,int r) {
		if(x+w < R.left-r) return false;
		else if(R.right+2*r < x) return false;
		else if(R.top-r > y+h) return false;
		else if(y > R.bottom+2*r) return false;
		return true;
	}
	public boolean isColliding(Rect R) {
		return isColliding(R, 0);
	}
	public Bitmap getImage() {
		return image;
	}
	public void setImage(Bitmap image) {
		this.image = image;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getW() {
		return w;
	}

	public void setW(float w) {
		this.w = w;
	}

	public float getH() {
		return h;
	}

	public void setH(float h) {
		this.h = h;
	}

	public Vector getFrameVector() {
		return FrameVector;
	}
	public void setFrameVector(Vector frameVector) {
		FrameVector = frameVector;
	}
	public void setFVX(float x) {
		FrameVector.setX(x);
	}
	public void setFVY(float y) {
		FrameVector.setY(y);
	}
	public void addVector(Vector V) {
		FrameVector.add(V.getX(),V.getY());
	}
	public Rect getCoords() {
		return Coords;
	}

	public void setCoords(Rect coords) {
		Coords = coords;
	}
	public void doPressLogic() {
		
	}
	public void doRemovalLogic() {
		
	}
	public boolean isIsdead() {
		return isdead;
	}
	public void setIsdead(boolean isdead) {
		this.isdead = isdead;
	}
	
}
