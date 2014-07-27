package com.wes.crash;

import com.kc.main.MainView;

import android.app.Activity;
import android.os.Bundle;

public class ToMainView extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new MainView(this));
	}

}
