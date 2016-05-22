package com.example.shyamshankar.saarangreturns;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Shyam Shankar on 22-05-2016.
 */
public class Registration  extends AppCompatActivity{

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        //Making spinner to view events as drop-down list
        Spinner s = (Spinner)findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.events_list,R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_item);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemIdAtPosition(position)!=0)
                    Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+" is selected.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    //defining the submit button with toast message on being clicked.
    public void submitClick(View v)
    {
        Toast.makeText(Registration.this,"Submitted Successfully!",Toast.LENGTH_LONG).show();
    }
}
