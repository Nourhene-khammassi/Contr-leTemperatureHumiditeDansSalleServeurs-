package com.example.temphumgeolocalisation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private EditText edtemail, edtpass;
    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtemail = findViewById(R.id.login);
        edtpass = findViewById(R.id.password);
        TextView newaccount = findViewById(R.id.newaccount);
        sharedPref = getSharedPreferences("loginPref", Context.MODE_PRIVATE);


        Button btncnct = findViewById(R.id.btlogin);
        btncnct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });

        newaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(login.this, inscription.class);
                startActivity(intent1);
            }
        });
    }

    private void handleLogin() {
        String email = edtemail.getText().toString();
        String password = edtpass.getText().toString();

        if (email.equals("Admin") && password.equals("admin")) {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("email", email);
            editor.putString("password", password);
            editor.apply();

            showSuccessDialog();
        } else {
            Toast.makeText(login.this, "Vérifiez vos paramètres d'accès", Toast.LENGTH_LONG).show();
        }
    }

    private void showSuccessDialog() {
        AlertDialog.Builder pdialog = new AlertDialog.Builder(this);
        pdialog.setTitle("Connexion avec succès");
        pdialog.setCancelable(true);
        pdialog.setPositiveButton("Continuer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                startHomeActivity();
            }
        });
        pdialog.show();
    }

    private void startHomeActivity() {
        Intent tohomeactivity = new Intent(login.this, home.class);
        startActivity(tohomeactivity);
        finish(); // Terminer cette activité pour éviter de revenir ici avec le bouton "Back"
    }
    private boolean isValidCredentials(String email, String password) {
        // You can implement your own logic for validating credentials.
        // For example, check if the email and password meet certain criteria.
        // Here, I'm using a simple check for demonstration purposes.
        return !email.isEmpty() && !password.isEmpty();
    }
}

