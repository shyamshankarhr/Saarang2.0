package com.example.shyamshankar.saarangreturns;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import java.util.Calendar;

/**
 * Created by Shyam Shankar on 22-05-2016.
 */
public class Decibels extends AppCompatActivity {

    //Declaring image buttons fro calling and sending email
    ImageButton call;
    ImageButton email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.decibels);
        call=(ImageButton)findViewById(R.id.callLogo);

        //on click listener for call button
        call.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v)
            {
                Intent callIntent=new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:8113936122"));
                startActivity(callIntent);
            }
        });
        email=(ImageButton)findViewById(R.id.gmailLogo);
        //on click listener for email button
        email.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v)
            {
                Intent emailIntent=new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"shyamshankarcern@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Inquiry about Decibels");
                emailIntent.setType("message/rfc822");
                startActivity(emailIntent);
            }
        });
    }
    //    function to invoke MapsActivity
    public void showMap(View v)
    {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
    //    function to open Registration portal
    public void registerClick(View v)
    {
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }
    //function to add event to calendar
    public void CalendarClick(View view){

        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType("vnd.android.cursor.item/event");

        Calendar calendar = Calendar.getInstance();

        calendar.setTimeInMillis(System.currentTimeMillis());
        //setting the year, month, and day of the event
        calendar.set(Calendar.YEAR,2017);
        calendar.set(Calendar.MONTH,Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH,4);
        calendar.set(Calendar.HOUR_OF_DAY, 14);
        calendar.set(Calendar.MINUTE, (0));
        long startTime=calendar.getTimeInMillis();
        long endTime= calendar.getTimeInMillis() + 3*60*60*1000;

        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime);
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,endTime);
        intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false);

        intent.putExtra(CalendarContract.Events.TITLE, "Decibels Reminder");
        intent.putExtra(CalendarContract.Events.DESCRIPTION,  "Reach OAT on time for Decibels");
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "OAT");

        startActivity(intent);
    }
}

