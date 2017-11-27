package com.myapp.warest;

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

public class ViewStudentProfile extends AppCompatActivity {

    TextView name,age,course,college,branch,country,university,state,city,reTrain,gender;
    Button update,view;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewprofile);
        name=(TextView)findViewById(R.id.fullname);
        age=(TextView)findViewById(R.id.age);
        course=(TextView)findViewById(R.id.ongoingcourse);
        college=(TextView)findViewById(R.id.college);
        branch=(TextView)findViewById(R.id.branch);
        country=(TextView)findViewById(R.id.country);
        university=(TextView)findViewById(R.id.university);
        state=(TextView)findViewById(R.id.state);
        city=(TextView)findViewById(R.id.city);
        gender=(TextView)findViewById(R.id.gender);
        reTrain=(TextView)findViewById(R.id.reqdtraining);


        auth = FirebaseAuth.getInstance();
        final FirebaseUser u=auth.getCurrentUser();

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.keepSynced(true);
        Query query = mDatabase.child("students");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (final DataSnapshot child : dataSnapshot.getChildren()) {

                    //   String email= () child.child("email").getValue();
                    if (child.child("email").getValue().equals(auth.getCurrentUser().getEmail())){

                       name.setText("Name :  " +child.child("name").getValue().toString());

                        age.setText("Age   :  "+child.child("age").getValue().toString());

                        gender.setText("Gender : "+child.child("gender").getValue().toString());

                        course.setText("Ongoing Course   : "+child.child("course").getValue().toString());

                        city.setText("City  :  "+   child.child("city").getValue());

                        college.setText("College : "+child.child("colName").getValue());

                       country.setText( "Country : "+child.child("country").getValue().toString());

                       state.setText( "State : "+child.child("state").getValue().toString());

                       university.setText( "University : "+child.child("university").getValue());

                       reTrain.setText( "Required Training : "+child.child("requiredTrain").getValue());

                        branch.setText( "Branch : "+child.child("branch").getValue());




                    }


                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        ;




    }
}
