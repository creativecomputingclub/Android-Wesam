package com.kc.tools;

public class Benchmark {										
	long Milliseconds, End, Start;	
	public Benchmark() {
		Start = System.currentTimeMillis();
	}
	public void update() {
		End = System.currentTimeMillis();	
		Milliseconds = End - Start;					
		Start = End;	
	}
	public long getMillisecondsElapsed() {
		return Milliseconds;
	}
}
