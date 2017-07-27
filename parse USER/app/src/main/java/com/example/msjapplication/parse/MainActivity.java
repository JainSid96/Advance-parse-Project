package com.example.msjapplication.parse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("5a967a381894abccdb56c1c6ecc4b385409b1c3f")
                .clientKey("630027cb21a16f374934feedd9195e90a86f6711")
                .server("http://ec2-13-126-125-192.ap-south-1.compute.amazonaws.com:80/parse/")
                .build()
        );

        ParseUser.logOut(); //to log out

        if (ParseUser.getCurrentUser() != null){
            Log.i("Current" , "user logged in " + ParseUser.getCurrentUser().getUsername()); //to check logeed user
        }else {
            Log.i("Current" , "user not logged");
        }
/*
        //checking logging in
        ParseUser.logInInBackground("Siddhant jain", "asfdaf", new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (user != null){
                    Log.i("Login : " , "Sucessfull");
                }else{
                    Log.i("Login : " , "Failed");
                }
            }
        });


        ParseUser user = new ParseUser();
        user.setUsername("Siddhant Jain");
        user.setPassword("tyson");

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {

                if (e == null){
                    Log.i("Sign Up" , "Sucessfull");
                }else{
                    Log.i("Sign Up" , "Failed");
                }

            }
        });
        */

        //ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
