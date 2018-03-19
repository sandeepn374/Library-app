package com.myapp.warest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.content.*;

public class MainActivity extends AppCompatActivity
{
	 Button library, attend, idverify;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		library = (Button)findViewById(R.id.lib);
		attend = (Button)findViewById(R.id.attnd);
		idverify = (Button)findViewById(R.id.verify);
		
		library.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					//button functionality
					startActivity(new Intent(MainActivity.this, LibraryActivity.class));
				}
			});
		
		idverify.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					//button functionality
					startActivity(new Intent(MainActivity.this, VerificationActivity.class));
				}
			});
		
	}
}
