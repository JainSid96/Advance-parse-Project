package com.example.msjapplication.parse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

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

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");

        //query.whereEqualTo("username" , "arpit");
        //query.setLimit(1);

        query.whereGreaterThan("score" , 100);

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {

                if (e == null){
                    Log.i("FindinBackgrond" , "Retrieved : " + objects.size() + " objects");
                    if (objects.size() > 0){
                        for (ParseObject object : objects){

                            Log.i("findInBackround" , object.getString("username") + " : " + Integer.toString(object.getInt("score")) + " + 50 extra");
                            object.put("score" , object.getInt("score") + 50);
                            object.saveInBackground();


                        }
                    }
                }
            }
        });


        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
