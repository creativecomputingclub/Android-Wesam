package com.wes.crash;

public class Ball {
	private int speedX = 0;
	private int speedY = 0;
	private boolean falling = true;
	
	public void Update() {
		if(falling == true)
			speedY = 10;
	} // i dont know what the ball is really going to be doing besides falling so i left it at that

}
