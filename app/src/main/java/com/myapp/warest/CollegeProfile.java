package com.myapp.warest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
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

public class CollegeProfile extends AppCompatActivity {
  EditText name,phone,address,branches;
  Spinner gender;
  Button update;
  FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clg_profile);
        name=(EditText)findViewById(R.id.name);
        phone=(EditText)findViewById(R.id.phone);
        address=(EditText)findViewById(R.id.address);
        branches=(EditText)findViewById(R.id.branches);
        gender =(Spinner)findViewById(R.id.gender);
update=(Button)findViewById(R.id.update);

        auth = FirebaseAuth.getInstance();


        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.keepSynced(true);
        Query query = mDatabase.child("OrgCollege");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (final DataSnapshot child : dataSnapshot.getChildren()) {

                    //   String email= () child.child("email").getValue();
                    if (child.child("email").getValue().equals(auth.getCurrentUser().getEmail())){

                        OrgCollege user = child.getValue(OrgCollege.class);

                        name.setText(user.name);
                        if(user.gender.equals("Male"))
                            gender.setSelection(1);
                        else  if(user.gender.equals("Female"))
                            gender.setSelection(2);
                        else
                            gender.setSelection(0);
                        phone.setText(user.phone);
                        address.setText(user.address);
                        branches.setText(user.branches);





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
                Query query = mDatabase.child("OrgCollege");
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (final DataSnapshot child : dataSnapshot.getChildren()) {

                            if (child.child("email").getValue().equals(auth.getCurrentUser().getEmail())){


                                child.getRef().child("gender").setValue(gender.getSelectedItem().toString());


                                child.getRef().child("address").setValue(address.getText().toString());

                                child.getRef().child("phone").setValue(phone.getText().toString());

                                child.getRef().child("branches").setValue(branches.getText().toString());



                                Toastmsg(CollegeProfile.this,"Profile Updated ");
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


    private void Toastmsg(CollegeProfile collectionActivity, String p1)
    {

        Toast.makeText(this,p1,
                Toast.LENGTH_SHORT).show();
    }

    public void onBackPressed(){
        Intent intent = new Intent(CollegeProfile.this, OrganisationActivity.class);
        startActivity(intent);
        finish();

    }
}
