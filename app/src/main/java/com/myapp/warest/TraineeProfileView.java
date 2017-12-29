package com.myapp.warest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by kshravi on 27/12/2017 AD.
 */

public class TraineeProfileView extends AppCompatActivity {


    TextView name,age,designation,gender,qualification;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.traineeprofileview);

        name=(TextView)findViewById(R.id.traineename);
        age=(TextView)findViewById(R.id.traineeage);
        designation=(TextView)findViewById(R.id.designation);

        gender=(TextView)findViewById(R.id.traineegender);
        qualification=(TextView)findViewById(R.id.qualification);

        FacultyTrainee s=(FacultyTrainee) getIntent().getSerializableExtra("MyClass");
        name.setText("Name :  " +s.name);

        age.setText("Age   :  "+s.age);

        gender.setText("Gender : "+s.gender);

        designation.setText("Designation  : "+s.designation);

        qualification.setText("Qualification  :  "+  s.qualification);



    }




}






