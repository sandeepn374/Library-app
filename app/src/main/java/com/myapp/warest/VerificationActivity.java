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

public class VerificationActivity extends AppCompatActivity
{
	
	
	FirebaseAuth auth; 
	 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
		DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("users");
		mDatabase
			.addListenerForSingleValueEvent(new ValueEventListener() {
				@Override
				public void onDataChange(DataSnapshot dataSnapshot) {
					//int totDue=0;
					//if(child.child("email").getValue().toString().equals(auth.getCurrentUser().getEmail())){
					
					ArrayList<User> users=new ArrayList<User>();
					for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
						final User user = snapshot.getValue(User.class);

						
			
					
					
					//for(final User user:users) {
						LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT,
																						 TableLayout.LayoutParams.WRAP_CONTENT);
						TextView tv1 = new TextView(VerificationActivity.this);
						TextView tv2 = new TextView(VerificationActivity.this);

						TextView tv3 = new TextView(VerificationActivity.this);

						TextView tv4 = new TextView(VerificationActivity.this);

						TextView tv5 = new TextView(VerificationActivity.this);

						TextView tv0 = new TextView(VerificationActivity.this);
					TextView tv6 = new TextView(VerificationActivity.this);


						
						tv1.setText("Name - " + user.name);
						tv2.setText("Phone - " + user.ph);
						tv3.setText("Email - " + user.email);
						tv6.setText("Gender - "  + user.gender);
						tv4.setText("Department  - " + user.department);
						tv5.setText("Sem  - " + user.semester);
						tv0.setText("USN - " + user.usn);
						//totDue += user.due;
						TableRow.LayoutParams trparams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);
						tv1.setLayoutParams(trparams);
						tv2.setLayoutParams(trparams);
						tv3.setLayoutParams(trparams);
						tv4.setLayoutParams(trparams);
						tv5.setLayoutParams(trparams);
						tv0.setLayoutParams(trparams);
						tv6.setLayoutParams(trparams);
						//tv0.setTextColor(Color.RED);
						
						TableRow tr0 = new TableRow(VerificationActivity.this);

						TableLayout layoutINNER = new TableLayout(VerificationActivity.this);

						tr0.setLayoutParams(params);
						tr0.addView(tv0);
						


						layoutINNER.setLayoutParams(params);
						TableRow tr = new TableRow(VerificationActivity.this);

						tr.setLayoutParams(params);
						tr.addView(tv1);
						TableRow tr2 = new TableRow(VerificationActivity.this);

						tr2.setLayoutParams(params);
						tr2.addView(tv2);

						TableRow tr3 = new TableRow(VerificationActivity.this);

						tr3.setLayoutParams(params);
						tr3.addView(tv3);


						TableRow tr6 = new TableRow(VerificationActivity.this);

						tr6.setLayoutParams(params);
						tr6.addView(tv4);

						TableRow tr7 = new TableRow(VerificationActivity.this);

						tr7.setLayoutParams(params);
						tr7.addView(tv5);
						TableRow tr8 = new TableRow(VerificationActivity.this);

						tr8.setLayoutParams(params);
						tr8.addView(tv6);
						
						layoutINNER.addView(tr);
						

						layoutINNER.addView(tr3);
						
						layoutINNER.addView(tr2);
						
						layoutINNER.addView(tr8);
						
						
						
						layoutINNER.addView(tr6);
						
						layoutINNER.addView(tr7);
						
						layoutINNER.addView(tr0);
						
						
						
						LinearLayout main = (LinearLayout) findViewById(R.id.main_layout);

						main.addView(layoutINNER);

					}

					//  }
					//System.out.println(user.email);
					// }



				}
			//	}
				

				@Override
				public void onCancelled(DatabaseError databaseError) {
				}
			});
        
    }
	 
	
	
}





