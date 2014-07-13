package com.kc.tools;

public class Vector {
	float x, y;
	
	
	public Vector(float x, float y) {
		this.x = x;
		this.y = y;
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

	public Vector() {
		super();
		// TODO Auto-generated constructor stub
	}

	public float getLength() {
		return (float) Math.sqrt((x*x)+(y*y));
	}
	
	public float angle() {
		return (float) Math.atan2(y, x);
	}
	
	public void add(float mag) {
		x += mag;
		y += mag;
	}
	
	public void add(float xmag, float ymag) {
		x += xmag;
		y += ymag;
	}
	
	public void substract(float mag) {
		x -= mag;
		y -= mag;
	}
	
	public void substract(float xmag, float ymag) {
		x -= xmag;
		y -= ymag;
	}
	
	public void scale(float mag) {
		x *= mag;
		y *= mag;
	}
	
	public void scale(float xmag, float ymag) {
		x *= xmag;
		y *= ymag;
	}
	
	public void normalize() {
		float L = this.getLength();
		x /= L;
		y /= L;
	}

}
