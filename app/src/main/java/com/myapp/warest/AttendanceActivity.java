package com.myapp.warest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.content.*;
public class AttendanceActivity extends AppCompatActivity
{
	TextView name, usn;
	
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
		name= (TextView)findViewById(R.id.name);
		usn = (TextView)findViewById(R.id.usn);
	
	}
	
	
	
}
