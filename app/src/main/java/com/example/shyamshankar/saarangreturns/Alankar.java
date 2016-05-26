package com.example.shyamshankar.saarangreturns;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by Shyam Shankar on 22-05-2016.
 */
public class Alankar extends AppCompatActivity {

    //Declaring image buttons for calling and sending email
    ImageButton call;
    ImageButton email;

    String title="";
    int key=0;
    String event_location;

    Button MapDisp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_detail);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        title = extras.getString("EXTRA_TITLE");
        String description = extras.getString("EXTRA_DESCRIPTION");
        String coordinator = extras.getString("EXTRA_COORDINATOR");
        final String phone_no = extras.getString("EXTRA_PHONE");
        final String email_id = extras.getString("EXTRA_EMAIL");
        event_location = extras.getString("EXTRA_LOCATION");
        String reward = extras.getString("EXTRA_REWARD");
        String date = extras.getString("EXTRA_DATE");
        String timing = extras.getString("EXTRA_TIMING");

        key = extras.getInt("key");

        TextView titleView = (TextView) findViewById(R.id.titleText);
        titleView.setText(title);

        TextView textDesc = (TextView) findViewById(R.id.eventDesc);
        textDesc.setText(description);

        TextView textCoord = (TextView) findViewById(R.id.coord);
        textCoord.setText("Coordinator: "+coordinator);

        TextView textLocation = (TextView) findViewById(R.id.location);
        textLocation.setText("Location: "+event_location);

        TextView textReward = (TextView) findViewById(R.id.cash);
        textReward.setText("Prize: ₹"+reward);

        TextView textDate = (TextView) findViewById(R.id.date);
        textDate.setText(date);

        TextView textTime = (TextView) findViewById(R.id.time);
        textTime.setText(timing);


        //Defining Button for navigating to registration portal
        Button regBut = (Button) findViewById(R.id.regButton);
        regBut.setText("Register for "+title);

        //Setting the appropriate image for the event:
        ImageView eventImage = (ImageView) findViewById(R.id.imageEvent);
        switch(key)
        {
            case 0:{
                eventImage.setImageResource(R.drawable.alankar);
                break;
            }
            case 1:{
                eventImage.setImageResource(R.drawable.decibels);
                break;
            }
            case 2:{
                eventImage.setImageResource(R.drawable.freestyle_solo);
                break;
            }
            case 3:{
                eventImage.setImageResource(R.drawable.panache);
                break;
            }
            case 4:{
                eventImage.setImageResource(R.drawable.scrabble);
                break;
            }
            default:
                eventImage.setImageResource(R.drawable.decibels);
        }

        call=(ImageButton)findViewById(R.id.callLogo);
        //on click listener for call button
        call.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v)
            {
                Intent callIntent=new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+phone_no));
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
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email_id});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Inquiry about "+title);
                emailIntent.setType("message/rfc822");
                startActivity(emailIntent);
            }
        });
    }
    //    function to invoke MapsActivity
    public void showMap(View v)
    {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("key",(key+1));  // 1 is added to position, so as to set the key of first event as 1.
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
        calendar.set(Calendar.DAY_OF_MONTH,3);
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        calendar.set(Calendar.MINUTE, 30);
        long startTime=calendar.getTimeInMillis();
        long endTime= calendar.getTimeInMillis() + 150*60*60*1000;

        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime);
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,endTime);
        intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false);

        intent.putExtra(CalendarContract.Events.TITLE, title+" Reminder");
        intent.putExtra(CalendarContract.Events.DESCRIPTION,  "Reach "+event_location+" on time for "+title);
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION, event_location);

        startActivity(intent);
    }
}
