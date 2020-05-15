package com.example.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseauth;
    private TextView nameregister,passwordregister,mailregister,numberregister;//Enter : name,password,mail,number
    private Button finish; //finish button
    private DatabaseReference d;
    private String temp;
    private char[] temp2,temp1; // chars array



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        finish=findViewById(R.id.btnfinish);
        nameregister=findViewById(R.id.textnameregister);
        passwordregister=findViewById(R.id.textpasswordregister);
        mailregister=findViewById(R.id.textmail);
        numberregister=findViewById(R.id.textnumber);
        finish.setOnClickListener(this);
        firebaseauth=FirebaseAuth.getInstance();
        d= FirebaseDatabase.getInstance().getReference().child("user");


    }

    @Override
    public void onClick(View v) {
        temp = mailregister.getText().toString();//Get the email address
        temp1 = temp.toCharArray();//Get email address to a chars array
        temp2 = new char[temp1.length];//New array in the length of email address
        for (int i = 0;i<temp.length();i++) // for loop to check where is the '@' , and stpos their.
        {
            if (temp1[i] == '@')
            {
                break;
            }
            temp2[i] = temp1[i]; //Reduce the email adrees (until the '@')
        }
        temp = String.valueOf(temp2);//Set new address

        if ( v==finish)//When we click "finish"
        {
            firebaseauth.createUserWithEmailAndPassword(mailregister.getText().toString(),passwordregister.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                        }
                    });
            User user=new User(nameregister.getText().toString(),mailregister.getText().toString(), passwordregister.getText().toString(), numberregister.getText().toString());
            d.push().getKey();
            d.child(temp.trim()).setValue(user);
            Intent intent= new Intent(this,Home.class);
            startActivity(intent);
            finish();
        }

    }
}
