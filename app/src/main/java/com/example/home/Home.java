package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity implements View.OnClickListener {
    Button request,suggestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        request=findViewById(R.id.btnrequest);
        suggestion=findViewById(R.id.btnsuggestion);
        request.setOnClickListener(this);
        suggestion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==request)
        {
            Intent intent= new Intent(this,HomeRequest.class);
            startActivity(intent);
            finish();
        }
        if (v==suggestion)
        {
            Intent intent= new Intent(this,HomeSuggestion.class);
            startActivity(intent);
            finish();
        }
    }
}
