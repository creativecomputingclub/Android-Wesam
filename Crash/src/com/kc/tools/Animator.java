package com.kc.tools;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;

import com.kc.inter.Drawable;
import com.kc.inter.Updatable;

public class Animator implements Drawable, Updatable{
	ArrayList<Rect> Frames;
	Bitmap Image;
	RectF Coordinates;
	Timer FTimer;
	int CurrentFrame;
	float threshold;
	public Animator(float threshold,RectF Coordinates,Bitmap Image, ArrayList<Rect> Frames) {
		setImage(Image);
		setFrames(Frames);
		setCoordinates(Coordinates);
		setThreshold(threshold);
		setTimer(new Timer());
	}
	public void Update(long mi) {
		FTimer.Update(mi);
		if (FTimer.getMilliseconds() >= threshold) {
			CurrentFrame++;
			FTimer.reset();
			if (CurrentFrame >= Frames.size()) {
				CurrentFrame = 0;
			}
		}
	}
	public void Draw(Canvas C) {
		C.drawBitmap(Image, Frames.get(CurrentFrame), Coordinates,null);
	}
	public ArrayList<Rect> getFrames() {
		return Frames;
	}
	public void setFrames(ArrayList<Rect> frames) {
		Frames = frames;
	}
	public Bitmap getImage() {
		return Image;
	}
	public void setImage(Bitmap image) {
		Image = image;
	}
	public RectF getCoordinates() {
		return Coordinates;
	}
	public void setCoordinates(RectF coordinates) {
		Coordinates = coordinates;
	}
	public Timer getTimer() {
		return FTimer;
	}
	public void setTimer(Timer fTimer) {
		FTimer = fTimer;
	}
	public int getCurrentFrame() {
		return CurrentFrame;
	}
	public void setCurrentFrame(int currentFrame) {
		CurrentFrame = currentFrame;
	}
	public float getThreshold() {
		return threshold;
	}
	public void setThreshold(float threshold) {
		this.threshold = threshold;
	}
	
}
