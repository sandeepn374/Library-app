package com.myapp.warest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import android.widget.*;
import com.google.firebase.storage.*;
import com.google.android.gms.tasks.*;
import android.support.annotation.*;
import com.bumptech.glide.*;
import android.net.*;
import android.util.*;
import com.bumptech.glide.request.target.*;
import android.app.*;

public class ViewTrainingProfile extends AppCompatActivity {

    TextView name,phone,address,courses,gender;
    FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.training_profileview);
        name=(TextView) findViewById(R.id.name);
        phone=(TextView)findViewById(R.id.phone);
        address=(TextView)findViewById(R.id.address);
        courses=(TextView)findViewById(R.id.courses);
        gender =(TextView) findViewById(R.id.gender);




        //pd=new ProgressDialog(this);
        //pd.setMessage("loading...");

        auth = FirebaseAuth.getInstance();
        final FirebaseUser u=auth.getCurrentUser();
        //pd.show();






        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("OrgTraining");
        mDatabase.keepSynced(true);
        mDatabase.addValueEventListener(new ValueEventListener() {

            @Override
            public void onCancelled(DatabaseError p1)
            {

            }


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {


                    if(child.child("email").getValue().toString().equals(auth.getCurrentUser().getEmail())){
                        name.setText("Name :  " +child.child("name").getValue().toString());

                        phone.setText("Phone   :  "+child.child("phone").getValue().toString());

                        gender.setText("Gender : "+child.child("gender").getValue().toString());

                        address.setText("Address : "+child.child("address").getValue().toString());
                        courses.setText("Courses : "+child.child("courses").getValue().toString());


                    }

                }
            }
        });



    }
    public void onBackPressed(){
        Intent intent = new Intent(ViewTrainingProfile.this, OrganisationActivity.class);
        startActivity(intent);
        finish();

    }
}
