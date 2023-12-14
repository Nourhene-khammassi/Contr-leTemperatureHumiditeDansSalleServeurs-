package com.example.temphumgeolocalisation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {
    public static final String EMAIL_EXTRA ="user_email";
    public static final String PASSWORD_EXTRA ="user_password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button btn1 = (Button)findViewById(R.id.temp);
        Button btn2 = (Button)findViewById(R.id.hum);
        Button btn3 = (Button)findViewById(R.id.geol);
        Button btn4 = findViewById(R.id.camera);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3= new Intent(home.this,home_temp.class);
                startActivity(intent3);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4= new Intent(home.this,home_humidity.class);
                startActivity(intent4);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentgeo=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:34.839329236404154, 10.757663149398237"));
              // Intent intentgeo= new Intent(home.this, geolocalisation.class);
                startActivity(intentgeo);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, Appeler.class);
                startActivity(intent);
            }
        });

    }
}

