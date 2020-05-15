package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button login;// Login button
    private Button register;// Register button


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.btnlogin);                 //connect to unique ID
        register=findViewById(R.id.btnregister);
        login.setOnClickListener(this);                    //Set the buttons
        register.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v==login) //When we click "login"
        {
            Intent intent= new Intent(this,Login.class);//Go to "login" page
            startActivity(intent);//start this activity
            finish();
        }
        if (v==register) //When we click "register"
        {
            Intent intent= new Intent(this,Register.class);//Go to "register" page
            startActivity(intent);//start
            finish();
        }

    }





}
