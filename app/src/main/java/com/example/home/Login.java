package com.example.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener {
   private Button enter; //Enter button
    private Button back;// Back button
    private EditText mail, password;// Enter mail & password
    private FirebaseAuth firebaseauth;//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        enter=findViewById(R.id.btnenter);
        back=findViewById(R.id.btnback);              //Find button's id
        mail=findViewById(R.id.textmail);
        password=findViewById(R.id.textpassword);
        enter.setOnClickListener(this);
        back.setOnClickListener(this);                //set the buttons
        firebaseauth=FirebaseAuth.getInstance();




    }

    @Override
    public void onClick(View v) {
        if (v==enter) //When we click "enter"
        {
            String tempmail=mail.getText().toString().trim(); //Reduce the email address
            String temppassword=password.getText().toString().trim();//Reduce the password
            if (TextUtils.isEmpty(tempmail))//Check if email address is empty
            {
                mail.setError("email is requaire");//if it is,"email is requaire"
                return;
            }
            if (TextUtils.isEmpty(temppassword))//Check if password is empty
            {
                password.setError("password is requaire");//if it is,"password is requaire"
                return;
            }
            if (temppassword.length()<5)//Check if password's length is smaller than 5
        {
            password.setError("passwors must be higher then 6 character");//if it is,"passwors must be higher then 6 character"
            return;
        }
            firebaseauth.signInWithEmailAndPassword(tempmail, temppassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        finish();
                    }
                    else {
                        Toast.makeText(Login.this, "error " +task.getException().getMessage() , Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
        if (v==back)//When we click "back"
        {
            Intent intent= new Intent(this,MainActivity.class);//Go to "MainActivity"
            startActivity(intent);//start
            finish();
        }

    }
}
