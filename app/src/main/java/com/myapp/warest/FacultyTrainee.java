package com.myapp.warest;

import java.io.Serializable;

/**
 * Created by kshravi on 26/11/2017 AD.
 */

public class FacultyTrainee implements Serializable{


    public String name="";
    public String email="";
    public String ph="";
    public String community="";
    public String communitySub="";
    public String age="";
    public String gender="";
    public String designation="";
    public String qualification="";




    void setName(String name){
        this.name=name;
    }

    void setEmail(String name){
        this.email=name;
    }




}
