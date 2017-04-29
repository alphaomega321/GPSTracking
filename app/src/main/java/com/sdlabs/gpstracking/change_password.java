package com.sdlabs.gpstracking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class change_password extends AppCompatActivity {


    Button passwordButton;
    EditText old_password1;
    EditText new_password1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        getSupportActionBar().setTitle("Change your password");

        passwordButton = (Button) findViewById(R.id.passwordButton);
        old_password1 = (EditText) findViewById(R.id.old_password);
        new_password1 = (EditText) findViewById(R.id.new_password);


    }

    public void OnPassword(View view) {

        String old_password = old_password1.getText().toString();
        String new_password = new_password1.getText().toString();
        String type = "Password";

        BackgroundWorker backgourndWorker = new BackgroundWorker(this);
        backgourndWorker.execute(type, old_password, new_password);



    }
}
