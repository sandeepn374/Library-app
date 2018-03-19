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

import java.util.concurrent.*;

public class VerificationActivity extends AppCompatActivity
{
	
	
	TextView name, email, phone, gender, semester, department, usn;
	
	FirebaseAuth auth; 
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
		  
		name = (TextView)findViewById(R.id.name);
		email = (TextView)findViewById(R.id.email);
		phone = (TextView)findViewById(R.id.phone);
		gender = (TextView)findViewById(R.id.gender);
		semester = (TextView)findViewById(R.id.sem);
		department = (TextView)findViewById(R.id.dept);
		usn = (TextView)findViewById(R.id.usn);
		
		
		
		auth = FirebaseAuth.getInstance();
        final FirebaseUser u=auth.getCurrentUser();
		
		
		
		DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");
        mDatabase.keepSynced(true);
		mDatabase.addValueEventListener(new ValueEventListener() {

				@Override
				public void onDataChange(DataSnapshot p1)
				{
					for (DataSnapshot child : p1.getChildren()) {


						if(child.child("email").getValue().toString().equals(auth.getCurrentUser().getEmail())){
							name.setText("Name :  " +child.child("name").getValue().toString());

							email.setText("Email   :  "+child.child("email").getValue().toString());

							phone.setText("Phone : "+child.child("phone").getValue().toString());

							gender.setText("Gender  : "+child.child("gender").getValue().toString());

							semester.setText("Sem :  "+   child.child("sem").getValue());

							department.setText("Department : "+child.child("dept").getValue());

							usn.setText( "USN : "+child.child("usn").getValue().toString());

							

						}
				}

}
				@Override
				public void onCancelled(DatabaseError p1)
				{

				}
				
		
		});
		
		
		}
	
	
	
	
}
