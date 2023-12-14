package com.example.temphumgeolocalisation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.Response;
import java.util.ArrayList;
import java.util.List;
import retrofit.Call;
import retrofit.GsonConverterFactory;

import retrofit.Retrofit;
/*public class home_temp extends AppCompatActivity {
    private RecyclerView recyclerViewt;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_temp);
        Button btn = (Button)findViewById(R.id.btngt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5= new Intent(home_temp.this,graphT.class);
                startActivity(intent5);
            }
        });
        //String URL ="http://172.16.23.200:80/";
        String URL ="http://10.26.15.1:80/";
        Retrofit Rf = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        apihandler api = Rf.create(apihandler.class);
        Call<List<thg>> listt= api.getAllTemp();
        listt.enqueue(new Callback<List<thg>>() {
            @Override
            public void onResponse(Response<List<thg>> response, Retrofit retrofit) {
                List<thg> list = new ArrayList<thg>();
                if(response.isSuccess()){
                    list = (List<thg>) response.body();
                    recyclerViewt= findViewById(R.id.list_hh);
                    layoutManager =new
                            LinearLayoutManager(getApplicationContext());
                    recyclerViewt.setLayoutManager(layoutManager);
                    listHadapter Adapter = new listHadapter(getApplicationContext(), list);
                    recyclerViewt.setAdapter(Adapter);
                    DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewt.getContext(),DividerItemDecoration.VERTICAL);
                    recyclerViewt.addItemDecoration(dividerItemDecoration);
                }
            }
            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(getApplicationContext(), "Error "+
                        t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}*/

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;

public class home_temp extends AppCompatActivity {
    private RecyclerView recyclerViewt;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_temp);

        // Création de données fictives pour le RecyclerView
        List<thg> fakeTemperatureList = new ArrayList<>();
        fakeTemperatureList.add(new thg("1", "25", "50", "2023-12-01"));
        fakeTemperatureList.add(new thg("2", "22", "48", "2023-12-02"));
        fakeTemperatureList.add(new thg("3", "25", "60", "2023-12-01"));
        fakeTemperatureList.add(new thg("4", "22", "80", "2023-12-02"));
        fakeTemperatureList.add(new thg("5", "25", "50", "2023-12-01"));
        fakeTemperatureList.add(new thg("6", "22", "49", "2023-12-02"));
        recyclerViewt = findViewById(R.id.list_tt);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewt.setLayoutManager(layoutManager);

        // Initialisation de l'Adapter avec les données fictives
        listTadapter Adapter = new listTadapter(getApplicationContext(), fakeTemperatureList);
        recyclerViewt.setAdapter(Adapter);

        // Ajout d'une décoration pour le RecyclerView
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewt.getContext(), DividerItemDecoration.VERTICAL);
        recyclerViewt.addItemDecoration(dividerItemDecoration);

        Button btn = findViewById(R.id.btngt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(home_temp.this, graphT.class);
                startActivity(intent5);
            }
        });
    }
}