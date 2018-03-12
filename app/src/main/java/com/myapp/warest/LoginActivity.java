package com.myapp.warest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.*;
import android.content.*;
import android.app.*;
import android.preference.*;

public class LoginActivity extends AppCompatActivity
{

	private EditText inputEmail, inputPassword;
	private FirebaseAuth auth;
	private ProgressBar progressBar;
	private Button btnSignup, btnLogin, btnReset;
	// private Spinner community;


	String type;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		

		auth = FirebaseAuth.getInstance();

		if (auth.getCurrentUser() != null) {
		
			if(auth.getCurrentUser().getEmail().equals("info@warest.org")){

				Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
				startActivity(intent);
				finish();
			}

			DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");
			mDatabase.keepSynced(true);
			mDatabase.addValueEventListener(new ValueEventListener() {
				@Override
				public void onCancelled(DatabaseError p1) {

				}

				@Override
				public void onDataChange(DataSnapshot dataSnapshot) {
					for (DataSnapshot child : dataSnapshot.getChildren()) {


						if (child.child("email").getValue().toString().equals(auth.getCurrentUser().getEmail())) {





							if (child.child("community").getValue().toString().equals("Student")) {

								Intent intent = new Intent(LoginActivity.this, StudentActivity.class);
								startActivity(intent);
								finish();
							} else if(child.child("community").getValue().toString().equals("Faculty"))  {

								Intent intent = new Intent(LoginActivity.this, FacultyActivity.class);
								startActivity(intent);
								finish();
							}

							else{

								Intent intent = new Intent(LoginActivity.this, OrganisationActivity.class);
								startActivity(intent);
								finish();

							}





						}

					}
				}
			});


			
			

		} else {

			// set the view now
			setContentView(R.layout.activity_login);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

			inputEmail = (EditText) findViewById(R.id.email);
			inputPassword = (EditText) findViewById(R.id.password);
			progressBar = (ProgressBar) findViewById(R.id.progressBar);
			btnSignup = (Button) findViewById(R.id.btn_signup);
			btnLogin = (Button) findViewById(R.id.btn_login);
			//btnReset = (Button) findViewById(R.id.btn_reset_password);
			//community = (Spinner) findViewById(R.id.community);

			//Get Firebase auth instance
			auth = FirebaseAuth.getInstance();

			btnSignup.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					startActivity(new Intent(LoginActivity.this, SignupActivity.class));
				}
			});

			/*btnReset.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					startActivity(new Intent(LoginActivity.this, ResetPasswordActivity.class));
				}
			});*/

			btnLogin.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					String email = inputEmail.getText().toString();
					final String password = inputPassword.getText().toString();
					//community = (Spinner) findViewById(R.id.community);

					if (TextUtils.isEmpty(email)) {
						Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
						return;
					}

					if (TextUtils.isEmpty(password)) {
						Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
						return;
					}

					/*if (community.getSelectedItem() == "Select Community") {
						Toast.makeText(getApplicationContext(), "Please Select Community", Toast.LENGTH_SHORT).show();
						return;
					}*/

					progressBar.setVisibility(View.VISIBLE);

					//authenticate user
					auth.signInWithEmailAndPassword(email, password)
							.addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
								@Override
								public void onComplete(@NonNull Task<AuthResult> task) {
									// If sign in fails, display a message to the user. If sign in succeeds
									// the auth state listener will be notified and logic to handle the
									// signed in user can be handled in the listener.

									if (!task.isSuccessful()) {
										// there was an error
										if (password.length() < 6) {
											inputPassword.setError(getString(R.string.minimum_password));
										} else {
											Toast.makeText(LoginActivity.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
										}
										/*if (community.getSelectedItem() == "Select Community") {
											Toast.makeText(getApplicationContext(), "Please Select Community", Toast.LENGTH_SHORT).show();

										}*/

									} else {
										if(auth.getCurrentUser().getEmail().equals("kshravi86@gmail.com")){

											Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
											startActivity(intent);
											finish();


										}


										DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");
										mDatabase.keepSynced(true);
										mDatabase.addValueEventListener(new ValueEventListener() {
											@Override
											public void onCancelled(DatabaseError p1) {

											}

											@Override
											public void onDataChange(DataSnapshot dataSnapshot) {
												for (DataSnapshot child : dataSnapshot.getChildren()) {


													if (child.child("email").getValue().toString().equals(auth.getCurrentUser().getEmail())) {
													
													
														SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
														SharedPreferences.Editor editor = app_preferences.edit();
														
													
														
														if (child.child("community").getValue().toString().equals("Student")) {
														
															editor.putString("type", "Student");
															editor.commit();
															
															progressBar.setVisibility(View.GONE);
															Intent intent = new Intent(LoginActivity.this, StudentActivity.class);
															startActivity(intent);
															finish();
														} else if (child.child("community").getValue().toString().equals("Faculty")) {
															
														
															editor.putString("type", "Faculty");
															editor.commit();
														
							
														
															progressBar.setVisibility(View.GONE);
															Intent intent = new Intent(LoginActivity.this, FacultyActivity.class);
															startActivity(intent);
															finish();
														}
														else if (child.child("community").getValue().toString().equals("Organisation")) {


															editor.putString("type", "Organisation");
															editor.commit();



															progressBar.setVisibility(View.GONE);
															Intent intent = new Intent(LoginActivity.this, OrganisationActivity.class);
															startActivity(intent);
															finish();
														}
														
													
														

													}

												}
											}
										});


									}
								}
							});

				}
			});
		}

	}
}
