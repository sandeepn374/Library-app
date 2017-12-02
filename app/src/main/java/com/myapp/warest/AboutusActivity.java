package com.myapp.warest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


/**
 * Created by kshravi on 28/11/2017 AD.
 */

public class AboutusActivity extends AppCompatActivity {
    TextView Objective,mission,vision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);
        Objective = (TextView)findViewById(R.id.objective);
        mission = (TextView)findViewById(R.id.mission);
        vision = (TextView)findViewById(R.id.vision);
    }
}
