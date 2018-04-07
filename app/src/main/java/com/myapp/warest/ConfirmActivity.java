package com.myapp.warest;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;



public class ConfirmActivity extends AppCompatActivity
{
	
	FirebaseAuth auth;

	String time;
	String time1;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
		
		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");// HH:mm:ss");
		String reg_date = df.format(c.getTime());
		//showtoast("Currrent Date Time : "+reg_date);

		c.add(Calendar.DATE, 4);  // number of days to add
		time = df.format(c.getTime());
		

		Calendar c1 = Calendar.getInstance();
		SimpleDateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");// HH:mm:ss");
		String reg_date1 = df.format(c.getTime());
		//showtoast("Currrent Date Time : "+reg_date);

		c1.add(Calendar.DATE, 0);  // number of days to add
		time1 = df.format(c1.getTime());
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
		
		
		String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();




		FirebaseDatabase.getInstance().getReference().child("users").child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
				@Override
				public void onDataChange(DataSnapshot dataSnapshot) {
					String s=(String) dataSnapshot.getValue().toString();



					final User user = dataSnapshot.getValue(User.class);

					LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT,
																					 TableLayout.LayoutParams.WRAP_CONTENT);
					TextView tv1 = new TextView(ConfirmActivity.this);
					tv1.setTextSize(24);
					tv1.setTextColor(Color.BLACK);

					TextView tv2 = new TextView(ConfirmActivity.this);
					tv2.setTextSize(24);
					tv2.setTextColor(Color.BLACK);
					TextView tv3 = new TextView(ConfirmActivity.this);
					tv3.setTextSize(24);
					tv3.setTextColor(Color.BLACK);
					TextView tv4 = new TextView(ConfirmActivity.this);
					tv4.setTextSize(24);
					tv4.setTextColor(Color.BLACK);
					TextView tv5 = new TextView(ConfirmActivity.this);
					tv5.setTextSize(24);
					tv5.setTextColor(Color.BLACK);
					/*TextView tv0 = new TextView(ConfirmActivity.this);
					tv0.setTextSize(27);
					tv0.setTextColor(Color.BLACK);
					TextView tv6 = new TextView(ConfirmActivity.this);
					tv6.setTextSize(27);
					tv6.setTextColor(Color.BLACK);*/


					tv1.setText("Name - " + user.name);
					tv2.setText("Usn- " + user.usn);
					tv3.setText("Book - The Telecom Handbook");
					//tv6.setText("Gender - "  + user.gender);
					tv4.setText("Validity - " + time);
					tv5.setText("Issue Date - " + time1);
					//tv0.setText("USN - " + user.usn);*/

					TableRow.LayoutParams trparams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
					tv1.setLayoutParams(trparams);
					tv2.setLayoutParams(trparams);
					tv3.setLayoutParams(trparams);
					tv4.setLayoutParams(trparams);
					tv5.setLayoutParams(trparams);
					/*tv0.setLayoutParams(trparams);
					tv6.setLayoutParams(trparams);*/

					TableRow tr0 = new TableRow(ConfirmActivity.this);

					TableLayout layoutINNER = new TableLayout(ConfirmActivity.this);
					tr0.setLayoutParams(params);
					//tr0.addView(tv0);


					layoutINNER.setLayoutParams(params);

					TableRow tr = new TableRow(ConfirmActivity.this);
					tr.setLayoutParams(params);
					tr.addView(tv1);

					TableRow tr2 = new TableRow(ConfirmActivity.this);
					tr2.setLayoutParams(params);
					tr2.addView(tv2);

					TableRow tr3 = new TableRow(ConfirmActivity.this);
					tr3.setLayoutParams(params);
					tr3.addView(tv3);

					TableRow tr6 = new TableRow(ConfirmActivity.this);
					tr6.setLayoutParams(params);
					tr6.addView(tv4);
					

					TableRow tr7 = new TableRow(ConfirmActivity.this);
					
					Button paid = new Button(ConfirmActivity.this);
					paid.setText("SEND");
					paid.setTextColor(Color.BLACK);
					paid.setGravity(Gravity.CENTER);
					int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());
					int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
					paid.setLayoutParams(new TableRow.LayoutParams(width, height));
					// paid.setWidth(5);

					tr7.setLayoutParams(params);
					tr7.addView(paid);

					
					
					TableRow tr8 = new TableRow(ConfirmActivity.this);
					tr8.setLayoutParams(params);
					tr8.addView(tv5);

					layoutINNER.addView(tr);
					

					layoutINNER.addView(tr2);

					layoutINNER.addView(tr3);


					layoutINNER.addView(tr8);

					layoutINNER.addView(tr6);

					layoutINNER.addView(tr7);

					layoutINNER.addView(tr0);

					LinearLayout main = (LinearLayout) findViewById(R.id.main_layout);
					main.addView(layoutINNER);
				}

				@Override
				public void onCancelled(DatabaseError databaseError) {
				}
			}); 
		
		
	
	}
	
}
