package com.myapp.warest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


/**
 * Created by kshravi on 28/11/2017 AD.
 */

public class CorporateProfileView extends AppCompatActivity {
    TextView name,phone,address,domain,gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.corp_profileview);
        name=(TextView)findViewById(R.id.name);
        phone=(TextView)findViewById(R.id.phone);
        address=(TextView)findViewById(R.id.address);
        domain=(TextView)findViewById(R.id.domain);
        gender =(TextView) findViewById(R.id.gender);
        OrgCorporate o=(OrgCorporate) getIntent().getSerializableExtra("MyClass");
        name.setText("Name :  " +o.name);

        phone.setText("Phone   :  "+o.phone);

        gender.setText("Gender : "+o.gender);

        address.setText("Address   : "+o.address);

        domain.setText("Domain  :  "+  o.domain);


    }



}
