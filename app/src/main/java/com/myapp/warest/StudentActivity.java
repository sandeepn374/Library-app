package com.myapp.warest;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.firebase.auth.*;
import android.net.*;
import android.app.*;
import com.google.firebase.storage.*;
import com.google.android.gms.tasks.*;
import android.support.annotation.*;
import android.widget.*;



public class StudentActivity extends AppCompatActivity
{
    ActionBarDrawerToggle drawerToggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    Button updateprofile,videoProfile;

    FragmentManager fragmentManager;
    NavigationView navigationView;
    FrameLayout frameLayout;



	Uri filePath;
    ProgressDialog pd;

    //creating reference to firebase storage
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReferenceFromUrl("gs://warest-77e4b.appspot.com/");
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        fragmentManager = getSupportFragmentManager();

        setupView();
		// if (savedInstanceState == null) showHome();
    }

    private void setupView()
	{
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        frameLayout = (FrameLayout) findViewById(R.id.content_frame);
        updateprofile=(Button) findViewById(R.id.Updatestudentprofile);
		videoProfile=(Button)findViewById(R.id.videoProfile);
	
		pd = new ProgressDialog(this);
        pd.setMessage("Uploading....");
	
		videoProfile.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent();
					intent.setType("video/mp4");
					intent.setAction(Intent.ACTION_PICK);
					startActivityForResult(Intent.createChooser(intent, "Select a file"), 101);
				}
			});
		

        updateprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentActivity.this, UpdateStudentProfile.class));
            }
        });


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
				@Override
				public boolean onNavigationItemSelected(MenuItem menuItem)
				{
					//selectDrawerItem(menuItem);
					if (menuItem.getItemId() == R.id.contactus)
					{
						startActivity(new Intent(StudentActivity.this, ContactusActivity.class));
						
					}
					 if (menuItem.getItemId() == R.id.logout)
					{
						FirebaseAuth.getInstance().signOut();
						startActivity(new Intent(StudentActivity.this, StartScreenActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP ));
						finish();
					}
					if(menuItem.getItemId()==R.id.aboutus) {
						startActivity(new Intent(StudentActivity.this, AboutusActivity.class));
						}
					return true;
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
			pd.show();
			StorageReference riversRef = storageRef.child("profilevideos/"+FirebaseAuth.getInstance().getCurrentUser().getEmail());
			UploadTask uploadTask = riversRef.putFile(uri);

			// Register observers to listen for when the download is done or if it fails
			uploadTask.addOnFailureListener(new OnFailureListener() {
					@Override
					public void onFailure(@NonNull Exception exception) {
						// Handle unsuccessful uploads
							pd.dismiss();
						Toast.makeText(StudentActivity.this, "Upload Failed", Toast.LENGTH_SHORT).show();
					}
				}).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
					@Override
					public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
						// taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
						pd.dismiss();
						Toast.makeText(StudentActivity.this, "Upload Success", Toast.LENGTH_SHORT).show();
					}
				});
		}
		}
	

    private void showHome()
	{
        selectDrawerItem(navigationView.getMenu().getItem(0));
        drawerLayout.openDrawer(GravityCompat.START);
    }

    private void selectDrawerItem(MenuItem menuItem)
	{
        boolean specialToolbarBehaviour = false;
        Class fragmentClass = null;

        switch (menuItem.getItemId())
		{
            case R.id.aboutus:
             //   startActivity(new Intent(StudentActivity.this, AboutusActivity.class));
                break;

            case R.id.contactus:
               // startActivity(new Intent(StudentActivity.this, AboutusActivity.class));
                break;

            default:
                fragmentClass = HomeFragment.class;
                break;
        }

        try
		{
            Fragment fragment = (Fragment) fragmentClass.newInstance();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        }
		catch (Exception e)
		{
            e.printStackTrace();
        }

        setToolbarElevation(specialToolbarBehaviour);
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        drawerLayout.closeDrawers();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setToolbarElevation(boolean specialToolbarBehaviour)
	{
        if (specialToolbarBehaviour)
		{
            toolbar.setElevation(0.0f);
            frameLayout.setElevation(getResources().getDimension(R.dimen.elevation_toolbar));
        }
		else
		{
            toolbar.setElevation(getResources().getDimension(R.dimen.elevation_toolbar));
            frameLayout.setElevation(0.0f);
        }
    }

    public void showSnackbarMessage(View v)
	{/*
		 EditText et_snackbar = (EditText) findViewById(R.id.et_snackbar);
		 TextInputLayout textInputLayout = (TextInputLayout) findViewById(R.id.textInputLayout);
		 View view = findViewById(R.id.coordinator_layout);
		 if (et_snackbar.getText().toString().isEmpty()) {
		 textInputLayout.setError(getString(R.string.alert_text));
		 } else {
		 textInputLayout.setErrorEnabled(false);
		 et_snackbar.onEditorAction(EditorInfo.IME_ACTION_DONE);
		 Snackbar.make(view, et_snackbar.getText().toString(), Snackbar.LENGTH_LONG)
		 .setAction(getResources().getString(android.R.string.ok), new View.OnClickListener() {
		 @Override
		 public void onClick(View v) {
		 // Do nothing
		 }
		 })
		 .show();
		 }*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
	{
        return drawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState)
	{
        drawerToggle.syncState();
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
	{
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }
}
