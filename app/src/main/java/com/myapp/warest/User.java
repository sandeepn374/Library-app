package com.myapp.warest;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by kshravi on 01/11/2017 AD.
 */

public class User  implements Serializable{

    public String name="";
    public String email="";
    public String ph="";
    public String usn="";
    public String gender="";
	public String semester="";
	public String department="";

public User(){}

    public User(String name, String email,String ph,String usn,String gender, String semester,String department) {

        this.name=name;
        this.email=email;
        this.ph=ph;
        this.usn=usn;
        this.gender=gender;
		this.semester=semester;
		this.department= department;


    }

	public CharSequence getname()
	{
		// TODO: Implement this method
		return name;
	}
	void setName(String name){
        this.name=name;
    }

    void setEmail(String name){
        this.email=name;
    }
	
	

}
