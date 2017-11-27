package com.myapp.warest;
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
    }



}
