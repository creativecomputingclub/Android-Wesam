package com.wes.crash;

import com.kc.main.Tutorial;

import android.app.Activity;
import android.os.Bundle;

public class ToTutorial extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new Tutorial(this));
	}

}
