package com.myapp.warest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


/**
 * Created by kshravi on 28/11/2017 AD.
 */

public class AboutusActivity extends AppCompatActivity {
    TextView values,mission,vision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);
        values=(TextView)findViewById(R.id.values);
        mission=(TextView)findViewById(R.id.mission);
        vision=(TextView)findViewById(R.id.vision);
    }
}
