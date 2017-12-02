package com.myapp.warest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.util.*;
import android.net.*;
import android.widget.*;
import android.view.*;


/**
 * Created by kshravi on 27/11/2017 AD.
 */

public class ContactusActivity extends AppCompatActivity{

    EditText name, emailid,comments;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us);
        name=(EditText)findViewById(R.id.Name);
        emailid=(EditText)findViewById(R.id.Emailid);
        comments=(EditText)findViewById(R.id.comments);
        send=(Button) findViewById(R.id.send);
	
		send.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {
					sendEmail();
				}
			});
		
    }



	@SuppressLint("LongLogTag")
	protected void sendEmail() {
		Log.i("Send email", "");
		String[] TO = {"kshravi86@gmail.com"};
		String[] CC = {"suni9636@gmail.com"};
		Intent emailIntent = new Intent(Intent.ACTION_SEND);

		emailIntent.setData(Uri.parse("mailto:"));
		emailIntent.setType("text/plain");
		emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
		emailIntent.putExtra(Intent.EXTRA_CC, CC);
		emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Mail from Warest" );
		emailIntent.putExtra(Intent.EXTRA_TEXT, comments.getText().toString());

		try {
			startActivity(Intent.createChooser(emailIntent, "Send mail..."));
			finish();
			Log.i("Finished sending email...", "");
		} catch (android.content.ActivityNotFoundException ex) {
			Toast.makeText(ContactusActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
		}
	}



}
