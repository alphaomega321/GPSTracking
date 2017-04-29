package com.sdlabs.gpstracking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class forget_activity extends AppCompatActivity {

    Button resetButton;
    EditText old_key1;
    EditText reset_password1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_activity);
        getSupportActionBar().setTitle("Alpha Farmers");

        resetButton = (Button) findViewById(R.id.resetButton);
        old_key1 = (EditText) findViewById(R.id.old_key);
        reset_password1 = (EditText) findViewById(R.id.reset_password);

    }


    public void OnForget(View view) {

        String old_key = old_key1.getText().toString();
        String reset_password = reset_password1.getText().toString();
        String type = "Recover";

        BackgroundWorker backgourndWorker = new BackgroundWorker(this);
        backgourndWorker.execute(type, old_key, reset_password);



    }
}
