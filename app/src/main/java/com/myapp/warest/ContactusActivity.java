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
import android.os.*;
import javax.mail.*;
import android.app.*;


/**
 * Created by Sirious Black on 27/11/2017 AD.
 */

public class ContactusActivity extends AppCompatActivity{

    EditText name, emailid,comments;
    Button send; 
  ProgressDialog pd;
 
  

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us);
        final Button send = (Button) this.findViewById(R.id.send);
	
		name =(EditText)findViewById(R.id.Name);
		emailid=(EditText)findViewById(R.id.Emailid);
		comments=(EditText)findViewById(R.id.comments);
		
 
		send.setOnClickListener(new View.OnClickListener() { 
				public void onClick(View view) { 
					SendEmailAsyncTask.emailId=emailid.getText().toString();
					SendEmailAsyncTask.comment=comments.getText().toString();
				
					new SendEmailAsyncTask().execute();
					Toast.makeText(ContactusActivity.this,"Mail sent",Toast.LENGTH_SHORT).show();
				} 
			}); 
    }

}
	


	class SendEmailAsyncTask extends AsyncTask <Void, Void, Boolean> {
		Mail m = new Mail("kshravi86@gmail.com", "18forever");
	static String emailId;
	static String comment;
		public SendEmailAsyncTask() {
			if (BuildConfig.DEBUG) Log.v(SendEmailAsyncTask.class.getName(), "SendEmailAsyncTask()");
			
			String arr[]={emailId};
			m.setTo(arr);
			m.setFrom("Anonymous");
			m.setSubject("Email from Warest");
			m.setBody(comment);
		}

		@Override
		protected Boolean doInBackground(Void... params) {
			if (BuildConfig.DEBUG) Log.v(SendEmailAsyncTask.class.getName(), "doInBackground()");
			try {
				m.send();
				return true;
			} catch (AuthenticationFailedException e) {
				Log.e(SendEmailAsyncTask.class.getName(), "Bad account details");
				e.printStackTrace();
				return false;
			} catch (MessagingException e) {
				
				e.printStackTrace();
				return false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} 
		}



