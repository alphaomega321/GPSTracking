package com.sdlabs.gpstracking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class change_username extends AppCompatActivity {


    Button usernameButton;
    EditText old_username1;
    EditText new_username1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_username);
        getSupportActionBar().setTitle("Alpha Farmers");

        usernameButton = (Button) findViewById(R.id.usernameButton);
        old_username1 = (EditText) findViewById(R.id.old_username);
        new_username1 = (EditText) findViewById(R.id.new_username);
    }

    public void OnUsername(View view) {

        String old_username = old_username1.getText().toString();
        String new_username = new_username1.getText().toString();
        String type = "Username";

        BackgroundWorker backgourndWorker = new BackgroundWorker(this);
        backgourndWorker.execute(type, old_username, new_username);



    }


}
