package com.wes.crash;

import com.kc.main.MainView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SettingActivity extends Activity {
	Button ib1,ib2;
	
	protected void onCreate(Bundle savedInstanceState) {
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting_activity);
	}
	
	/*public void addListenerOnButton() {
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
	}*/

}
