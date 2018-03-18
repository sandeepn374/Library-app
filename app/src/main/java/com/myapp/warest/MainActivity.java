package com.myapp.warest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.content.*;

public class MainActivity extends AppCompatActivity {
	
	
	Button stn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		stn = (Button)findViewById(R.id.button1);
		
stn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					//button functionality
					startActivity(new Intent(MainActivity.this, BookActivity.class));
				}
			});
		
		
		
		
    }
}




