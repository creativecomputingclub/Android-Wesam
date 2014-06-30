package com.kc.tools;

import com.kc.inter.Updatable;

public class Timer implements Updatable{
	float time;
	boolean go;
	public Timer() {
		start();
	}
	public void Update(long mi) {
		if (go) time += mi;
	}
	public void start() {
		go = true;
	}
	public void stop() {
		go = false;
	}
	public float getSeconds() {
		return time / 1000f;
	}
	public float getMilliseconds() {
		return time;
	}
	public void reset() {
		time = 0;
	}
}
