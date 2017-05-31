package com.example.guest.howstheweatherappthere.services;

import android.util.Log;

import com.example.guest.howstheweatherappthere.Constants;
import com.example.guest.howstheweatherappthere.models.Weather;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Guest on 5/31/17.
 */

public class WeatherService {
    public static void findWeather(String zip, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.YOUR_QUERY_PARAMETER, zip);
        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.API_KEY);
        String url = urlBuilder.build().toString();

        Log.d("url", url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Weather> processResults(Response response) {
        ArrayList<Weather> weather = new ArrayList<>();

        try {
            String jsonData = response.body().string();

            if(response.isSuccessful()) {
                JSONObject weatherJSON = new JSONObject(jsonData);
                Double temperature = weatherJSON.getJSONObject("main")
                        .getDouble("temp");
                String description = weatherJSON.getJSONArray("weather")
                        .getJSONObject(0).getString("description");
                Double humidity = weatherJSON.getJSONObject("main")
                        .getDouble("humidity");
                Log.v("humidity", humidity.toString());
                String name = weatherJSON.getString("name");
                Log.v("name", name);
                Weather responseWeather = new Weather(temperature, description, humidity, name);
                weather.add(responseWeather);
            }
        } catch (IOException e){
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("weather", weather.toString());
        return weather;

    }
}
