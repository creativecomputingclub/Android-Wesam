package com.wes.crash;

import com.kc.tools.Z;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DeadActivity extends Activity{
	Button ib1,ib2,ib3;
	
	protected void onCreate(Bundle savedInstanceState) {
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dead_activity);
		addListenerOnButton();
		addListenerOnButton2();
		addListenerOnButton3();
		TextView myTextView = (TextView) findViewById(R.id.score); 
		myTextView.setText("Your score is " + Z.score);
	}
	
	public void addListenerOnButton() {
		ib1 = (Button) findViewById(R.id.playAgain);
	 
			ib1.setOnClickListener(new OnClickListener() {
	 
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent(DeadActivity.this,ToMainView.class);
					startActivity(intent);
				}
	 
			});
	}
	
	public void addListenerOnButton2() {
		ib2 = (Button) findViewById(R.id.quit);
	 
			ib2.setOnClickListener(new OnClickListener() {
	 
				@Override
				public void onClick(View arg0) {
					Intent i = new Intent(DeadActivity.this,MainActivity.class);
					startActivity(i);
				}
	 
			});
	}
	
	public void addListenerOnButton3() {
		ib3 = (Button) findViewById(R.id.deadSetting);
	 
			ib3.setOnClickListener(new OnClickListener() {
	 
				@Override
				public void onClick(View arg0) {
					Intent i = new Intent(DeadActivity.this,SettingActivity.class);
					startActivity(i);
				}
	 
			});
	}
}
