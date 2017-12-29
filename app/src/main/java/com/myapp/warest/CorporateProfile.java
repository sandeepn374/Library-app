package com.myapp.warest;

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

public class CorporateProfile extends AppCompatActivity {
    EditText name,phone,address,domain;
    Spinner gender;
    Button update;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.corp_profile);
        name=(EditText)findViewById(R.id.name);
        phone=(EditText)findViewById(R.id.phone);
        address=(EditText)findViewById(R.id.address);
        domain=(EditText)findViewById(R.id.domain);
        gender =(Spinner)findViewById(R.id.gender);
        update=(Button)findViewById(R.id.update);

        auth = FirebaseAuth.getInstance();
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
                mDatabase.keepSynced(true);
                Query query = mDatabase.child("OrgCorporate");
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (final DataSnapshot child : dataSnapshot.getChildren()) {

                            if (child.child("email").getValue().equals(auth.getCurrentUser().getEmail())){


                                child.getRef().child("gender").setValue(gender.getSelectedItem().toString());


                                child.getRef().child("address").setValue(address.getText().toString());

                                child.getRef().child("phone").setValue(phone.getText().toString());

                                child.getRef().child("domain").setValue(domain.getText().toString());



                                Toastmsg(CorporateProfile.this,"Profile Updated ");
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


    private void Toastmsg(CorporateProfile collectionActivity, String p1)
    {

        Toast.makeText(this,p1,
                Toast.LENGTH_SHORT).show();
    }
}