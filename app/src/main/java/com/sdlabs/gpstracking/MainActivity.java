package com.sdlabs.gpstracking;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;

import static com.sdlabs.gpstracking.R.layout.activity_register_activity;

public class MainActivity extends AppCompatActivity {

    Button blogin;
    EditText etusername, etpassword;
    TextView tvForget, tvRegister,attempts;
    TextView counter;
    int phyC = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Sign In");
        etusername = (EditText) findViewById(R.id.etusername);
        etpassword = (EditText) findViewById(R.id.etpassword);
        blogin = (Button) findViewById(R.id.login);
        tvForget = (TextView) findViewById(R.id.tvForget);
        tvRegister = (TextView) findViewById(R.id.tvRegister);
        attempts = (TextView) findViewById(R.id.attempts);
        counter = (TextView) findViewById(R.id.counter);

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(MainActivity.this, register_activity.class);
                startActivity(registerIntent);

            }
        });

        tvForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forgetIntent = new Intent(MainActivity.this, forget_activity.class);
                startActivity(forgetIntent);
            }
        });

        System.out.print("Hello World!");
    }

    public void OnLogin(View view)
    {
        String user_name = etusername.getText().toString();
        String user_password = etpassword.getText().toString();
        TextView attempts = (TextView) findViewById(R.id.attempts);
        attempts.setVisibility(View.VISIBLE);
        String type = "login";
        phyC--;
        counter.setText(Integer.toString(phyC));

        if(phyC != 0)
        {
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type, user_name, user_password);

        }

        else
        {
            phyC = 5;
            Intent newIntent = new Intent(MainActivity.this, forget_activity.class);
            startActivity(newIntent);

        }
    }
}
