package com.example.guest.howstheweatherappthere.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.guest.howstheweatherappthere.R;
import com.example.guest.howstheweatherappthere.models.Weather;
import com.example.guest.howstheweatherappthere.services.WeatherService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {
    public ArrayList<Weather> mWeather = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String zip = intent.getStringExtra("zip");

        getWeather(zip);
    }

    private void getWeather(String zip) {
        final WeatherService weatherService = new WeatherService();
        weatherService.findWeather(zip, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mWeather = weatherService.processResults(response);

                WeatherActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
//                        mAdapter = new RestaurantListAdapter(getApplicationContext(), mRestaurants);
//                        mRecyclerView.setAdapter(mAdapter);
//                        RecyclerView.LayoutManager layoutManager =
//                                new LinearLayoutManager(RestaurantsActivity.this);
//                        mRecyclerView.setLayoutManager(layoutManager);
//                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}
