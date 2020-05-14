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
   private Button enter;
    private Button back;
    private EditText mail, password;
    private FirebaseAuth firebaseauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        enter=findViewById(R.id.btnenter);
        back=findViewById(R.id.btnback);
        mail=findViewById(R.id.textmail);
        password=findViewById(R.id.textpassword);
        enter.setOnClickListener(this);
        back.setOnClickListener(this);
        firebaseauth=FirebaseAuth.getInstance();




    }

    @Override
    public void onClick(View v) {
        if (v==enter)
        {
            String tempmail=mail.getText().toString().trim();
            String temppassword=password.getText().toString().trim();
            if (TextUtils.isEmpty(tempmail))
            {
                mail.setError("email is requaire");
                return;
            }
            if (TextUtils.isEmpty(temppassword))
            {
                password.setError("password is requaire");
                return;
            }
            if (temppassword.length()<5)
        {
            password.setError("passwors must be higher then 6 character");
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
        if (v==back)
        {
            Intent intent= new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }

    }
}
