package com.example.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeSuggestion extends AppCompatActivity implements View.OnClickListener {
    private TextView destination,start,datemonth,dateday,name, number;
    private Button yes, back;
    DatabaseReference t;
    private long Maxid=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_suggestion);
        name=findViewById(R.id.textsuggestionname);
        number=findViewById(R.id.textsuggestionnumber);
        back=findViewById(R.id.btnback2);
        destination=findViewById(R.id.textdestinationsuggestion);
        start=findViewById(R.id.textstartsuggestion);
        datemonth=findViewById(R.id.textdatesuggestionmonth);
        dateday=findViewById(R.id.textsuggestionday);
        yes=findViewById(R.id.btnyes);
        back.setOnClickListener(this);
        yes.setOnClickListener( this);
        t= FirebaseDatabase.getInstance().getReference().child("ride");
        t.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    Maxid=dataSnapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v==yes)
        {
            String tempdestination=destination.getText().toString().trim();
            String tempstart=start.getText().toString().trim();
            String tempdatemonth=datemonth.getText().toString().trim();
            String tempdateday=dateday.getText().toString().trim();
            String tempname=name.getText().toString().trim();
            String tempnumber=number.getText().toString().trim();
            if (tempname.isEmpty())
            {
                name.setError("השם ריק");
                return;
            }
            if (tempnumber.isEmpty())
            {
                number.setError("המספר טלפון ריק");
                return;
            }
            if (tempdestination.isEmpty())
            {
                destination.setError("היעד ריק");
                return;
            }
            if (tempdatemonth.isEmpty())
            {
                datemonth.setError("החודש ריק");
                return;
            }
            if (tempdateday.isEmpty())
            {
                dateday.setError("היום ריק");
            }
            if (tempstart.isEmpty())
            {
                start.setError("הנקודת מוצא ריקה");
                return;
            }
            if (tempdatemonth.length()<2)
            {
                datemonth.setError("צריך להירשם כך: 02,03,04");
                return;
            }

            Ride ride= new Ride(destination.getText().toString(),start.getText().toString(),datemonth.getText().toString(),dateday.getText().toString(),name.getText().toString(),number.getText().toString());
            t.push().getKey();
            t.child(String.valueOf(Maxid+1)).setValue(ride);
            Intent intent= new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        if (v==back)
        {
            Intent intent= new Intent(this,Home.class);
            startActivity(intent);
            finish();
        }

    }
}
