package com.example.temphumgeolocalisation;

import retrofit.Call;
import retrofit.http.GET;
import java.util.List;
import retrofit.Callback;
public interface apihandler {
    @GET("dht/list_hum.php")
    Call<List<thg>> getAllHum();
    @GET("dht/list_temp.php")
    Call<List<thg>> getAllTemp();
}

