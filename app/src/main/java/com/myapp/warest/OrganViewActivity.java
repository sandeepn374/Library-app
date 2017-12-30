package com.myapp.warest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class OrganViewActivity extends AppCompatActivity {




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.organviewforadmin);

        FirebaseDatabase.getInstance().getReference().child("OrgCollege")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        int totDue=0;
                        ArrayList<OrgCollege> users=new ArrayList<OrgCollege>();
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            final OrgCollege user = snapshot.getValue(OrgCollege.class);
                            users.add(user);

                        }

                        TableLayout layoutINNER = new TableLayout(OrganViewActivity.this);
                        for(final OrgCollege user:users) {


                            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT,
                                    TableLayout.LayoutParams.WRAP_CONTENT);

                            TextView tv1 = new TextView(OrganViewActivity.this);

                            tv1.setText("Name: "+user.name);


                            TableRow tr1 = new TableRow(OrganViewActivity.this);

                            tr1.setLayoutParams(params);
                            tr1.addView(tv1);
                            tv1.setTextColor(Color.WHITE);
                            tv1.setTextSize(getResources().getDimension(R.dimen.text_size));

                            layoutINNER.addView(tr1);

                            TextView tv2 = new TextView(OrganViewActivity.this);

                            tv2.setText("Email: "+user.email);


                            TableRow tr2 = new TableRow(OrganViewActivity.this);

                            tr2.setLayoutParams(params);
                            tr2.addView(tv2);
                            tv2.setTextColor(Color.WHITE);
                            tv2.setTextSize(getResources().getDimension(R.dimen.text_size));

                            TableRow tr4 = new TableRow(OrganViewActivity.this);

                            Button paid = new Button(OrganViewActivity.this);
                            paid.setText("More");
                            paid.setTextColor(Color.BLACK);
                            paid.setGravity(Gravity.LEFT);
                            int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics());
                            int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                            paid.setLayoutParams(new TableRow.LayoutParams(width, height));
                            // paid.setWidth(5);

                            paid.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {


// To retrieve object in second Activity
                                    Intent intent=new Intent(OrganViewActivity.this,CollegeProfileView.class);

                                    intent.putExtra("MyClass", user);
                                    startActivity(intent);
                                    // startActivity(new Intent(StudentViewActivity.this, StudentProfileView.class));
                                }
                            });
                            tr4.setLayoutParams(params);
                            tr4.addView(paid);

                            layoutINNER.addView(tr2);
                            layoutINNER.addView(tr4);

                            View line = new View(OrganViewActivity.this);
                            line.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, 10));
                            line.setBackgroundColor(Color.rgb(51, 51, 51));
                            layoutINNER.addView(line);




                        }

                        LinearLayout main = (LinearLayout) findViewById(R.id.main_layout);

                        main.addView(layoutINNER);





                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });

        FirebaseDatabase.getInstance().getReference().child("OrgCorporate")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        int totDue=0;
                        ArrayList<Student> users=new ArrayList<Student>();
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            final Student user = snapshot.getValue(Student.class);
                            users.add(user);

                        }

                        TableLayout layoutINNER = new TableLayout(OrganViewActivity.this);
                        for(final Student user:users) {


                            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT,
                                    TableLayout.LayoutParams.WRAP_CONTENT);

                            TextView tv1 = new TextView(OrganViewActivity.this);

                            tv1.setText("Name: "+user.name);


                            TableRow tr1 = new TableRow(OrganViewActivity.this);

                            tr1.setLayoutParams(params);
                            tr1.addView(tv1);
                            tv1.setTextColor(Color.WHITE);
                            tv1.setTextSize(getResources().getDimension(R.dimen.text_size));

                            layoutINNER.addView(tr1);

                            TextView tv2 = new TextView(OrganViewActivity.this);

                            tv2.setText("Email: "+user.email);


                            TableRow tr2 = new TableRow(OrganViewActivity.this);

                            tr2.setLayoutParams(params);
                            tr2.addView(tv2);
                            tv2.setTextColor(Color.WHITE);
                            tv2.setTextSize(getResources().getDimension(R.dimen.text_size));

                            TableRow tr4 = new TableRow(OrganViewActivity.this);

                            Button paid = new Button(OrganViewActivity.this);
                            paid.setText("More");
                            paid.setTextColor(Color.BLACK);
                            paid.setGravity(Gravity.LEFT);
                            int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics());
                            int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                            paid.setLayoutParams(new TableRow.LayoutParams(width, height));
                            // paid.setWidth(5);

                            paid.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {


// To retrieve object in second Activity
                                    Intent intent=new Intent(OrganViewActivity.this,CorporateProfileView.class);

                                    intent.putExtra("MyClass", user);
                                    startActivity(intent);
                                    // startActivity(new Intent(StudentViewActivity.this, StudentProfileView.class));
                                }
                            });
                            tr4.setLayoutParams(params);
                            tr4.addView(paid);

                            layoutINNER.addView(tr2);
                            layoutINNER.addView(tr4);
                            View line = new View(OrganViewActivity.this);
                            line.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, 10));
                            line.setBackgroundColor(Color.rgb(51, 51, 51));
                            layoutINNER.addView(line);



                        }

                        LinearLayout main = (LinearLayout) findViewById(R.id.main_layout);

                        main.addView(layoutINNER);





                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
        FirebaseDatabase.getInstance().getReference().child("OrgTraining")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        int totDue=0;
                        ArrayList<Student> users=new ArrayList<Student>();
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            final Student user = snapshot.getValue(Student.class);
                            users.add(user);

                        }

                        TableLayout layoutINNER = new TableLayout(OrganViewActivity.this);
                        for(final Student user:users) {


                            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT,
                                    TableLayout.LayoutParams.WRAP_CONTENT);

                            TextView tv1 = new TextView(OrganViewActivity.this);

                            tv1.setText("Name: "+user.name);


                            TableRow tr1 = new TableRow(OrganViewActivity.this);

                            tr1.setLayoutParams(params);
                            tr1.addView(tv1);
                            tv1.setTextColor(Color.WHITE);
                            tv1.setTextSize(getResources().getDimension(R.dimen.text_size));

                            layoutINNER.addView(tr1);

                            TextView tv2 = new TextView(OrganViewActivity.this);

                            tv2.setText("Email: "+user.email);


                            TableRow tr2 = new TableRow(OrganViewActivity.this);

                            tr2.setLayoutParams(params);
                            tr2.addView(tv2);
                            tv2.setTextColor(Color.WHITE);
                            tv2.setTextSize(getResources().getDimension(R.dimen.text_size));

                            TableRow tr4 = new TableRow(OrganViewActivity.this);

                            Button paid = new Button(OrganViewActivity.this);
                            paid.setText("More");
                            paid.setTextColor(Color.BLACK);
                            paid.setGravity(Gravity.LEFT);
                            int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics());
                            int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                            paid.setLayoutParams(new TableRow.LayoutParams(width, height));
                            // paid.setWidth(5);

                            paid.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {


// To retrieve object in second Activity
                                    Intent intent=new Intent(OrganViewActivity.this,TrainingProfileView.class);

                                    intent.putExtra("MyClass", user);
                                    startActivity(intent);
                                    // startActivity(new Intent(StudentViewActivity.this, StudentProfileView.class));
                                }
                            });
                            tr4.setLayoutParams(params);
                            tr4.addView(paid);

                            layoutINNER.addView(tr2);
                            layoutINNER.addView(tr4);

                            View line = new View(OrganViewActivity.this);
                            line.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, 10));
                            line.setBackgroundColor(Color.rgb(51, 51, 51));
                            layoutINNER.addView(line);


                        }

                        LinearLayout main = (LinearLayout) findViewById(R.id.main_layout);

                        main.addView(layoutINNER);





                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });

    }










}
