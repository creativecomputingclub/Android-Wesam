package com.kc.tools;

public class ResetTimer  extends Timer{
	double threshold;
	public ResetTimer(double thresh) {
		super();
		setThreshold(thresh);
	}
	public void Update(long mi) {
		super.Update(mi);
		if (super.getMilliseconds() >= this.getThreshold()) reset();
		
	}
	public void reset() {
		super.reset();
	}
	public double getThreshold() {
		return threshold;
	}
	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}

}
