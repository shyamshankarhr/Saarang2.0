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

    ListView listView;
    ArrayAdapter<String> adapter;
    String [] eventList = {"Alankar","Decibels", "Freestyle Solo", "Panache", "Scrabble"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);

//        Creating listview
        listView = (ListView)findViewById(R.id.list_view);
//        Creating adapter
        adapter = new ArrayAdapter<String>(this,R.layout.list_view_custom_layout,R.id.list_item, eventList);
        listView.setAdapter(adapter);
//        setting on click listener to list items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Intent intent= new Intent(MainActivity.this, Alankar.class);
                    startActivity(intent);
                }
                if(position==1)
                {
                    Intent intent= new Intent(MainActivity.this, Decibels.class);
                    startActivity(intent);
                }
                if(position==2)
                {
                    Intent intent= new Intent(MainActivity.this, FreestyleSolo.class);
                    startActivity(intent);
                }
                if(position==3)
                {
                    Intent intent= new Intent(MainActivity.this, Panache.class);
                    startActivity(intent);
                }
                if(position==4)
                {
                    Intent intent= new Intent(MainActivity.this, Scrabble.class);
                    startActivity(intent);
                }

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

}
