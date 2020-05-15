package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeRequest extends AppCompatActivity implements View.OnClickListener {
    private  TextView destination;
    private TextView start;
    private TextView dateday;                  //Enter: destination,start,dateday,datrmonth
    private TextView datemonth;
    private Button Search,back;          // Search button, back button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_request);
        back= findViewById(R.id.btnback3);
        destination=findViewById(R.id.textdestinationrequest);
        start=findViewById(R.id.textstartrequest);
        datemonth = findViewById(R.id.textdatemonthrequest);
        dateday=findViewById(R.id.textdatedayrequest);
        Search=findViewById(R.id.btnSearch);
        Search.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if ( v==Search)
        {
            String tempdestination=destination.getText().toString().trim();//Reduce destination address
            String tempstart=start.getText().toString().trim();//Reduce start address
            String tempdatemonth=datemonth.getText().toString().trim();//Reduce datemonth text
            String tempdateday=dateday.getText().toString().trim();//Reduce dateday text
            if (tempdestination.isEmpty())
            {
                destination.setError("היעד ריק");
                return;
            }
            if (tempstart.isEmpty())
            {
                start.setError("הנקודת איסוף ריקה");
                return;
            }
            if (tempdatemonth.isEmpty())                                             //Check if one of the details is empty
                                                                                     // If it is, The ___ is empty
            {
                datemonth.setError("החודש ריק");
                return;
            }
            if (tempdateday.isEmpty())
            {
                dateday.setError("היום ריק");
                return;
            }
            if (tempdatemonth.length()<2)       //Check if the date is 2 digits
            {
                datemonth.setError("צריך להירשם כך: 01, 02, 03"); //If not,"Sould sign like this:01,02,03"
                return;
            }
            Intent intent= new Intent(this,HomeSearch.class);
            intent.putExtra("start",start.getText().toString());
            intent.putExtra("destination", destination.getText().toString());     //????????????
            intent.putExtra("dateday",dateday.getText().toString());
            intent.putExtra("datemonth",datemonth.getText().toString());
            startActivity(intent);
            finish();
        }
        if (v==back) //When we click "back"
        {
            Intent intent= new Intent(this, Home.class);//Go to "Home"
            startActivity(intent);
            finish();
        }
    }
}
