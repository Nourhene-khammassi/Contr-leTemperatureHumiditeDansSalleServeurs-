package com.example.temphumgeolocalisation;
/*import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import java.util.List;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class graphH extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_h);

        final GraphView graphView = findViewById(R.id.graph_hh);

        String URL = "http://192.168.1.60/";
        Retrofit Rf = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apihandler api = Rf.create(apihandler.class);
        final retrofit.Call<List<thg>> listh = api.getAllHum();

        listh.enqueue(new Callback<List<thg>>() {
            @Override
            public void onResponse(Response<List<thg>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    List<thg> list = response.body();
                    Log.d("GraphData", "Number of data points from API: " + list.size());
                    LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
                    for (thg data : list) {
                        double y = Double.parseDouble(data.getHumidite());
                        double x = Double.parseDouble(data.getId());
                        series.appendData(new DataPoint(x, y), true, list.size() + 1);
                    }

                    Log.d("GraphData", "Number of data points in series: " + series.getHighestValueX());

                    runOnUiThread(() -> graphView.addSeries(series));

                    Log.d("GraphData", "Series added to graph");
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(getApplicationContext(), "Error " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
*/
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import java.util.ArrayList;
import java.util.List;

public class graphH extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_h);

        GraphView graphView = findViewById(R.id.graph_hh);

        List<thg> humidityList = getIntent().getParcelableArrayListExtra("humidityList");

        if (humidityList != null && !humidityList.isEmpty()) {
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
            for (thg data : humidityList) {
                double y = Double.parseDouble(data.getHumidite());
                double x = Double.parseDouble(data.getId());
                series.appendData(new DataPoint(x, y), true, humidityList.size() + 1);
            }
            series.setColor(Color.GREEN);

            graphView.addSeries(series);
        }
    }
}
