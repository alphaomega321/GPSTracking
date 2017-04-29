package com.sdlabs.gpstracking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class choose_options extends AppCompatActivity {

    TextView welcome;
    TextView logout;
    Button settings;
    Button location;
    Button register;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_options);
        getSupportActionBar().setTitle("Alpha Farmers");

        welcome = (TextView) findViewById(R.id.welcome);
        logout = (TextView) findViewById(R.id.logout);
        settings = (Button) findViewById(R.id.account);
        location = (Button) findViewById(R.id.vehicle);
        register = (Button)findViewById(R.id.registernew);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(choose_options.this, MainActivity.class);
                startActivity(mainIntent);

            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent accountIntent = new Intent(choose_options.this, account_settings.class);
                startActivity(accountIntent);

            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(choose_options.this, login_success.class);
                startActivity(loginIntent);

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(choose_options.this, plotconfig.class);
                startActivity(registerIntent);

            }
        });










    }





}
