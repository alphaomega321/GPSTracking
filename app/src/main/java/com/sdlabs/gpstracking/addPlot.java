package com.sdlabs.gpstracking;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addPlot extends AppCompatActivity {

    EditText plotId;
    EditText plotName;
    EditText plotLatitude;
    EditText plotLongitude;
    Button buttonLocation;
    Button buttonAdd;

    String plotID;
    String plotNAME;
    String plotLATITUDE;
    String plotLONGITUDE;
    int i=5;

    private LocationManager locationManager;
    private LocationListener locationListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plot);

        plotId = (EditText) findViewById(R.id.plotId);

        plotLatitude = (EditText) findViewById(R.id.plotLatitude);
        plotLongitude = (EditText) findViewById(R.id.plotLongitude);
        buttonAdd = (Button) findViewById(R.id.buttonLocation);
        buttonLocation = (Button) findViewById(R.id.buttonLocation);

        plotID = plotId.getText().toString();

        plotLATITUDE = plotLatitude.getText().toString();
        plotLONGITUDE = plotLongitude.getText().toString();


    }

    public void getLocation(View view) {
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if(i==4) {
            plotLatitude.setText("12.970296");
            plotLongitude.setText("79.155630");
            i--;
        }
        else if(i==3)
        {
            plotLatitude.setText("12.970256");
            plotLongitude.setText("79.155626");
            i--;

        }
        else if(i==2)
        {
            plotLatitude.setText("12.970234");
            plotLongitude.setText("79.155343");
            i--;

        }
        else if(i==1)
        {
            plotLatitude.setText("12.970239");
            plotLongitude.setText("79.155615");
            i--;

        }
        else
        {
            plotLatitude.setText("12.970223");
            plotLongitude.setText("79.155690");
            i--;

        }

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                plotLatitude.setText(""+location.getLongitude());
                plotLongitude.setText(""+location.getLatitude());

            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);

            }
        };

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            requestPermissions(new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET
            }, 10);

        }
        else
        {
            configureButton();
        }



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode){
            case 10:
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    configureButton();
                return;

        }
    }

    private void configureButton() {

        locationManager.requestLocationUpdates("gps", 5000, 5, locationListener);
    }

    public void Add(View view)
    {

    }

}
