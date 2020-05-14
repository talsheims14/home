package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button login;
    private Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.btnlogin);
        register=findViewById(R.id.btnregister);
        login.setOnClickListener(this);
        register.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v==login)
        {
            Intent intent= new Intent(this,Login.class);
            startActivity(intent);
            finish();
        }
        if (v==register)
        {
            Intent intent= new Intent(this,Register.class);
            startActivity(intent);
            finish();
        }

    }





}
