package com.myapp.warest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

/**
 * Created by kshravi on 02/12/2017 AD.
 */

public class SelectOrganisation extends AppCompatActivity{

    Spinner orgtype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_org);
     orgtype = (Spinner)findViewById(R.id.selectorgtype);


        orgtype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here

                if (orgtype.getSelectedItem().toString().equals("College/University")){

                   // startActivity(new Intent(SelectOrganisation.this, UpdateClg.class));


                }
                else if (orgtype.getSelectedItem().toString().equals("Training")){

                  //  startActivity(new Intent(SelectOrganisation.this, UpdateFreelancerProfile.class));
                }

                else if (orgtype.getSelectedItem().toString().equals("Corporate")){

                    //startActivity(new Intent(SelectOrganisation.this, UpdateFreelancerProfile.class));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });











    }
}
