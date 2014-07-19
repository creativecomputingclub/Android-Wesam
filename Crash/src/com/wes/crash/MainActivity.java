package com.wes.crash;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

import com.kc.main.MainView;

public class MainActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		super.onCreate(savedInstanceState);
		setContentView(new MainView(this));
	}
	
}