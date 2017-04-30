package com.sdlabs.gpstracking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Time;

public class Automatic extends AppCompatActivity {

    EditText from;
    EditText to;
    Button set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automatic);

        from = (EditText) findViewById(R.id.from);
        to = (EditText) findViewById(R.id.to);
        set = (Button) findViewById(R.id.set);

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }


}
