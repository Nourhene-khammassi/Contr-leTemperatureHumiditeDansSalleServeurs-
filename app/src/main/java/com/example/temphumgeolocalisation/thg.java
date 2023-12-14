package com.example.temphumgeolocalisation;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable;

public class thg implements Parcelable {
    private String id ;
    private String temperature;
    private String humidite;
    private String date;
    public thg() {
    }
    public thg(String id, String temperature, String humidite, String date) {
        this.id = id;
        this.temperature = temperature;
        this.humidite = humidite;
        this.date = date;
    }



    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTemperature() {
        return temperature;
    }
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
    public String getHumidite() {
        return humidite;
    }
    public void setHumidite(String humidite) {
        this.humidite = humidite;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "temperature_Humidité et geoloc {" +
                "id='" + id + '\'' +
                ", temperature='" + temperature + '\'' +
                ", humidite='" + humidite + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    protected thg(Parcel in) {
        id = in.readString();
        temperature = in.readString();
        humidite = in.readString();
        date = in.readString();
    }

    public static final Creator<thg> CREATOR = new Creator<thg>() {
        @Override
        public thg createFromParcel(Parcel in) {
            return new thg(in);
        }

        @Override
        public thg[] newArray(int size) {
            return new thg[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(temperature);
        dest.writeString(humidite);
        dest.writeString(date);
    }
}
