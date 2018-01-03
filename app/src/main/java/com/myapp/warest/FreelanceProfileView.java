package com.myapp.warest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by kshravi on 27/12/2017 AD.
 */

public class FreelanceProfileView extends AppCompatActivity {


    TextView firstname,lastname,dob,primaryEmail,secondEmail,primaryMobile,secondMobile,AddressLine1,AddressLine2,
            country,state,city,pinCode,skills,instituteName,yearOfCompletion,awards,
            freeLanceCategory,shortDescription,profession,foreignLang,additionSkill,fixedFee,gender,maxdistance,daysyoucantrain,qualification,degree,fieldofstudy;

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

        FacultyFreelance s=(FacultyFreelance) getIntent().getSerializableExtra("MyClass");
        firstname.setText("First Name :  " +s.firstName);
        lastname.setText("Last Name :  " +s.lastName);
        dob.setText("Date Of Birth  :  "+s.dob);

        primaryEmail.setText("Primary Email:" +s.primaryEmail);
        secondEmail.setText("Secondary Email:" +s.seconEmail);
        gender.setText("Gender : "+s.gender);

       primaryMobile.setText("Primary Mobile No  : "+s.primaryMobile);
        secondMobile.setText("Secondary Mobile No:"+s.secondMobile);
        qualification.setText("Qualification  :  "+  s.qualification);
        AddressLine1.setText("Address Line 1:"+s.AddressLine1);
        AddressLine2.setText("Address Line 2:"+s.AddressLine2);
        country.setText("Country:"+s.country);
        state.setText("State:"+s.state);
        city.setText("City:"+s.city);
        pinCode.setText("PinCode:"+s.pinCode);
        skills.setText("Skills:"+s.skills);
        degree.setText("Degree:"+s.degree);
        fieldofstudy.setText("Field of Study:"+s.fieldOfstudy);
        instituteName.setText("Institute Name:"+s.instituteName);
        yearOfCompletion.setText("Year Of Completion:"+s.yearOfCompletion);
        awards.setText("Awards:"+s.awards);
        freeLanceCategory.setText("Freelance Category:"+s.freeLanceCategory);
        shortDescription.setText("Short Description:"+s.shortDescription);
        profession.setText("Profession:"+s.profession);
        foreignLang.setText("Foreign Language:"+s.foreignLang);

        additionSkill.setText("Additional Skills:"+s.additionSkill);
        fixedFee.setText("Fixed Fee:"+s.fixedFee);
        maxdistance.setText("Maximum Distance:"+s.maxDistance);

        daysyoucantrain.setText("Days You Can Train:"+s.daysYouCanTrain);


    }




}






