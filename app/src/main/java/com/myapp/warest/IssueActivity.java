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
import java.util.ArrayList;
import java.util.HashMap;
import android.util.TypedValue;
import android.view.Gravity;


import android.graphics.Color;
import java.util.concurrent.*;
import java.util.*;
import android.text.method.*;
import android.util.*;
public class IssueActivity extends AppCompatActivity
{

	FirebaseAuth auth;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
		String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();




		FirebaseDatabase.getInstance().getReference().child("users").child(uid).child("Book Issued").child("").addListenerForSingleValueEvent(new ValueEventListener() {
				@Override
				public void onDataChange(DataSnapshot dataSnapshot) {



					for (DataSnapshot chidSnap : dataSnapshot.getChildren()) {
						Log.v("tmz", "" + chidSnap.getKey()); //displays the key for the node
						Log.v("tmz", "" + chidSnap.getValue());   //gives the value for given keyname
					String child = (String) chidSnap.getValue();
					Log.i("child",""+child);
					/*String s=(String) dataSnapshot.getValue().toString();
			
					Log.e("sand",""+s);
					
					
					String[] parts = s.split("=");
					String part1 = parts[0];
					String part2 = parts[1]; 
					
					
					
					
					
					
					String[] parts1 = part2.split(",");
					String part3 = parts1[0]; // 004-
//					String part4 = parts1[1];
					
					
				*/
						//final User user = dataSnapshot.getValue(User.class);

						LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT,
								TableLayout.LayoutParams.WRAP_CONTENT);
						TextView tv1 = new TextView(IssueActivity.this);
						tv1.setTextSize(13);
						tv1.setTextColor(Color.BLACK);

						//TextView tv2 = new TextView(IssueActivity.this);
						//tv2.setTextSize(25);
						//tv2.setTextColor(Color.BLACK);

						tv1.setText("Book-" + chidSnap.getValue());
						//tv2.setText("Usn- " + user.usn);

						TableRow.LayoutParams trparams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
						tv1.setLayoutParams(trparams);
						//tv2.setLayoutParams(trparams);


						TableLayout layoutINNER = new TableLayout(IssueActivity.this);


						layoutINNER.setLayoutParams(params);

						TableRow tr = new TableRow(IssueActivity.this);
						tr.setLayoutParams(params);
						tr.addView(tv1);

						//TableRow tr2 = new TableRow(IssueActivity.this);
						//tr2.setLayoutParams(params);
						//tr2.addView(tv2);


						//TableRow tr4 = new TableRow(IssueActivity.this);


					/*Button paid = new Button(IssueActivity.this);
					paid.setText("SEND");
					paid.setTextColor(Color.BLACK);
					paid.setGravity(Gravity.CENTER);
					int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());
					int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
					paid.setLayoutParams(new TableRow.LayoutParams(width, height));
					// paid.setWidth(5);


					tr4.setLayoutParams(params);
					tr4.addView(paid);*/


						layoutINNER.addView(tr);

						//layoutINNER.addView(tr2);


						//layoutINNER.addView(tr4);


						LinearLayout main = (LinearLayout) findViewById(R.id.main_layout);
						main.addView(layoutINNER);
					}
				}

				@Override
				public void onCancelled(DatabaseError databaseError) {
				}
			});        

	}

}
