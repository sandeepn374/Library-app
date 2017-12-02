package com.myapp.warest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by kshravi on 02/12/2017 AD.
 */

 public class SelectFacultyType extends AppCompatActivity{

     Spinner facultytype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.facultytype);
        facultytype = (Spinner)findViewById(R.id.facultytype);


        facultytype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here

                if (facultytype.getSelectedItem().toString().equals("Trainee")){

                    startActivity(new Intent(SelectFacultyType.this, UpdateTraineeProfile.class));






                }
                else if (facultytype.getSelectedItem().toString().equals("Freelancer")){


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });











    }
}
