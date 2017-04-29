package com.sdlabs.gpstracking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class account_settings extends AppCompatActivity {

    TextView changeU;
    TextView changeP;
    TextView changeE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);
        getSupportActionBar().setTitle("Account Settings");

        changeU = (TextView) findViewById(R.id.changeU);
        changeP = (TextView) findViewById(R.id.changeP);
        changeE = (TextView) findViewById(R.id.changeE);



        changeU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userIntent = new Intent(account_settings.this, change_username.class);
                startActivity(userIntent);

            }
        });

        changeP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent passwordIntent = new Intent(account_settings.this, change_password.class);
                startActivity(passwordIntent);

            }
        });

        changeE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(account_settings.this, change_email.class);
                startActivity(emailIntent);

            }
        });
    }



}
