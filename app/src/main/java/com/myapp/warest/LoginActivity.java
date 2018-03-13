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
	private Button btnSignup, btnLogin;
	// private Spinner community;


	String type;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		

		auth = FirebaseAuth.getInstance();

		 

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
			});}}

			

			


	

