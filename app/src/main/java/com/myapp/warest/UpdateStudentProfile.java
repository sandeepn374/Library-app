package com.myapp.warest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kshravi on 26/11/2017 AD.
 */

public class UpdateStudentProfile extends AppCompatActivity {

    EditText name,age,course,college,branch,country,university,state,city,reTrain;
     FirebaseAuth auth;
    Spinner gender;
    Button update,view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatestudentprofile);
        name=(EditText)findViewById(R.id.fullname);
        age=(EditText)findViewById(R.id.age);
        course=(EditText)findViewById(R.id.ongoingcourse);
        college=(EditText)findViewById(R.id.college);
        branch=(EditText)findViewById(R.id.branch);
        country=(EditText)findViewById(R.id.country);
        university=(EditText)findViewById(R.id.university);
        state=(EditText)findViewById(R.id.state);
        city=(EditText)findViewById(R.id.city);

        auth = FirebaseAuth.getInstance();
        final FirebaseUser u=auth.getCurrentUser();

        FirebaseDatabase.getInstance().getReference().child("students")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            final Student student = snapshot.getValue(Student.class);


    if (student.email.equals(auth.getCurrentUser().getEmail()))
        name.setText(student.name);


                        }


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }


                });
        update=(Button)findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
                mDatabase.keepSynced(true);
                Query query = mDatabase.child("students");
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (final DataSnapshot child : dataSnapshot.getChildren()) {

                            HashMap<String,String> userMap= (HashMap<String, String>) child.child("user").getValue();
                            if (userMap.get("email").equals(auth.getCurrentUser().getEmail())){

                                child.getRef().child("age").setValue(age.getText().toString());

                                child.getRef().child("course").setValue(course.getText().toString());

                                child.getRef().child("college").setValue(college.getText().toString());

                                child.getRef().child("country").setValue(country.getText().toString());

                                child.getRef().child("branch").setValue(branch.getText().toString());

                                child.getRef().child("university").setValue(university.getText().toString());

                                child.getRef().child("state").setValue(state.getText().toString());

                                child.getRef().child("city").setValue(city.getText().toString());
                                Toastmsg(UpdateStudentProfile.this,"Updated Profile");








                            }


                        }


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                ;


            }
        });





            }
    private void Toastmsg(UpdateStudentProfile collectionActivity, String p1)
    {

        Toast.makeText(this,p1,
                Toast.LENGTH_SHORT).show();
    }









}




