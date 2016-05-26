package com.example.shyamshankar.saarangreturns;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Calendar;


/**
 * Created by Shyam Shankar on 21-05-2016.
 */
public class MainActivity extends AppCompatActivity {

    //Initialising Event title, description, coordinator name, phone number,etc.
    public static final String EXTRA_TITLE = "EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION= "EXTRA_DESCRIPTION";
    public static final String EXTRA_COORDINATOR= "EXTRA_COORDINATOR";
    public static final String EXTRA_PHONE= "EXTRA_PHONE"; // Phone no. stored as String for convenience.
    public static final String EXTRA_EMAIL= "EXTRA_EMAIL";
    public static final String EXTRA_LOCATION= "EXTRA_LOCATION";
    public static final String EXTRA_REWARD= "EXTRA_REWARD";
    public static final String EXTRA_DATE= "EXTRA_DATE";
    public static final String EXTRA_TIMING= "EXTRA_TIMING";
    public static final int key=0; //this integer keeps track of item position, so as to give appropriate image, map position.

    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayAdapter<CharSequence> details_adapter;
    ArrayAdapter<CharSequence> coordName_adapter,phone_adapter, email_adapter, locations, reward, date, timing;


    String [] eventList = {"Alankar","Decibels", "Freestyle Solo", "Panache", "Scrabble"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);

//        Creating listview
        listView = (ListView)findViewById(R.id.list_view);
//        Creating adapters
        adapter = new ArrayAdapter<String>(this,R.layout.list_view_custom_layout,R.id.list_item, eventList);
        details_adapter = ArrayAdapter.createFromResource(this, R.array.details_list, android.R.layout.simple_list_item_1);
        coordName_adapter = ArrayAdapter.createFromResource(this, R.array.coordinator_names, android.R.layout.simple_list_item_1);
        phone_adapter = ArrayAdapter.createFromResource(this, R.array.phoneNumbers, android.R.layout.simple_list_item_1);
        email_adapter = ArrayAdapter.createFromResource(this, R.array.emailIds, android.R.layout.simple_list_item_1);
        locations = ArrayAdapter.createFromResource(this, R.array.locations, android.R.layout.simple_list_item_1);
        reward = ArrayAdapter.createFromResource(this, R.array.rewards, android.R.layout.simple_list_item_1);
        date = ArrayAdapter.createFromResource(this, R.array.dates, android.R.layout.simple_list_item_1);
        timing = ArrayAdapter.createFromResource(this, R.array.timings, android.R.layout.simple_list_item_1);

        listView.setAdapter(adapter);
//        setting on click listener to list items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Alankar.class);
                Bundle extras = new Bundle();
                extras.putString("EXTRA_TITLE",adapter.getItem(position));
                extras.putString("EXTRA_DESCRIPTION",details_adapter.getItem(position).toString());
                extras.putString("EXTRA_COORDINATOR",coordName_adapter.getItem(position).toString());
                extras.putString("EXTRA_PHONE",phone_adapter.getItem(position).toString());
                extras.putString("EXTRA_EMAIL",email_adapter.getItem(position).toString());
                extras.putString("EXTRA_LOCATION",locations.getItem(position).toString());
                extras.putString("EXTRA_REWARD",reward.getItem(position).toString());
                extras.putString("EXTRA_DATE",date.getItem(position).toString());
                extras.putString("EXTRA_TIMING",timing.getItem(position).toString());
                extras.putInt("key",position);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }

//    function to invoke MapsActivity
    public void showMap(View v)
    {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("key",0);
        startActivity(intent);
    }

    //    function to open Registration portal
    public void registerClick(View v)
    {
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }

}
