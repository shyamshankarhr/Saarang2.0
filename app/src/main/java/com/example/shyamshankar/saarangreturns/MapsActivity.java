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

        // Add a marker in Sydney and move the camera
        LatLng OAT = new LatLng(12.989006, 80.233608);
        mMap.addMarker(new MarkerOptions().position(OAT).title("OAT").snippet("Decibels, Freestyle Solo"));
        LatLng CRC = new LatLng(12.990449, 80.229765);
        mMap.addMarker(new MarkerOptions().position(CRC).title("CRC").snippet("Scrabble"));
        LatLng Gurunath = new LatLng(12.986772, 80.235358);
        mMap.addMarker(new MarkerOptions().position(Gurunath).title("Gurunath").snippet("Grab a snack!"));
        LatLng SAC = new LatLng(12.989274, 80.237695);
        mMap.addMarker(new MarkerOptions().position(SAC).title("SAC").snippet("Alankar, Panache")).showInfoWindow();

        //The info of SAC is shown by default

        float zoomLevel = 15.5f; //This goes up to 21
        //move the camera to the location of OAT initially, with zoom level: 15.5
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(OAT, zoomLevel));
    }

}
