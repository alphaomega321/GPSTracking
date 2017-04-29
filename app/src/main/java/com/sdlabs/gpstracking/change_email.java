package com.sdlabs.gpstracking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class change_email extends AppCompatActivity {

    Button emailButton;
    EditText old_email1;
    EditText new_email1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_email);
        getSupportActionBar().setTitle("Alpha Farmers");

        emailButton = (Button) findViewById(R.id.emailButton);
        old_email1 = (EditText) findViewById(R.id.old_email1);
        new_email1 = (EditText) findViewById(R.id.new_email1);


    }


    public void OnEmail(View view) {

        String old_email = old_email1.getText().toString();
        String new_email = new_email1.getText().toString();
        String type = "Email";

        BackgroundWorker backgourndWorker = new BackgroundWorker(this);
        backgourndWorker.execute(type, old_email, new_email);



    }
}
