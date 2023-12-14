package com.example.temphumgeolocalisation;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class inscription extends AppCompatActivity {
    public static final int Account=10;
    private final static String TG="";
    private EditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        Button btninscrit =(Button) findViewById(R.id.btinscrit);
        btninscrit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Intent intent2 = new Intent(inscription.this,home.class);
                startActivity(intent2);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Account) {
            if (requestCode == RESULT_OK) {
                String password = data.getStringExtra(home.PASSWORD_EXTRA);
                String mail = data.getStringExtra(home.EMAIL_EXTRA);
                Toast.makeText(this, "password =" + password + " Email=" + mail, Toast.LENGTH_LONG).show();
            }
        }
    }
}

