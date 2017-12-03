package com.myapp.warest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by kshravi on 03/12/2017 AD.
 */

public class WorkshopActivity extends AppCompatActivity {


    EditText content;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workshop);
        content=(EditText)findViewById(R.id.workshopdetails);
        submit=(Button)findViewById(R.id.submit);
        
    }
}
