package com.wes.crash;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ViewSwitcher;

public class MainActivity extends Activity {
	Intent startGame;
	Button ib1,ib2;
	View v;
	
	protected void onCreate(Bundle savedInstanceState) {
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addListenerOnButton();
		addListenerOnButton2();
	}
	
	public void addListenerOnButton() {
		ib1 = (Button) findViewById(R.id.button);
	 
			ib1.setOnClickListener(new OnClickListener() {
	 
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent(MainActivity.this,ToMainView.class);
					startActivity(intent);
				}
	 
			});
	}
	
	public void addListenerOnButton2() {
		ib2 = (Button) findViewById(R.id.button2);
	 
			ib2.setOnClickListener(new OnClickListener() {
	 
				@Override
				public void onClick(View arg0) {
					Intent i = new Intent(MainActivity.this,ToTutorial.class);
					startActivity(i);
				}
	 
			});
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch(item.getItemId()){
        case R.id.Preferences:
        	Intent i = new Intent(MainActivity.this,Preferences.class);
        	startActivity(i);
		case R.id.Exit:
			finish();
        }
        return false;
    }
	
	public void onDraw(Canvas C) {
		//C.drawBitmap(Tile_Dirt, 0, 0, null);
	}

}