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

public class ViewFreelancerProfile extends AppCompatActivity {

    TextView firstname,lastname,dob,primaryEmail,secondEmail,primaryMobile,secondMobile,AddressLine1,AddressLine2,
            country,state,city,pinCode,skills,instituteName,yearOfCompletion,awards,
            freeLanceCategory,shortDescription,profession,foreignLang,additionSkill,fixedFee,gender,maxdistance,daysyoucantrain,qualification,degree,fieldofstudy;
    FirebaseAuth auth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.freelanceprofileview);

        firstname=(TextView) findViewById(R.id.firstname);
        lastname=(TextView)findViewById(R.id.lastname);

        gender=(TextView) findViewById(R.id.gender);
        dob=(TextView)findViewById(R.id.dob);
        primaryEmail=(TextView)findViewById(R.id.primary);
        secondEmail=(TextView)findViewById(R.id.secondary);
        primaryMobile=(TextView)findViewById(R.id.primarymob);
        secondMobile=(TextView)findViewById(R.id.secondarymob);
        AddressLine1=(TextView)findViewById(R.id.address1);
        AddressLine2=(TextView)findViewById(R.id.address2);
        country=(TextView)findViewById(R.id.country);
        state=(TextView)findViewById(R.id.state);
        city=(TextView)findViewById(R.id.city);
        pinCode=(TextView)findViewById(R.id.pincode);
        skills=(TextView)findViewById(R.id.skills);
        qualification=(TextView) findViewById(R.id.qualifications);
        degree=(TextView)findViewById(R.id.degree);
        fieldofstudy=(TextView)findViewById(R.id.fieldofstudy);
        instituteName=(TextView)findViewById(R.id.institute);
        yearOfCompletion=(TextView)findViewById(R.id.year);
        awards=(TextView)findViewById(R.id.awards);
        freeLanceCategory=(TextView)findViewById(R.id.freelancecategory);
        shortDescription=(TextView)findViewById(R.id.shortdescription);
        profession=(TextView)findViewById(R.id.profession);
        foreignLang=(TextView)findViewById(R.id.foreignlanguage);
        additionSkill=(TextView)findViewById(R.id.additionalskills);
        fixedFee=(TextView)findViewById(R.id.fixedfee);
        maxdistance=(TextView)findViewById(R.id.maxdistance);
        daysyoucantrain=(TextView)findViewById(R.id.days);


        //pd=new ProgressDialog(this);
        //pd.setMessage("loading...");

        auth = FirebaseAuth.getInstance();



        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("facultyFreelancegroup");
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
                        firstname.setText("First Name :  " +child.child("firstName").getValue().toString());

                        lastname.setText("Last Name :  " +child.child("lastName").getValue().toString());



                        gender.setText("Gender : "+child.child("gender").getValue().toString());

                        dob.setText("DOB  : "+child.child("dob").getValue().toString());

                        primaryEmail.setText("Primary Email  : "+child.child("primaryEmail").getValue().toString());
                        secondEmail.setText("Secondary Email  : "+child.child("seconEmail").getValue().toString());
                        primaryMobile.setText("Primary Mobile : "+child.child("primaryMobile").getValue().toString());
                        secondMobile.setText("Secondary Mobile : "+child.child("secondMobile").getValue().toString());
                        AddressLine1.setText("Address Line 1 : "+child.child("AddressLine1").getValue().toString());
                        AddressLine2.setText("Address Line 2 : "+child.child("AddressLine2").getValue().toString());

                        city.setText("City  :  "+   child.child("city").getValue());

                        pinCode.setText("Pincode : "+child.child("pinCode").getValue());

                        country.setText( "Country : "+child.child("country").getValue().toString());

                        state.setText( "State : "+child.child("state").getValue().toString());

                        skills.setText( "Skills: "+child.child("skills").getValue());

                        qualification.setText( "Qualification : "+child.child("qualification").getValue());

                        degree.setText( "Degree : "+child.child("degree").getValue());

                        fieldofstudy.setText( "Field of Study : "+child.child("fieldOfstudy").getValue());

                        instituteName.setText( "Institute Name : "+child.child("instituteName").getValue());
                        yearOfCompletion.setText( "Year Of completion : "+child.child("yearOfCompletion").getValue());
                        awards.setText( "Awards : "+child.child("awards").getValue());
                        freeLanceCategory.setText( "Freelance Category : "+child.child("freeLanceCategory").getValue());
                        shortDescription.setText( "ShortDescription : "+child.child("shortDescription").getValue());
                        profession.setText( "Profession : "+child.child("profession").getValue());
                        foreignLang.setText( "Foreign Languages : "+child.child("foreignLang").getValue());
                        additionSkill.setText( "Additional Skills : "+child.child("additionSkill").getValue());
                        maxdistance.setText( "Max Distance : "+child.child("maxDistance").getValue());
                        fixedFee.setText( "Fixed Fee : "+child.child("fixedFee").getValue());
                        daysyoucantrain.setText( "Days you can train: "+child.child("daysYouCanTrain").getValue());
                    }



                }
            }
        });



    }

    public void onBackPressed(){
        Intent intent = new Intent(ViewFreelancerProfile.this, FacultyActivity.class);
        startActivity(intent);
        finish();

    }
}
