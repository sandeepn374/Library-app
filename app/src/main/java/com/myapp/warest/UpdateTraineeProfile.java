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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by kshravi on 27/11/2017 AD.
 */

public class UpdateTraineeProfile extends AppCompatActivity{
    EditText name, age,designation,qualification;
    FirebaseAuth auth;
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
        auth = FirebaseAuth.getInstance();
        final FirebaseUser u=auth.getCurrentUser();

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.keepSynced(true);
        Query query = mDatabase.child("facultyTraineeGroup");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (final DataSnapshot child : dataSnapshot.getChildren()) {

                    //   String email= () child.child("email").getValue();
                    if (child.child("email").getValue().equals(auth.getCurrentUser().getEmail())){

                        FacultyTrainee user = child.getValue(FacultyTrainee.class);
                        age.setText(user.age);
                        name.setText(user.name);
                        if(user.gender.equals("Male"))
                            gender.setSelection(1);
                        else  if(user.gender.equals("Female"))
                            gender.setSelection(2);
                        else
                            gender.setSelection(0);
                        designation.setText(user.designation);
                        qualification.setText(user.qualification);




                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
                mDatabase.keepSynced(true);
                Query query = mDatabase.child("facultyTraineeGroup");
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (final DataSnapshot child : dataSnapshot.getChildren()) {



                                child.getRef().child("name").setValue(name.getText().toString());

                                child.getRef().child("age").setValue(age.getText().toString());

                                child.getRef().child("designation").setValue(designation.getText().toString());

                                child.getRef().child("qualification").setValue(qualification.getText().toString());

                                child.getRef().child("gender").setValue(gender.getSelectedItem().toString());

//
                                Toastmsg(UpdateTraineeProfile.this,"Profile Updated ");

                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
            }
        });







    }
    private void Toastmsg(UpdateTraineeProfile collectionActivity, String p1)
    {

        Toast.makeText(this,p1,
                Toast.LENGTH_SHORT).show();
    }

    public void onBackPressed(){
        Intent intent = new Intent(UpdateTraineeProfile.this, FacultyActivity.class);
        startActivity(intent);
        finish();

    }



}
