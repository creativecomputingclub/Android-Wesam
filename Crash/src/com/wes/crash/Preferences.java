package com.wes.crash;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.widget.Toast;

public class Preferences extends PreferenceFragment{
	
	Intent i;
	final static int cameraData = 0;
	Preference button = (Preference)findPreference("camera");
	

    @Override
	public void onCreate(final Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    	button.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference arg0) { 
                i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,cameraData);
                return true;
            }
        });
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();
    }

    @Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == Activity.RESULT_OK){
			Bundle extras = data.getExtras();
			Bitmap bmp = (Bitmap) extras.get("data");
			Toast.makeText(getActivity(), "Image saved to:\n" +
                    data.getData(), Toast.LENGTH_LONG).show();
			
		}
	}


	public static class MyPreferenceFragment extends PreferenceFragment{
        @Override
        public void onCreate(final Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.prefs);
        }
    }

    

}