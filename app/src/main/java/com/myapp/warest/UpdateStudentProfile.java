package com.myapp.warest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by kshravi on 26/11/2017 AD.
 */

public class UpdateStudentProfile extends AppCompatActivity {

    EditText name;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatestudentprofile);
        name=(EditText)findViewById(R.id.fullname);

        auth = FirebaseAuth.getInstance();
        FirebaseUser u=auth.getCurrentUser();

        FirebaseDatabase.getInstance().getReference().child("users")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            final User user = snapshot.getValue(User.class);

                            if (user.email.equals(auth.getCurrentUser().getEmail()))
                                name.setText(user.name);

                        }


                        }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }


                });






    }

    }


