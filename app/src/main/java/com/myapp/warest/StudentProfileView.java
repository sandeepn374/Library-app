package com.myapp.warest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by kshravi on 27/12/2017 AD.
 */

public class StudentProfileView extends AppCompatActivity {


    TextView name,age,course,college,branch,country,university,state,city,reTrain,gender;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentprofileview);

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

        Student s=(Student) getIntent().getSerializableExtra("MyClass");
        name.setText("Name :  " +s.name);

        age.setText("Age   :  "+s.age);

        gender.setText("Gender : "+s.gender);

        course.setText("Ongoing Course   : "+s.course);

        city.setText("City  :  "+  s.city);

        college.setText("College : "+s.colName);

        country.setText( "Country : "+s.country);

        state.setText( "State : "+s.state);

        university.setText( "University : "+s.university);

        reTrain.setText( "Required Training : "+s.requiredTrain);

        branch.setText( "Branch : "+s.branch);

    }


   /* FirebaseDatabase.getInstance().getReference().child("students")
    .addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot){
            int totDue = 0;
            ArrayList<Student> users = new ArrayList<Student>();
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                final Student user = snapshot.getValue(Student.class);
                users.add(user);

            }

            TableLayout layoutINNER = new TableLayout(StudentProfileView.this);
            for (final Student user : users) {


                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT,
                        TableLayout.LayoutParams.WRAP_CONTENT);

                TextView tv1 = new TextView(StudentProfileView.this);

                tv1.setText("Name: " + user.name);


                TableRow tr1 = new TableRow(StudentProfileView.this);

                tr1.setLayoutParams(params);
                tr1.addView(tv1);
                tv1.setTextColor(Color.WHITE);
                tv1.setTextSize(getResources().getDimension(R.dimen.text_size));

                layoutINNER.addView(tr1);

                TextView tv2 = new TextView(StudentProfileView.this);

                tv2.setText("Email: " + user.email);


                TableRow tr2 = new TableRow(StudentProfileView.this);

                tr2.setLayoutParams(params);
                tr2.addView(tv2);
                tv2.setTextColor(Color.WHITE);
                tv2.setTextSize(getResources().getDimension(R.dimen.text_size));


                layoutINNER.addView(tr2);

                View line = new View(StudentProfileView.this);
                line.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, 1));
                line.setBackgroundColor(Color.rgb(51, 51, 51));
                layoutINNER.addView(line);


            }

            LinearLayout main = (LinearLayout) findViewById(R.id.main_layout);

            main.addView(layoutINNER);


        }

        @Override
        public void onCancelled (DatabaseError databaseError){
        }
    });*/

}






