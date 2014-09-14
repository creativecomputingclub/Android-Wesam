package com.kc.tools;

import com.wes.crash.BaseGameObject;

public class Bouncing {
	public static void bounce(BaseGameObject BGO, float x, float w) {
		float sw = Z.WT.getScreenWidth();
		if(x+w >= sw) {
			x = sw-w;
			BGO.setFVX(-BGO.getFrameVector().getX());
		}
		if(x <= 0) {
			x = -x;
			BGO.setFVX(-BGO.getFrameVector().getX());
		}
	}
}
