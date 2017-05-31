package com.example.guest.howstheweatherappthere.models;

/**
 * Created by Guest on 5/31/17.
 */

public class Weather {
    private Double mTemperature;
    private String mDescription;
    private Double mHumidity;
    private String mName;

    public Weather(Double temperature, String description, Double humidity, String name) {
        this.mTemperature = temperature;
        this.mDescription = description;
        this.mHumidity = humidity;
        this.mName = name;
    }

    public Double getTemperature() {
        return mTemperature;
    }

    public String getDescription() {
        return mDescription;
    }

    public Double getHumidity() {
        return mHumidity;
    }

    public String getName() {
        return mName;
    }
}
