package com.myapp.warest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by kshravi on 03/12/2017 AD.
 */

public class WorkshopActivity extends AppCompatActivity {


    EditText content;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workshop);
        content=(EditText)findViewById(R.id.workshopdetails);
        submit=(Button)findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){


                Workshop send=new Workshop(content.getText().toString());
                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("workshops");
                String userId = mDatabase.push().getKey();
                mDatabase.child(userId).setValue(send);
                Toast.makeText(getApplicationContext(), "Workshop Updated", Toast.LENGTH_SHORT).show();







            }


        });

    }
}
