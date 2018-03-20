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
	TextView name, gender, emailid, phone,sem, dept,usn;
	
	FirebaseAuth auth; 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
		

        name=(TextView)findViewById(R.id.traineename);
        phone=(TextView)findViewById(R.id.ph);;
        dept=(TextView)findViewById(R.id.dept);
        emailid=(TextView)findViewById(R.id.traineeemail);

        gender=(TextView)findViewById(R.id.traineegender);
        sem=(TextView)findViewById(R.id.traineesem);
        usn=(TextView)findViewById(R.id.usn);




        auth = FirebaseAuth.getInstance();
		
		

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");
        mDatabase.keepSynced(true);
        mDatabase.addValueEventListener(new ValueEventListener() {

				@Override
				public void onCancelled(DatabaseError p1)
				{

				}


				@Override
				public void onDataChange(DataSnapshot dataSnapshot) {
					for (DataSnapshot child : dataSnapshot.getChildren()) {


						if(child.child("email").getValue().toString().equals(auth.getCurrentUser().getEmail())){
							name.setText("Name :  " +child.child("name").getValue().toString());

							emailid.setText("E mail :  " +child.child("email").getValue().toString());

							phone.setText("Ph   :  "+child.child("ph").getValue().toString());

							gender.setText("Gender : "+child.child("gender").getValue().toString());

							dept.setText("Dept : "+child.child("department").getValue().toString());

						sem.setText("Sem  :  "+   child.child("semester").getValue());

							usn.setText("usn: "+child.child("usn").getValue());



						}

					}
				}
			});



    }
		
		
    
	
	
		
		
	
	
	
	
}





