package com.example.myapplication;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import okhttp3.Headers;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MainFragment mainFragment = new MainFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainFrame, mainFragment)
                .commit();

        AsyncHttpClient client = new AsyncHttpClient();

        client.get("http://10.0.2.2:5062/Compte?email=elie@allo.allo&password=password", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                int t = 0;
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                int t = 0;
            }
        });
    }
}