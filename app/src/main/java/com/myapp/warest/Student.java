package com.myapp.warest;

/**
 * Created by kshravi on 26/11/2017 AD.
 */

public class Student extends User {
    User user;


      public int age;
      public String gender="";
    public String course="";
    public String colName="";
    public String university="";
    public String branch="";
    public String country="";
    public String state="";
    public String city="";
    public String requiredTrain="";

public Student(){}
    public Student(User user) {

        this.user=user;

    }
}
