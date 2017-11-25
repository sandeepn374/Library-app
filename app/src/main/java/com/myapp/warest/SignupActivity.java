package com.myapp.warest;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private Button btnSignIn, btnSignUp, btnResetPassword;
    private ProgressBar progressBar;
    private FirebaseAuth auth;
    private Spinner community,sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        /*


         */

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        btnSignIn = (Button) findViewById(R.id.sign_in_button);
        btnSignUp = (Button) findViewById(R.id.sign_up_button);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnResetPassword = (Button) findViewById(R.id.btn_reset_password);
        community=(Spinner)findViewById(R.id.community);
        sub=(Spinner)findViewById(R.id.sub);
        sub.setVisibility(View.GONE);


        final Map<String, List<String>> data = new HashMap<>();
        data.put("Student", Arrays.asList("1","2","3","4"));
        data.put("Faculty", Arrays.asList("4", "5"));
        data.put("Organisation", Arrays.asList("College/University", "Training Institute", "Corporate"));

        // obtaining a string array containing keys(data of spinner1) of above hashmap
        final String[] dataSpinner1 = new String[data.keySet().size()];
        data.keySet().toArray(dataSpinner1);

        // initializing an string type, ArrayAdapter for spinner1
        // you will need to pass activity context, layout for the spinner item and
        // spinner content(as string array) as arguments to create an array adapter
        final ArrayAdapter<String> spinner1Adapter = new ArrayAdapter<String>(SignupActivity.this, android.R.layout.simple_spinner_item, dataSpinner1);
        community.setAdapter(spinner1Adapter);

        // setting listner for spinner1 to trigger when an spinner item is being
        // clicked by the user
        community.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // obtaining relevant data for spinner2
                if(dataSpinner1[position].equals("Organisation")) {
                    List<String> dataSpinner2 = data.get(dataSpinner1[position]);

                    // crating an setting array adapter for spinner2
                    ArrayAdapter<String> spinner2Adapter = new ArrayAdapter<String>(SignupActivity.this, android.R.layout.simple_spinner_item, dataSpinner2);
                    sub.setAdapter(spinner2Adapter);
                    sub.setVisibility(View.VISIBLE);
                }
                else{

                    sub.setVisibility(View.GONE);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnResetPassword.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					startActivity(new Intent(SignupActivity.this, ResetPasswordActivity.class));
				}
			});

        btnSignIn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					finish();
				}
			});

        btnSignUp.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {

					String email = inputEmail.getText().toString().trim();
					String password = inputPassword.getText().toString().trim();

					if (TextUtils.isEmpty(email)) {
						Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
						return;
					}

					if (TextUtils.isEmpty(password)) {
						Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
						return;
					}

					if (password.length() < 6) {
						Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
						return;
					}

					progressBar.setVisibility(View.VISIBLE);
					//create user
					auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(SignupActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(SignupActivity.this, "Authentication failed." + task.getException(),
												   Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(SignupActivity.this, MainActivity.class));
                                    finish();
                                }
                            }
                        });

				}
			});
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}
