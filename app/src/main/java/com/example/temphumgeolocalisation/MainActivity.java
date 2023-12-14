/*package com.example.temphumgeolocalisation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Définition de la durée d'affichage de l'écran de démarrage en millisecondes (ici, 3000 ms soit 3 secondes)
        final int splashScreenTimeout = 3000;

        // Appel de la méthode onCreate de la classe parent (Activity)
        super.onCreate(savedInstanceState);

        // Définition du layout associé à cette activité (dans ce cas, le layout "activity_main")
        setContentView(R.layout.activity_main);

        // Utilisation d'un objet Handler pour programmer une tâche différée
        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        Log.d("MainActivity", "Handler run method executed");
                        Intent intent = new Intent(MainActivity.this, login.class);
                        startActivity(intent);
                    }
                },
                splashScreenTimeout);
    }

}*/
package com.example.temphumgeolocalisation;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Définition de la durée d'affichage de l'écran de démarrage en millisecondes (ici, 3000 ms soit 3 secondes)
        final int splashScreenTimeout = 3000;

        // Utilisation d'un objet Handler pour programmer une tâche différée
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("MainActivity", "Handler run method executed");
                startLoginActivity();
            }
        }, splashScreenTimeout);
    }

    private void startLoginActivity() {
        if (!isFinishing()) {
            Intent intent = new Intent(this, login.class);
            startActivity(intent);
            // finish(); // Commented out to prevent finishing the main activity
        }
    }

}
