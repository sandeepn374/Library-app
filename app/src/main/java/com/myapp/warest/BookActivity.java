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
	Button add, add2, add3;
	TextView bookqty, bookqty2,bookqty3,mLink, textField, textField3;
	int qtyvalue=10;
	int qtyvalue2=15;
	int qtyvalue3=20;
	

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
		add = (Button)findViewById(R.id.btnadd);
        bookqty=(TextView)findViewById(R.id.qtyofbooks);
		bookqty2=(TextView)findViewById(R.id.qtyofbooks2);
		bookqty3=(TextView)findViewById(R.id.qtyofbooks3);
		add2=(Button)findViewById(R.id.btnadd2);
		add3=(Button)findViewById(R.id.btnadd3);
		textField=(TextView)findViewById(R.id.book2);
		textField3=(TextView)findViewById(R.id.book3);
		textField.setText("2. The Telecom Regulatory " + System.getProperty("line.separator") + "      of India");
		
		textField3.setText("3. Telecommunication New " + System.getProperty("line.separator") + "    Sign Posts to Old Roads");
		
		mLink = (TextView) findViewById(R.id.link);
		if (mLink != null) {
			mLink.setMovementMethod(LinkMovementMethod.getInstance());
		}
		bookqty.setText(Integer.toString(qtyvalue));
		bookqty2.setText(Integer.toString(qtyvalue2));
		bookqty3.setText(Integer.toString(qtyvalue3));

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
		
		add3.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					//button functionality
					startActivity(new Intent(BookActivity.this, TelecomActivity.class));
					qtyvalue3--;
					bookqty3.setText(Integer.toString(qtyvalue3));

				}
			});
	
}}
