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

import java.util.concurrent.*;
import java.util.*;
public class AttendanceActivity extends AppCompatActivity
{
	TextView name, usn;
	FirebaseAuth auth;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
		String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();




		FirebaseDatabase.getInstance().getReference().child("users").child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
				@Override
				public void onDataChange(DataSnapshot dataSnapshot) {
					String s=(String) dataSnapshot.getValue().toString();



					final User user = dataSnapshot.getValue(User.class);

					LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT,
																					 TableLayout.LayoutParams.WRAP_CONTENT);
					TextView tv1 = new TextView(AttendanceActivity.this);
					tv1.setTextSize(25);


					TextView tv2 = new TextView(AttendanceActivity.this);
					tv2.setTextSize(25);
					
					tv1.setText("Name - " + user.name);
					tv2.setText("Usn- " + user.usn);
					
					TableRow.LayoutParams trparams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
					tv1.setLayoutParams(trparams);
					tv2.setLayoutParams(trparams);
					
					
					TableLayout layoutINNER = new TableLayout(AttendanceActivity.this);
					

					layoutINNER.setLayoutParams(params);

					TableRow tr = new TableRow(AttendanceActivity.this);
					tr.setLayoutParams(params);
					tr.addView(tv1);

					TableRow tr2 = new TableRow(AttendanceActivity.this);
					tr2.setLayoutParams(params);
					tr2.addView(tv2);

					
					layoutINNER.addView(tr);

					
					layoutINNER.addView(tr2);

					
					LinearLayout main = (LinearLayout) findViewById(R.id.main_layout);
					main.addView(layoutINNER);
				}

				@Override
				public void onCancelled(DatabaseError databaseError) {
				}
			});        
		
	}
	
	
	
}
