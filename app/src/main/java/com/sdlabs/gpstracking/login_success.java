package com.sdlabs.gpstracking;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class login_success extends AppCompatActivity implements OnMapReadyCallback{

    EditText etMessage;
    EditText etTelNr;
    Button button;
    int MY_PERMISSIONS_REUEST_SEND_SMS = 1;
    String SENT = "SMS_SENT";
    String DELIVERED = "SMS_DELIVERED";
    PendingIntent sentPI, deliveredPI;
    BroadcastReceiver smsSentReceiver, smsDeliveredReceiver;
    private static final String TAG = login_success.class.getSimpleName();
    int check = 0;
    String message;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        getSupportActionBar().setTitle("???");
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        etMessage = (EditText)findViewById(R.id.etMessage);
        etTelNr = (EditText)findViewById(R.id.etTelNr);
        button = (Button)findViewById(R.id.button);
        sentPI = PendingIntent.getBroadcast(this, 0, new Intent(SENT), 0);
        deliveredPI = PendingIntent.getBroadcast(this, 0, new Intent(DELIVERED), 0);




    }







    @Override
    public void onMapReady(GoogleMap googleMap) {


        boolean success = googleMap.setMapStyle(new MapStyleOptions(getResources()
                .getString(R.string.style_json)));


        double Latitude = 12.971;
        double Longitude = 79.163;
        LatLng sydney = new LatLng(Latitude, Longitude);
        googleMap.addMarker(new MarkerOptions().position(sydney)
                .title("Marker in Vellore"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        if(getIntent().getStringExtra("msg") != null) {
            String s = getIntent().getStringExtra("msg");


            Latitude = Float.parseFloat(String.valueOf(s.substring(0,6)));
            Longitude = Float.parseFloat(String.valueOf(s.substring(6,12)));
            sydney = new LatLng(Latitude, Longitude);
            googleMap.addMarker(new MarkerOptions().position(sydney)
                    .title("Marker in Vellore"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }



    }


    @Override
    protected void onResume() {
        super.onResume();
        smsSentReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                switch(getResultCode())
                {
                    case Activity.RESULT_OK:
                        Toast.makeText(login_success.this, "SMS sent!", Toast.LENGTH_SHORT).show();
                        break;

                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        Toast.makeText(login_success.this, "Generic failure", Toast.LENGTH_SHORT).show();
                        break;

                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        Toast.makeText(login_success.this, "No service", Toast.LENGTH_SHORT).show();
                        break;

                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        Toast.makeText(login_success.this, "Null PDU", Toast.LENGTH_SHORT).show();
                        break;

                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        Toast.makeText(login_success.this, "Radio Off", Toast.LENGTH_SHORT).show();
                        break;

                }

            }
        };

        smsDeliveredReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                switch(getResultCode())
                {
                    case Activity.RESULT_OK:
                        Toast.makeText(login_success.this, "SMS delivered!", Toast.LENGTH_SHORT).show();
                        break;

                    case Activity.RESULT_CANCELED:
                        Toast.makeText(login_success.this, "SMS not delivered", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        };

        registerReceiver(smsSentReceiver, new IntentFilter(SENT));
        registerReceiver(smsDeliveredReceiver, new IntentFilter(DELIVERED));
    }

    @Override
    protected void onPause() {
        super.onPause();

        unregisterReceiver(smsDeliveredReceiver);
        unregisterReceiver(smsSentReceiver);
    }

    public void btn_SendSMS_OnClick(View v)
    {
        String message = etMessage.getText().toString();
        String telNr = etTelNr.getText().toString();
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS},
                    MY_PERMISSIONS_REUEST_SEND_SMS);
        }

        else
        {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(telNr, null, message, sentPI, deliveredPI);
        }

    }


}
