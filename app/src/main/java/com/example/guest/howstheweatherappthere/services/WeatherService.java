package com.example.guest.howstheweatherappthere.services;

import com.example.guest.howstheweatherappthere.Constants;
import com.example.guest.howstheweatherappthere.models.Weather;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * Created by Guest on 5/31/17.
 */

public class WeatherService {
    public static void findForecast(String location, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.YOUR_QUERY_PARAMETER, location);
        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.API_KEY);
        String url = urlBuilder.build().toString();
    }

    public Weather processResults(Response response) {
        Weather responseForecast = new Weather();

        try {
            String jsonData = response.body().string();
            if(response.isSuccessful()) {
                JSONObject weatherJSON = new JSONObject(jsonData);
            }
        } catch (IOException e){
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return responseForecast;
    }
}
