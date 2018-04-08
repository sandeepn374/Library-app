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
import android.text.method.*;

public class BookActivity extends AppCompatActivity
{
	FirebaseAuth auth;
	Button add, add2;
	TextView bookqty, bookqty2,mLink, textField;
	int qtyvalue=10;
	int qtyvalue2=9;
	

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
		add = (Button)findViewById(R.id.btnadd);
        bookqty=(TextView)findViewById(R.id.qtyofbooks);
		bookqty2=(TextView)findViewById(R.id.qtyofbooks2);
		add2=(Button)findViewById(R.id.btnadd2);
		textField=(TextView)findViewById(R.id.book2);
		textField.setText("2.The Telecom Regulatory " + System.getProperty("line.separator") + "      of India");
		
		
		mLink = (TextView) findViewById(R.id.link);
		if (mLink != null) {
			mLink.setMovementMethod(LinkMovementMethod.getInstance());
		}
		bookqty.setText(Integer.toString(qtyvalue));
		bookqty2.setText(Integer.toString(qtyvalue2));

		add.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					//button functionality
					startActivity(new Intent(BookActivity.this, ConfirmActivity.class));
					qtyvalue--;
					bookqty.setText(Integer.toString(qtyvalue));
					
				}
			});


		
		add2.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					//button functionality
					startActivity(new Intent(BookActivity.this, RegulatoryActivity.class));
					qtyvalue2--;
					bookqty2.setText(Integer.toString(qtyvalue2));

				}
			});
		
		
	
}}
