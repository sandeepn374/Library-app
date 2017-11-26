package com.myapp.warest;

import java.util.ArrayList;

/**
 * Created by kshravi on 01/11/2017 AD.
 */

public class User {

    public String name;
    public String email;
    public String ph;
    public String community;
    public String communitySub;


    public User() {
    }

    public User(String name, String email,String ph,String community,String communitySub) {

        this.name=name;
        this.email=email;
        this.ph=ph;
        this.community=community;
        this.communitySub=communitySub;


    }


    public User(User user) {


        this.name=user.name;
        this.email=user.email;
        this.ph=user.ph;
        this.community=user.community;
        this.communitySub=user.communitySub;





    }
}
