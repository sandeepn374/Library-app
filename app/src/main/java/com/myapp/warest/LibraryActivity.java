package com.myapp.warest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.content.*;

public class LibraryActivity extends AppCompatActivity {
	
	
	Button stn, btn2, btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
		stn = (Button)findViewById(R.id.button1);
		//btn3=(Button)findViewById(R.id.button3);
		//btn2=(Button)findViewById(R.id.button2);
		//btn4=(Button)findViewById(R.id.button4);
		
		
stn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					//button functionality
					startActivity(new Intent(LibraryActivity.this, BookActivity.class));
				}
			});
		
		
		
		
    }
}




