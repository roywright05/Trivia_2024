package com.wrightr.trivia_2024.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.wrightr.trivia_2024.controller.AppController;
import com.wrightr.trivia_2024.model.Question;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class Repository {

     String url = "https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements-data.json";

    ArrayList<Question> questionArrayList = new ArrayList<>();


    public List<Question> getQuestion(final AnswerListAsyncResponse callback) {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,

                response -> {


                    for (int i = 0; i < response.length(); i++){

                        try {

                            Question question = new Question(response.getJSONArray(i).get(0).toString(),
                                    response.getJSONArray(i).getBoolean(1));

                            questionArrayList.add(question);

                            //Log.d("Hey yo!", "getQuestion: " + questionArrayList);

                           // Log.d("Question", "onCreate: " + response.getJSONArray(i).get(0));
                            //Log.d("Answer", "Survey Says!: " + response.getJSONArray(i).getBoolean(1));
                        } catch (JSONException e) {
                            //throw new RuntimeException(e);
                            e.printStackTrace();
                        }
                    }

                    if (callback != null){

                        callback.processFinished(questionArrayList);
                    }

                },
                error -> {


                }
        );

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

        return questionArrayList;
    }
}
