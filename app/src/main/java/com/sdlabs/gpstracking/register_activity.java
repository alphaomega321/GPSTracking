package com.sdlabs.gpstracking;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class register_activity extends AppCompatActivity {

    EditText etKey, etEmail, etPassword, etConfirm, etFullname;
    Button btRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);
        getSupportActionBar().setTitle("Alpha Farmers");

        etKey = (EditText) findViewById(R.id.etKey);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConfirm = (EditText) findViewById(R.id.etConfirm);
        etFullname = (EditText) findViewById(R.id.editText);
        btRegister = (Button) findViewById(R.id.btRegister);







    }



    public void OnReg(View view)
    {
        String user_key = etKey.getText().toString();
        String user_email = etEmail.getText().toString();
        String user_name = etFullname.getText().toString();
        String user_password = etPassword.getText().toString();
        String user_confirm = etConfirm.getText().toString();

        String type = "register";

        BackgroundWorker backgourndWorker = new BackgroundWorker(this);
        backgourndWorker.execute(type, user_key, user_email, user_name, user_password);

    }






}
