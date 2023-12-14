package com.example.temphumgeolocalisation;
/*
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class home_humidity extends AppCompatActivity {
    private RecyclerView recyclerViewh;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_hum);

        Button btnh = findViewById(R.id.btngh);
        btnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_humidity.this, graphH.class);
                startActivity(intent);
            }
        });


        String URL = "http://192.168.1.60/";
        Retrofit Rf = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apihandler api = Rf.create(apihandler.class);
        Call<List<thg>> listh = api.getAllHum();
        listh.enqueue(new Callback<List<thg>>() {
            @Override

            public void onResponse(Response<List<thg>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    List<thg> list = response.body();
                    Log.d("Response", "Data received: " + list.toString());
                    recyclerViewh = findViewById(R.id.list_hh);
                    layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerViewh.setLayoutManager(layoutManager);
                    listHadapter Adapter = new listHadapter(getApplicationContext(), list);
                    recyclerViewh.setAdapter(Adapter);
                    DividerItemDecoration dividerItemDecoration =
                            new DividerItemDecoration(recyclerViewh.getContext(), DividerItemDecoration.VERTICAL);
                    recyclerViewh.addItemDecoration(dividerItemDecoration);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(getApplicationContext(), "Error " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
*/
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;

public class home_humidity extends AppCompatActivity {
    private RecyclerView recyclerViewh;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_hum);

        // Création de données fictives pour le RecyclerView
        List<thg> fakeHumidityList = new ArrayList<>();
        fakeHumidityList.add(new thg("1", "25", "50", "2023-12-01"));
        fakeHumidityList.add(new thg("2", "22", "48", "2023-12-02"));
        fakeHumidityList.add(new thg("3", "25", "60", "2023-12-01"));
        fakeHumidityList.add(new thg("4", "22", "80", "2023-12-02"));
        fakeHumidityList.add(new thg("5", "25", "50", "2023-12-01"));
        fakeHumidityList.add(new thg("6", "22", "49", "2023-12-02"));

        recyclerViewh = findViewById(R.id.list_hh);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewh.setLayoutManager(layoutManager);

        // Initialisation de l'Adapter avec les données fictives
        listHadapter Adapter = new listHadapter(getApplicationContext(), fakeHumidityList);
        recyclerViewh.setAdapter(Adapter);

        // Ajout d'une décoration pour le RecyclerView
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewh.getContext(), DividerItemDecoration.VERTICAL);
        recyclerViewh.addItemDecoration(dividerItemDecoration);

        Button btnh = findViewById(R.id.btngh);
        btnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_humidity.this, graphH.class);
                intent.putParcelableArrayListExtra("humidityList", (ArrayList<? extends Parcelable>) fakeHumidityList);
                startActivity(intent);
            }
        });
    }
}
