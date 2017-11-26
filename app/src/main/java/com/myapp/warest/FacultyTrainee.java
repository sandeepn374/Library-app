package com.myapp.warest;

/**
 * Created by kshravi on 26/11/2017 AD.
 */

public class FacultyTrainee extends User{

public User user;

    int age;
    String gender="";
    String qualification="";
    String desgnation="";

    public FacultyTrainee(){}



    public FacultyTrainee(User user){

        this.user=user;


    }


}
