package com.sdlabs.gpstracking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Manual extends AppCompatActivity {


    Switch pump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);

        pump = (Switch) findViewById(R.id.switch1);

        pump.setChecked(false);

        pump.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if(isChecked){
                    // Switch is on


                }else{
                    // Switch is off


                }

            }
        });
    }
}
