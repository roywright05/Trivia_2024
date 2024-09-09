package com.wrightr.trivia_2024.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.wrightr.trivia_2024.controller.AppController;
import com.wrightr.trivia_2024.model.Question;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    static String url = "https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements-data.json";

    ArrayList<Question> questionArrayList = new ArrayList<>();

    public static List<Question> getQuestion() {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,

                response -> {
                    Log.d("TAG", "onCreate: " + response.toString());
                },
                error -> {


                }
        );

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

        return null;
    }
}
