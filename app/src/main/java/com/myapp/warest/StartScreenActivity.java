package com.myapp.warest;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.*;
import android.os.*;

/**
 * Created by kshravi on 25/11/2017 AD.
 */

public class StartScreenActivity extends AppCompatActivity
{
    private Button btnSignup, btnLogin,admin;

	private boolean doubleBackToExitPressedOnce;
	@Override
	public void onBackPressed()
	{
		if (doubleBackToExitPressedOnce)
		{
			super.onBackPressed();
			return;
		}

		this.doubleBackToExitPressedOnce = true;
		Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

		new Handler().postDelayed(new Runnable() {

				@Override
				public void run()
				{
					doubleBackToExitPressedOnce = false;                       
				}
			}, 2000);
	}



    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);


        btnSignup = (Button) findViewById(R.id.btn_signup);
        btnLogin = (Button) findViewById(R.id.btn_login);
        admin = (Button)findViewById(R.id.admin);

        btnSignup.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v)
				{
					startActivity(new Intent(StartScreenActivity.this, SignupActivity.class));


								}
			});


        btnLogin.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v)
				{
					startActivity(new Intent(StartScreenActivity.this, LoginActivity.class));
				}
			});

        admin.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v)
				{
					//startActivity(new Intent(StartScreenActivity.this, FacultyActivity.class));
				}
			});
    }
}
