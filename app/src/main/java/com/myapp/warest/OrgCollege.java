package com.myapp.warest;

import android.widget.EditText;
import android.widget.Spinner;

import java.io.Serializable;

/**
 * Created by kshravi on 07/12/2017 AD.
 */

public class OrgCollege implements Serializable{

    public String name="";
    public String email="";
    public String phone="",address="",branches="";
    public String  gender="";


    void setName(String name){
        this.name=name;
    }

    void setEmail(String name){
        this.email=name;
    }
}
