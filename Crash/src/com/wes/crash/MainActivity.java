package com.wes.crash;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;

import com.kc.main.MainView;

public class MainActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new MainView(this));
	}
	
}