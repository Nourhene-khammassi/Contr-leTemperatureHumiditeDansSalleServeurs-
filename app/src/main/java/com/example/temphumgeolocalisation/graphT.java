/*package com.example.temphumgeolocalisation;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import java.util.ArrayList;
import java.util.List;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
public class graphT extends AppCompatActivity {
    List<thg> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grapht);
        final GraphView graphView = (GraphView) findViewById(R.id.graph_tt);


        Intent intent = new Intent();

        String temp = getIntent().getStringExtra("temp");
        String date = getIntent().getStringExtra("date");
        Toast.makeText(this, temp, Toast.LENGTH_SHORT).show();
        String URL ="http://110.26.15.1:80/";
        Retrofit Rf = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        apihandler api = Rf.create(apihandler.class);
        final Call<List<thg>> listt= api.getAllTemp();
        listt.enqueue(new Callback<List<thg>>() {
            @Override
            public void onResponse(Response<List<thg>> response, Retrofit retrofit) {
                try {
                    if (response.isSuccess()) {
                        list = response.body();
                        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();

                        for (int i = 0; i < response.body().size(); i++) {
                            double y = Double.parseDouble(response.body().get(i).getTemperature());
                            double x = Double.parseDouble(response.body().get(i).getId());
                            series.appendData(new DataPoint(x, y), true, response.body().size());
                        }

                        graphView.addSeries(series);
                    }

                }
                catch (Exception e) {
                    Log.e("ApiRequest", "Error processing response", e);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(getApplicationContext(), "Error "+ t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}*/
package com.example.temphumgeolocalisation;

/*import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import java.util.ArrayList;
import java.util.List;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
public class graphT extends AppCompatActivity {
    List<thg> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grapht);
        final GraphView graphView = (GraphView) findViewById(R.id.graph_tt);
        Intent intent = new Intent();
        String temp = getIntent().getStringExtra("temp");
        String date = getIntent().getStringExtra("date");
        Toast.makeText(this, temp, Toast.LENGTH_SHORT).show();
        String URL ="http://10.26.15.1:80/";
        Retrofit Rf = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        apihandler api = Rf.create(apihandler.class);
        final Call<List<thg>> listt= api.getAllTemp();
        listt.enqueue(new Callback<List<thg>>() {
            @Override
            public void onResponse(Response<List<thg>> response,
                                   Retrofit retrofit) {
                if(response.isSuccess()){
                    list = response.body();
                    double y = 0;
                    double x = 0;
                    LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
                    series.appendData(new DataPoint(0,0), true, response.body().size());
                    for(int i=0;i<response.body().size();i++){
                        y=
                                Double.parseDouble(response.body().get(i).getTemperature());
                        x =
                                Double.parseDouble(response.body().get(i).getId());
                        series.appendData(new DataPoint(x,y),
                                true, response.body().size());
                    }
                    graphView.addSeries(series);
                }
            }
            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(getApplicationContext(), "Error "+ t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}*/

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class graphT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grapht);

        final GraphView graphView = findViewById(R.id.graph_tt);

        // Assuming you have static temperature data
        double[] temperatureData = {20.5, 21.0, 22.3, 20.8, 21.5};

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();

        for (int i = 0; i < temperatureData.length; i++) {
            double x = i; // You can adjust the x values according to your requirements
            double y = temperatureData[i];
            series.appendData(new DataPoint(x, y), true, temperatureData.length);
        }

        graphView.addSeries(series);
    }
}
