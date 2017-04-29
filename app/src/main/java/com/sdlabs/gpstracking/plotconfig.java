package com.sdlabs.gpstracking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class plotconfig extends AppCompatActivity {



    Button addPlot;
    TextView plot1;
    TextView plot2;
    TextView plot3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plotconfig);


        addPlot = (Button) findViewById(R.id.addPlot);
        plot1 = (TextView) findViewById(R.id.plot1);
        plot2 = (TextView) findViewById(R.id.plot2);
        plot3 = (TextView) findViewById(R.id.plot3);



        addPlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(plotconfig.this, addPlot.class);
                startActivity(registerIntent);

            }
        });



    }





}
