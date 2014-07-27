package com.wes.crash;

import com.kc.main.MainView;
import com.example.crash.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity {
	Bitmap bg, Tile_Dirt;
	Intent startGame;
	Button ib;
	View v;
	
	protected void onCreate(Bundle savedInstanceState) {
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bg = BitmapFactory.decodeResource(this.getResources(), R.drawable.sample);
		Tile_Dirt = BitmapFactory.decodeResource(this.getResources(), R.drawable.tiledirt);
		/*if (bg != null) {
            setBackgroundDrawable(new BitmapDrawable(bg));
        }*/
		addListenerOnButton();
	}
	
	private void setContentView() {
		// TODO Auto-generated method stub
		
	}

	public void addListenerOnButton() {
		ib = (Button) findViewById(R.id.button);
	 
			ib.setOnClickListener(new OnClickListener() {
	 
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent("android.intent.action.MAINVIEW");
					startActivity(intent);
				}
	 
			});
	}
	
	public void onDraw(Canvas C) {
		//C.drawBitmap(Tile_Dirt, 0, 0, null);
	}

}