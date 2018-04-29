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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {

    private EditText name, email, phone, password ,cnfrmpwd, usn ;
    private Button btnReg;
    private ProgressBar progressBar;
    private FirebaseAuth auth;
    private Spinner gender, sem, dept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth = FirebaseAuth.getInstance();
		
		name = (EditText)findViewById(R.id.fullname);
		email = (EditText)findViewById(R.id.email);
		phone = (EditText)findViewById(R.id.phone);
		password = (EditText)findViewById(R.id.password);
        cnfrmpwd = (EditText)findViewById(R.id.confirmpwd);
		usn = (EditText)findViewById(R.id.usn);
		gender = (Spinner)findViewById(R.id.gender);
		sem = (Spinner)findViewById(R.id.semester);
		dept = (Spinner)findViewById(R.id.department);
		btnReg = (Button)findViewById(R.id.register);
		progressBar=(ProgressBar)findViewById(R.id.progressBar);
		
		
		
		

        btnReg.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {

					final String inputemail = email.getText().toString().trim();
					String inputpassword = password.getText().toString().trim();
					final String inputusn = usn.getText().toString();
					final String inputname = name.getText().toString();
					final String inputphone = phone.getText().toString();
					final String inputgender= gender.getSelectedItem().toString();
					final String inputsem= sem.getSelectedItem().toString();
					final String inputdept= dept.getSelectedItem().toString();
					
					if (TextUtils.isEmpty(inputname)) {
						Toast.makeText(getApplicationContext(), "Enter your name!", Toast.LENGTH_SHORT).show();
						return;
					}
					
					if (TextUtils.isEmpty(inputphone)) {
						Toast.makeText(getApplicationContext(), "Enter phone no!", Toast.LENGTH_SHORT).show();
						return;
					}
					if (TextUtils.isEmpty(inputemail)) {
						Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
						return;
					}

					if (TextUtils.isEmpty(inputpassword)) {
						Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
						return;
					}
					
					if (TextUtils.isEmpty(inputusn)) {
						Toast.makeText(getApplicationContext(), "Enter your USN!", Toast.LENGTH_SHORT).show();
						return;
					}

					if (password.length() < 4) {
						Toast.makeText(getApplicationContext(), "Password too short, enter minimum 4 characters!", Toast.LENGTH_SHORT).show();
						return;
					}
					
					if (gender.getSelectedItem().equals("Select Your Gender")) {
						Toast.makeText(getApplicationContext(), "Please Select your gender", Toast.LENGTH_SHORT).show();
						return;
					}
					
					if (sem.getSelectedItem().equals("Select Your Semester")) {
						Toast.makeText(getApplicationContext(), "Please Select your semester", Toast.LENGTH_SHORT).show();
						return;
					}
					
					if (dept.getSelectedItem().equals("Select Your Department")) {
						Toast.makeText(getApplicationContext(), "Please Select your department", Toast.LENGTH_SHORT).show();
						return;
					}

					progressBar.setVisibility(View.VISIBLE);
					//create user
					auth.createUserWithEmailAndPassword(inputemail, inputpassword)
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
									
									if (sem.getSelectedItem().equals("8") && (dept.getSelectedItem().equals("TCE"))) {
										User user = new User(inputname, inputemail,inputphone,inputusn,inputgender,inputsem,inputdept);
										DatabaseReference mDatabaseForUser = FirebaseDatabase.getInstance().getReference("users");                                  
										String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();                                
										mDatabaseForUser.child(uid).setValue(user);

										
										
										
										
										
										
										Intent intent = new Intent(SignupActivity.this, MainActivity.class);
										startActivity(intent);
										finish();
									}
									else {
										
										//Intent intent = new Intent(SignupActivity.this, Main1Activity.class);
										//startActivity(intent);
										//finish();
									}

                                  //  String inputname=name.getText().toString();
                                    //String inputph=phone.getText().toString();
                                  //  String inputemail=email.getText().toString();
									//String inputusn = usn.getText().toString();
									
									
		
		
}
}

});
}
});
}
}
