package com.myapp.warest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * Created by kshravi on 28/11/2017 AD.
 */

public class TrainingProfile extends AppCompatActivity {
    EditText name,phone,address,courses;
    Spinner gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_profile);
        name=(EditText)findViewById(R.id.name);
        phone=(EditText)findViewById(R.id.phone);
        address=(EditText)findViewById(R.id.address);
        courses=(EditText)findViewById(R.id.courses);
        gender =(Spinner)findViewById(R.id.gender);

    }
}
