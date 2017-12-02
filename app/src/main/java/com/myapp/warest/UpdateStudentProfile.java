package com.myapp.warest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.*;
import com.google.firebase.storage.*;
import android.net.*;
import com.google.android.gms.tasks.*;
import android.support.annotation.*;

/**
 * Created by kshravi on 26/11/2017 AD.
 */

public class UpdateStudentProfile extends AppCompatActivity {

    EditText name,age,course,college,branch,country,university,state,city,reTrain;
     FirebaseAuth auth;
    Spinner gender;
    Button update,view,upload;

	ProgressDialog pd;

    //creating reference to firebase storage
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReferenceFromUrl("gs://warest-77e4b.appspot.com/");
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatestudentprofile);
		
        name=(EditText)findViewById(R.id.fullname);
        age=(EditText)findViewById(R.id.age);
        course=(EditText)findViewById(R.id.ongoingcourse);
        college=(EditText)findViewById(R.id.college);
        branch=(EditText)findViewById(R.id.branch);
        country=(EditText)findViewById(R.id.country);
        university=(EditText)findViewById(R.id.university);
        state=(EditText)findViewById(R.id.state);
        city=(EditText)findViewById(R.id.city);
        reTrain=(EditText)findViewById(R.id.reqdtraining);
        gender=(Spinner) findViewById(R.id.gender);

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("students");
        mDatabase.keepSynced(true);
        mDatabase.addValueEventListener(new ValueEventListener() {

            @Override
            public void onCancelled(DatabaseError p1)
            {

            }


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {


                    if(child.child("email").getValue().toString().equals(auth.getCurrentUser().getEmail())){
                        name.setText(child.child("name").getValue().toString());

                        age.setText(child.child("age").getValue().toString());
if(child.child("gender").getValue().toString().equals("Male"))
    gender.setSelection(1);
else if (child.child("gender").getValue().toString().equals("Female"))
    gender.setSelection(2);
else
    gender.setSelection(0);

                        course.setText(child.child("course").getValue().toString());

                        city.setText(child.child("city").getValue().toString());

                        college.setText(child.child("colName").getValue().toString());

                        country.setText(child.child("country").getValue().toString());

                        state.setText( child.child("state").getValue().toString());

                        university.setText( child.child("university").getValue().toString());

                        reTrain.setText( child.child("requiredTrain").getValue().toString());

                        branch.setText(child.child("branch").getValue().toString());

                    }

                }
            }
        });



        auth = FirebaseAuth.getInstance();
        final FirebaseUser u=auth.getCurrentUser();

        update=(Button)findViewById(R.id.update);
        view=(Button) findViewById(R.id.viewprofile);
		upload=(Button)findViewById(R.id.upload);
	
		pd = new ProgressDialog(this);
        pd.setMessage("Uploading....");
	
		upload.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent myIntent = new Intent(Intent.ACTION_GET_CONTENT);
					myIntent.setType("image/*");
					startActivityForResult(Intent.createChooser(myIntent,"Select File:-"),101);
				}
			});
	

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(UpdateStudentProfile.this, ViewStudentProfile.class));

            }
                                  });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
                mDatabase.keepSynced(true);
                Query query = mDatabase.child("students");
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (final DataSnapshot child : dataSnapshot.getChildren()) {

                         //   String email= () child.child("email").getValue();
                            if (child.child("email").getValue().equals(auth.getCurrentUser().getEmail())){

                                child.getRef().child("age").setValue(age.getText().toString());

                                child.getRef().child("gender").setValue(gender.getSelectedItem().toString());

                                child.getRef().child("course").setValue(course.getText().toString());

                                child.getRef().child("colName").setValue(college.getText().toString());

                                child.getRef().child("country").setValue(country.getText().toString());

                                child.getRef().child("branch").setValue(branch.getText().toString());

                                child.getRef().child("university").setValue(university.getText().toString());

                                child.getRef().child("state").setValue(state.getText().toString());

                                child.getRef().child("city").setValue(city.getText().toString());
                                child.getRef().child("requiredTrain").setValue(reTrain.getText().toString());
                                Toastmsg(UpdateStudentProfile.this,"Profile Updated ");
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
		
		
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		if(resultCode==RESULT_CANCELED)
		{
			// action cancelled
		}
		if(resultCode==RESULT_OK)
		{
			
			// Create a storage reference 
			Uri uri = data.getData();
			if(uri != null) {
				pd.show();
			}
			StorageReference riversRef = storageRef.child(auth.getCurrentUser().getEmail());
			UploadTask uploadTask = riversRef.putFile(uri);

			// Register observers to listen for when the download is done or if it fails
			uploadTask.addOnFailureListener(new OnFailureListener() {
					@Override
					public void onFailure(@NonNull Exception exception) {
						// Handle unsuccessful uploads
						Toast.makeText(UpdateStudentProfile.this, "Upload Failed", Toast.LENGTH_SHORT).show();
						pd.dismiss();
					}
				}).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
					@Override
					public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
						// taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
						Toast.makeText(UpdateStudentProfile.this, "Upload Success", Toast.LENGTH_SHORT).show();
						pd.dismiss();
					}
				});
		}
		
	}	
		
			
    private void Toastmsg(UpdateStudentProfile collectionActivity, String p1)
    {

        Toast.makeText(this,p1,
                Toast.LENGTH_SHORT).show();
    }









}




