package com.myapp.warest;
import android.os.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.content.*;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.HashMap;
import android.util.TypedValue;
import android.view.Gravity;

import android.graphics.Color;
import java.util.concurrent.*;
import java.util.*;

public class BookActivity extends AppCompatActivity
{
	FirebaseAuth auth;
	Button add;
	TextView bookqty;
	

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
		add = (Button)findViewById(R.id.btnadd);
        bookqty=(TextView)findViewById(R.id.qtyofbooks);
		
		bookqty.setText("10");


		add.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					//button functionality
					startActivity(new Intent(BookActivity.this, ConfirmActivity.class));
				}
			});


		

		
	
}}
