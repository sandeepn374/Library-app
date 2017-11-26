package com.myapp.warest;

import java.util.ArrayList;

/**
 * Created by kshravi on 01/11/2017 AD.
 */

public class User {

    public String name;
    public String email;
    public int ph;
    //public String password;
    public String community;
    public String communitySub;


    public User() {
    }

    public User(String name, String email,int ph,String community,String communitySub) {

        this.name=name;
        this.email=email;
        this.ph=ph;
        this.community=community;
        this.communitySub=communitySub;


    }
}
