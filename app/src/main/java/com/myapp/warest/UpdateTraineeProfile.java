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
import android.widget.Spinner;

/**
 * Created by kshravi on 27/11/2017 AD.
 */

public class UpdateTraineeProfile extends AppCompatActivity{
    EditText name, age,designation,qualification;
    Spinner gender;
    Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatetraineeprofile);
        name=(EditText)findViewById(R.id.traineename);
        age=(EditText)findViewById(R.id.traineeage);
        designation=(EditText)findViewById(R.id.designation);
        qualification=(EditText)  findViewById(R.id.qualification);
        gender=(Spinner)findViewById(R.id.traineegender);
        update=(Button)findViewById(R.id.updateprofile);







    }






}
