package com.myapp.warest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public class UpdateFreelancerProfile extends AppCompatActivity {
    EditText firstname,lastname,dob,primaryEmail,secondEmail,primaryMobile,secondMobile,AddressLine1,AddressLine2,
            country,state,city,pinCode,skills,instituteName,yearOfCompletion,awards,
            freeLanceCategory,shortDescription,profession,foreignLang,additionSkill,fixedFee;
    Spinner gender,maxdistance,daysyoucantrain,qualification,degree,fieldofstudy;
    Button update;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatefreelancerprofile);

        auth = FirebaseAuth.getInstance();

        firstname=(EditText)findViewById(R.id.firstname);
        lastname=(EditText)findViewById(R.id.lastname);

         gender=(Spinner) findViewById(R.id.gender);
         dob=(EditText)findViewById(R.id.dob);
        primaryEmail=(EditText)findViewById(R.id.primary);
        secondEmail=(EditText)findViewById(R.id.secondary);
         primaryMobile=(EditText)findViewById(R.id.primarymob);
        secondMobile=(EditText)findViewById(R.id.secondarymob);
         AddressLine1=(EditText)findViewById(R.id.address1);
         AddressLine2=(EditText)findViewById(R.id.address2);
         country=(EditText)findViewById(R.id.country);
        state=(EditText)findViewById(R.id.state);
        city=(EditText)findViewById(R.id.city);
         pinCode=(EditText)findViewById(R.id.pincode);
         skills=(EditText)findViewById(R.id.skills);
         qualification=(Spinner) findViewById(R.id.qualifications);
         degree=(Spinner)findViewById(R.id.degree);
        fieldofstudy=(Spinner)findViewById(R.id.fieldofstudy);
        instituteName=(EditText)findViewById(R.id.institute);
         yearOfCompletion=(EditText)findViewById(R.id.year);
        awards=(EditText)findViewById(R.id.awards);
         freeLanceCategory=(EditText)findViewById(R.id.freelancecategory);
        shortDescription=(EditText)findViewById(R.id.shortdescription);
         profession=(EditText)findViewById(R.id.profession);
        foreignLang=(EditText)findViewById(R.id.foreignlanguage);
         additionSkill=(EditText)findViewById(R.id.additionalskills);
        fixedFee=(EditText)findViewById(R.id.fixedfee);
        maxdistance=(Spinner)findViewById(R.id.maxdistance);
        daysyoucantrain=(Spinner)findViewById(R.id.days);
        update=(Button)findViewById(R.id.update);


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
                mDatabase.keepSynced(true);
                Query query = mDatabase.child("facultyFreelancegroup");
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (final DataSnapshot child : dataSnapshot.getChildren()) {

                            if (child.child("email").getValue().equals(auth.getCurrentUser().getEmail())){

                                child.getRef().child("firstName").setValue(firstname.getText().toString());

                                child.getRef().child("lastName").setValue(lastname.getText().toString());

                                child.getRef().child("gender").setValue(gender.getSelectedItem().toString());

                                child.getRef().child("dob").setValue(dob.getText().toString());

                                child.getRef().child("primaryEmail").setValue(primaryEmail.getText().toString());

                                child.getRef().child("seconEmail").setValue(secondEmail.getText().toString());

                                child.getRef().child("primaryMobile").setValue(primaryMobile.getText().toString());

                                child.getRef().child("secondMobile").setValue(secondMobile.getText().toString());

                                child.getRef().child("AddressLine1").setValue(AddressLine1.getText().toString());
                                child.getRef().child("AddressLine2").setValue(AddressLine2.getText().toString());



                                child.getRef().child("country").setValue(country.getText().toString());

                                child.getRef().child("state").setValue(state.getText().toString());

                                child.getRef().child("city").setValue(city.getText().toString());

                                child.getRef().child("pinCode").setValue(pinCode.getText().toString());

                                child.getRef().child("skills").setValue(skills.getText().toString());

                                child.getRef().child("qualification").setValue(qualification.getSelectedItem().toString());

                                child.getRef().child("degree").setValue(degree.getSelectedItem().toString());

                                child.getRef().child("fieldOfstudy").setValue(fieldofstudy.getSelectedItem().toString());

                                child.getRef().child("instituteName").setValue(instituteName.getText().toString());
                                child.getRef().child("yearOfCompletion").setValue(yearOfCompletion.getText().toString());
                                child.getRef().child("awards").setValue(awards.getText().toString());
                                child.getRef().child("freeLanceCategory").setValue(freeLanceCategory.getText().toString());
                                child.getRef().child("shortDescription").setValue(shortDescription.getText().toString());
                                child.getRef().child("profession").setValue(profession.getText().toString());
                                child.getRef().child("foreignLang").setValue(foreignLang.getText().toString());
                                child.getRef().child("additionSkill").setValue(additionSkill.getText().toString());
                                child.getRef().child("fixedFee").setValue(fixedFee.getText().toString());
                                child.getRef().child("maxDistance").setValue(maxdistance.getSelectedItem().toString());
                                child.getRef().child("daysYouCanTrain").setValue(daysyoucantrain.getSelectedItem().toString());

                                Toastmsg(UpdateFreelancerProfile.this,"Profile Updated ");
                            }
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });



            }
        });



    }



    private void Toastmsg(UpdateFreelancerProfile collectionActivity, String p1)
    {

        Toast.makeText(this,p1,
                Toast.LENGTH_SHORT).show();
    }



    public void onBackPressed(){
        Intent intent = new Intent(UpdateFreelancerProfile.this, FacultyActivity.class);
        startActivity(intent);
        finish();

    }
}
