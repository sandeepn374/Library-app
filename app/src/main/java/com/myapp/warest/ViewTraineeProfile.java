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

public class ViewTraineeProfile extends AppCompatActivity {


    TextView name,age,designation,gender,qualification,ph,email;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.traineeprofileview);

        name=(TextView)findViewById(R.id.traineename);
        age=(TextView)findViewById(R.id.traineeage);
        designation=(TextView)findViewById(R.id.designation);
        email=(TextView)findViewById(R.id.traineeemail);

        gender=(TextView)findViewById(R.id.traineegender);
        qualification=(TextView)findViewById(R.id.qualification);
        ph=(TextView)findViewById(R.id.ph);




        auth = FirebaseAuth.getInstance();






        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("facultyTraineeGroup");
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

                        email.setText("E mail :  " +child.child("email").getValue().toString());

                        age.setText("Age   :  "+child.child("age").getValue().toString());

                        gender.setText("Gender : "+child.child("gender").getValue().toString());

                        designation.setText("Designation  : "+child.child("designation").getValue().toString());

                        qualification.setText("Qualification  :  "+   child.child("qualification").getValue());

                        ph.setText("Phone No : "+child.child("ph").getValue());



                    }

                }
            }
        });



    }

    public void onBackPressed(){
        Intent intent = new Intent(ViewTraineeProfile.this, FacultyActivity.class);
        startActivity(intent);
        finish();

    }
}
