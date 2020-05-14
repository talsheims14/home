package com.example.home;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;



import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeSearch extends AppCompatActivity  {
   private RecyclerView recyclerView;
   private DatabaseReference databaseReference;
   private ArrayList<Card> cards;
   private MyAdapter myAdapter;
   private ProgressBar progressBar;
   private String start, destination, dateday,datemonth, tempname, tempnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_serach);
        cards=new ArrayList<Card>();
        recyclerView=findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressBar=findViewById(R.id.progressBar5);
        myAdapter=new MyAdapter(this,cards);
        recyclerView.setAdapter(myAdapter);
            databaseReference= FirebaseDatabase.getInstance().getReference("ride");
            start=getIntent().getStringExtra("start").toString().trim();
            destination=getIntent().getStringExtra("destination").toString().trim();
            dateday=getIntent().getStringExtra("dateday").toString().trim();
            datemonth=getIntent().getStringExtra("datemonth").toString().trim();
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Card c;
                if (dataSnapshot.exists())
                {
                  for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()) {
                          if (dataSnapshot1.child("dateday").getValue().equals(dateday) && dataSnapshot1.child("start").getValue().equals(start)
                                  &&dataSnapshot1.child("datemonth").getValue().equals(datemonth)&&dataSnapshot1.child("destination").getValue().equals(destination)) {
                              c = new Card();
                              c.setDate("תאריך: "+dateday+"/"+datemonth);
                              c.setDestination("יעד: "+destination);
                              c.setStart("נק התחלה: "+start);
                              tempname=(dataSnapshot1.child("name").getValue(String.class));
                              tempnumber=(dataSnapshot1.child("number").getValue(String.class));
                              c.setName("שם: "+tempname);
                              c.setNumber("מספר טלפון: "+tempnumber);
                              progressBar.setVisibility(View.INVISIBLE);
                              cards.add(c);
                          }

                      }

                  }
                myAdapter.notifyDataSetChanged();
                }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

        }

        });
    }
}
