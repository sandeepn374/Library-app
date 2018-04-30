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
import android.util.*;


public class BookActivity extends AppCompatActivity
{
	
	
	FirebaseAuth auth;
	Button add, add2, add3, add4, issue;
	TextView bookqty, bookqty2,bookqty3, bookqty4,mLink, textField, textField3, textField4;

	//int qtyvalue2=15;
	//int qtyvalue3=20;
	//int qtyvalue4= 9;
	String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

	private DatabaseReference mDatabase;



	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
		add = (Button)findViewById(R.id.btnadd);
        bookqty=(TextView)findViewById(R.id.qtyofbooks);
		bookqty2=(TextView)findViewById(R.id.qtyofbooks2);
		bookqty3=(TextView)findViewById(R.id.qtyofbooks3);
		bookqty4= (TextView)findViewById(R.id.qtyofbooks4);
		add2=(Button)findViewById(R.id.btnadd2);
		add3=(Button)findViewById(R.id.btnadd3);
		add4=(Button)findViewById(R.id.btnadd4);
		textField=(TextView)findViewById(R.id.book2);
		textField3=(TextView)findViewById(R.id.book3);
		textField4=(TextView)findViewById(R.id.book4);
		textField.setText("2. The Telecom Regulatory " + System.getProperty("line.separator") + "      of India");
		textField3.setText("3. Telecommunication New " + System.getProperty("line.separator") + "      Sign Posts to Old Roads");
		textField4.setText("4. Telecom Management in" + System.getProperty("line.separator") + "      Emerging Economics");
		
		issue = (Button)findViewById(R.id.bookissue);
		issue.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					//button functionality
					startActivity(new Intent(BookActivity.this, IssueActivity.class));
					//qtyvalue2--;
					//bookqty2.setText(Integer.toString(qtyvalue2));

				}
			});
		
		
		mLink = (TextView) findViewById(R.id.link);
		if (mLink != null) {
			mLink.setMovementMethod(LinkMovementMethod.getInstance());
		}
		
					 
		FirebaseDatabase.getInstance().getReference().child("Book1").addListenerForSingleValueEvent(new ValueEventListener() {
				@Override
				public void onDataChange(DataSnapshot dataSnapshot) {
					String s=(String) dataSnapshot.getValue().toString();

                   

					String[] parts = s.split(",");
					String part1 = parts[0]; // 004-
					String part2 = parts[1]; 
				
					
					String[] parts1 = part1.split("=");
					String part3 = parts1[0]; // 004-
					String part4 = parts1[1]; 
					//Log.e("sand",""+part4);
					
					bookqty.setText(part4);
		
					
					} 
				@Override
				public void onCancelled(DatabaseError databaseError) {
				}
			});    
			
			
			
					 
		FirebaseDatabase.getInstance().getReference().child("Book2").addListenerForSingleValueEvent(new ValueEventListener() {
				@Override
				public void onDataChange(DataSnapshot dataSnapshot) {
					String s=(String) dataSnapshot.getValue().toString();



					String[] parts = s.split(",");
					String part1 = parts[0]; // 004-
					String part2 = parts[1]; 


					String[] parts1 = part1.split("=");
					String part3 = parts1[0]; // 004-
					String part4 = parts1[1]; 
					//Log.e("sand",""+part4);

					bookqty2.setText(part4);


				} 
				@Override
				public void onCancelled(DatabaseError databaseError) {
				}
			});    
			
			
			
			
		FirebaseDatabase.getInstance().getReference().child("Book3").addListenerForSingleValueEvent(new ValueEventListener() {
				@Override
				public void onDataChange(DataSnapshot dataSnapshot) {
					String s=(String) dataSnapshot.getValue().toString();



					String[] parts = s.split(",");
					String part1 = parts[0]; // 004-
					String part2 = parts[1]; 


					String[] parts1 = part1.split("=");
					String part3 = parts1[0]; // 004-
					String part4 = parts1[1]; 
					//Log.e("sand",""+part4);

					bookqty3.setText(part4);


				} 
				@Override
				public void onCancelled(DatabaseError databaseError) {
				}
			});        
		
			
			
			
		FirebaseDatabase.getInstance().getReference().child("Book4").addListenerForSingleValueEvent(new ValueEventListener() {
				@Override
				public void onDataChange(DataSnapshot dataSnapshot) {
					String s=(String) dataSnapshot.getValue().toString();



					String[] parts = s.split(",");
					String part1 = parts[0]; // 004-
					String part2 = parts[1]; 


					String[] parts1 = part1.split("=");
					String part3 = parts1[0]; // 004-
					String part4 = parts1[1]; 
					//Log.e("sand",""+part4);

					bookqty4.setText(part4);


				} 
				@Override
				public void onCancelled(DatabaseError databaseError) {
				}
			});        
		
			
			      
		add.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					startActivity(new Intent(BookActivity.this, ConfirmActivity.class));
		
					FirebaseDatabase.getInstance().getReference().child("Book1").addListenerForSingleValueEvent(new ValueEventListener() {
							@Override
							public void onDataChange(DataSnapshot dataSnapshot) {
								String s=(String) dataSnapshot.getValue().toString();


								String[] parts = s.split(",");
								String part1 = parts[0]; // 004-
								String part2 = parts[1]; 


								String[] parts1 = part1.split("=");
								String part3 = parts1[0]; // 004-
								String part4 = parts1[1]; 
							
								int result = Integer.parseInt(part4);			
								int result1 = result-1;
						
								dataSnapshot.getRef().child("Qty").setValue(result1);
						
							} 
							@Override
							public void onCancelled(DatabaseError databaseError) {
							}
						});        
				
				
					String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
					FirebaseDatabase.getInstance().getReference().child("users").child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
							@Override
							public void onDataChange(DataSnapshot dataSnapshot) {
								//String s1=(String) dataSnapshot.getValue().toString();
								//Log.e("san",""+dataSnapshot);
								String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
								DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("users").child(uid);
								mDatabase.child("Book Issued").push().setValue("The Telecom Handbook");			
								}
								
								@Override
							public void onCancelled(DatabaseError databaseError) {
							}
								});		
				}
			});



		add2.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					startActivity(new Intent(BookActivity.this, RegulatoryActivity.class));

					FirebaseDatabase.getInstance().getReference().child("Book2").addListenerForSingleValueEvent(new ValueEventListener() {
							@Override
							public void onDataChange(DataSnapshot dataSnapshot) {
								String s=(String) dataSnapshot.getValue().toString();


								String[] parts = s.split(",");
								String part1 = parts[0]; // 004-
								String part2 = parts[1]; 


								String[] parts1 = part1.split("=");
								String part3 = parts1[0]; // 004-
								String part4 = parts1[1]; 

								int result = Integer.parseInt(part4);			
								int result1 = result-1;

								dataSnapshot.getRef().child("Qty").setValue(result1);

							} 
							@Override
							public void onCancelled(DatabaseError databaseError) {
							}
						});        


					String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
					FirebaseDatabase.getInstance().getReference().child("users").child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
							@Override
							public void onDataChange(DataSnapshot dataSnapshot) {
								//String s1=(String) dataSnapshot.getValue().toString();
								//Log.e("san",""+dataSnapshot);
								String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
								DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("users").child(uid);
								mDatabase.child("Book Issued").push().setValue("The Telecom Regulatory of India");			
							}

							@Override
							public void onCancelled(DatabaseError databaseError) {
							}
						});		
				}
			});

		
		add3.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					startActivity(new Intent(BookActivity.this, RegulatoryActivity.class));

					FirebaseDatabase.getInstance().getReference().child("Book3").addListenerForSingleValueEvent(new ValueEventListener() {
							@Override
							public void onDataChange(DataSnapshot dataSnapshot) {
								String s=(String) dataSnapshot.getValue().toString();


								String[] parts = s.split(",");
								String part1 = parts[0]; // 004-
								String part2 = parts[1]; 


								String[] parts1 = part1.split("=");
								String part3 = parts1[0]; // 004-
								String part4 = parts1[1]; 

								int result = Integer.parseInt(part4);			
								int result1 = result-1;

								dataSnapshot.getRef().child("Qty").setValue(result1);

							} 
							@Override
							public void onCancelled(DatabaseError databaseError) {
							}
						});        


					String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
					FirebaseDatabase.getInstance().getReference().child("users").child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
							@Override
							public void onDataChange(DataSnapshot dataSnapshot) {
								//String s1=(String) dataSnapshot.getValue().toString();
								//Log.e("san",""+dataSnapshot);
								String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
								DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("users").child(uid);
								mDatabase.child("Book Issued").push().setValue("The Telecommunication New Sign Posts to Old Roads");			
							}

							@Override
							public void onCancelled(DatabaseError databaseError) {
							}
						});		
				}
			});

			
		add4.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					startActivity(new Intent(BookActivity.this, RegulatoryActivity.class));

					FirebaseDatabase.getInstance().getReference().child("Book4").addListenerForSingleValueEvent(new ValueEventListener() {
							@Override
							public void onDataChange(DataSnapshot dataSnapshot) {
								String s=(String) dataSnapshot.getValue().toString();


								String[] parts = s.split(",");
								String part1 = parts[0]; // 004-
								String part2 = parts[1]; 


								String[] parts1 = part1.split("=");
								String part3 = parts1[0]; // 004-
								String part4 = parts1[1]; 

								int result = Integer.parseInt(part4);			
								int result1 = result-1;

								dataSnapshot.getRef().child("Qty").setValue(result1);

							} 
							@Override
							public void onCancelled(DatabaseError databaseError) {
							}
						});        


					String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
					FirebaseDatabase.getInstance().getReference().child("users").child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
							@Override
							public void onDataChange(DataSnapshot dataSnapshot) {
								//String s1=(String) dataSnapshot.getValue().toString();
								//Log.e("san",""+dataSnapshot);
								String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
								DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("users").child(uid);
								mDatabase.child("Book Issued").push().setValue("Telecom Management in Emerging Economics");			
							}

							@Override
							public void onCancelled(DatabaseError databaseError) {
							}
						});		
				}
			});
			
			
			
			
			
			
			
			
	}}
