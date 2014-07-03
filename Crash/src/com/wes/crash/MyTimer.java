package com.wes.crash;

public class MyTimer {
	int counter;
	int thresh;
	
	public MyTimer(){
		thresh = 100; // Default timer
		
	}
	public MyTimer(int t){
		thresh = t;
	}
	public void inc(){
		counter++;
	}
	public boolean isOver(){
		boolean v = counter >= thresh;
		if(v)
			counter = 0;
		return v;
	}

}
