package com.example.guest.howstheweatherappthere.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.guest.howstheweatherappthere.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.zipEditText)
    EditText mZipEditText;
    @Bind(R.id.submitZipButton)
    ImageButton mSubmitZipButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSubmitZipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String zip = mZipEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                intent.putExtra("zip", zip);
                startActivity(intent);
            }
        });
    }

}
