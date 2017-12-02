package com.myapp.warest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import android.widget.*;
import com.google.firebase.storage.*;
import com.google.android.gms.tasks.*;
import android.support.annotation.*;
import com.bumptech.glide.*;
import android.net.*;
import android.util.*;
import com.bumptech.glide.request.target.*;
import android.app.*;

public class ViewStudentProfile extends AppCompatActivity {

    TextView name,age,course,college,branch,country,university,state,city,reTrain,gender;
    Button update,view;
	ImageView profileImage;
    FirebaseAuth auth; 
	FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReferenceFromUrl("gs://warest-77e4b.appspot.com/");
	
	boolean imagef,dataf;
	//ProgressDialog pd;

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewprofile);
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
		profileImage=(ImageView)findViewById(R.id.profileImage);
	
	
	


		
        auth = FirebaseAuth.getInstance();
        final FirebaseUser u=auth.getCurrentUser();
		//pd.show();
	
		final StorageReference imgRef = storageRef.child(u.getEmail());
		
		imgRef.getDownloadUrl().addOnSuccessListener(this, new OnSuccessListener<Uri>() {
				@Override
				public void onSuccess(Uri uri) {
					
					//Log.i(TAG, "Download URL : " + uri); // https://firebasestorage.googleapis.com/v0/b/questionpaper-ce229.appspot.com/o/qimgs%2F-KiTpzP5t-xJOO5nSK0A%2F1493896460324-ch1pg2.jpg?alt=media&token=ca2a3f6e-3eb5-4088-a48d-069ac8ad640b
					Glide.with(ViewStudentProfile.this)
						.load(uri)
						.override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
						.into(profileImage);
						
					imagef=true;	
					
					if(imagef &&dataf) {
						//pd.dismiss();
					}	
				}
			});
		
		
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
						name.setText("Name :  " +child.child("name").getValue().toString());
						
						age.setText("Age   :  "+child.child("age").getValue().toString());

                        gender.setText("Gender : "+child.child("gender").getValue().toString());

                        course.setText("Ongoing Course   : "+child.child("course").getValue().toString());

                        city.setText("City  :  "+   child.child("city").getValue());

                        college.setText("College : "+child.child("colName").getValue());

						country.setText( "Country : "+child.child("country").getValue().toString());

						state.setText( "State : "+child.child("state").getValue().toString());

						university.setText( "University : "+child.child("university").getValue());

						reTrain.setText( "Required Training : "+child.child("requiredTrain").getValue());

                        branch.setText( "Branch : "+child.child("branch").getValue());
							
						}
						dataf=true;
						
						if(imagef &&dataf) {
							//pd.dismiss();
						}
					}
				}
			});
		
		
			
    } 
}
