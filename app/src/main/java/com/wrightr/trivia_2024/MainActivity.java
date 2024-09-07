package com.wrightr.trivia_2024;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private TextView tvTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvTest = findViewById(R.id.tv_test);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        String url = "https://www.google.com";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,

                 response -> {

                    tvTest.setText("200 response: " + response.substring(0, 300));
                     Log.d("Response", "onCreate: " + response.substring(0, 500));

                }, error -> {

                    tvTest.setText("404 ERROR!!!");
                }
        );

        queue.add(stringRequest);





    }
}