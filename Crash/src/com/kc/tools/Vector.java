package com.kc.tools;

public class Vector {
	float x, y;
	

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
	
	public void normadize() {
		float L = this.getLength();
		x /= L;
		y /= L;
	}

}
