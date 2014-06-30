package com.kc.tools;

import java.util.ArrayList;

import android.graphics.Rect;

public class BitmapBreaker {
	public static ArrayList<Rect> split(int x, int y, int w, int h, int tr, int tc) {
		ArrayList<Rect> RL = new ArrayList<Rect>();
		int sx = x;
		int sy = y;
		for (int r = 0; r < tr; r++) {
			for (int c = 0; c < tc; c++) {
				Rect R = new Rect(sx, sy, sx+w, sy+h);
				RL.add(R);
				sx += w;
			}
			sx = x;
			sy += h;
		}
		return RL;
	}
}
