package com.example.shyamshankar.saarangreturns;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    int key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Intent intent = getIntent();
        key = intent.getIntExtra("key",0);

        LatLng OAT = new LatLng(12.989006, 80.233608);
        LatLng CRC = new LatLng(12.990449, 80.229765);
        LatLng Gurunath = new LatLng(12.986772, 80.235358);
        LatLng SAC = new LatLng(12.989274, 80.237695);
        MarkerOptions m1=new MarkerOptions().position(OAT).title("OAT").snippet("Decibels, Freestyle Solo");
        MarkerOptions m2=new MarkerOptions().position(CRC).title("CRC").snippet("Scrabble");
        MarkerOptions m3=new MarkerOptions().position(Gurunath).title("Gurunath").snippet("Grab a snack!");
        MarkerOptions m4=new MarkerOptions().position(SAC).title("SAC").snippet("Alankar, Panache");

        float zoomLevel = 15.5f;//This goes up to 21

        //To automatically zoom to the desired location, and show the info, according to the event selected.
        switch(key){
            case 1:case 4: {
                mMap.addMarker(m1);mMap.addMarker(m2);
                mMap.addMarker(m3);mMap.addMarker(m4).showInfoWindow();
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SAC, zoomLevel));
                break;
            }
            case 2:case 3:
            {
                mMap.addMarker(m1).showInfoWindow();mMap.addMarker(m2);
                mMap.addMarker(m3);mMap.addMarker(m4);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(OAT, zoomLevel));
                break;

            }
            case 5:
            {
                mMap.addMarker(m1);mMap.addMarker(m2).showInfoWindow();
                mMap.addMarker(m3);mMap.addMarker(m4);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CRC, zoomLevel));
                break;
            }
            default: {
                mMap.addMarker(m1);mMap.addMarker(m2);
                mMap.addMarker(m3);mMap.addMarker(m4);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(OAT, zoomLevel));
            }
        }








        //The info of SAC is shown by default


        //move the camera to the location of OAT initially, with zoom level: 15.5

    }

}
