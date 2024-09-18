package com.wrightr.trivia_2024;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;
import com.wrightr.trivia_2024.controller.AppController;
import com.wrightr.trivia_2024.data.AnswerListAsyncResponse;
import com.wrightr.trivia_2024.data.Repository;
import com.wrightr.trivia_2024.databinding.ActivityMainBinding;
import com.wrightr.trivia_2024.model.Question;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String url = "https://raw.githubusercontent.com/samayo/country-json/master/src/country-by-capital-city.json";

        private ActivityMainBinding binding;
        private int currentQuestionIndex;
        List<Question> questionList;

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

        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);


          questionList = new Repository().getQuestion(questionArrayList ->{

                      binding.questionTv.setText(questionArrayList.get(currentQuestionIndex)
                              .getAnswer());

                      updateCounter(questionArrayList);
                  }
          );




        binding.btnNext.setOnClickListener(view -> {

            currentQuestionIndex = (currentQuestionIndex + 1 ) % questionList.size();
            Log.d("Click", "onCreate: " + currentQuestionIndex);
            updateQuestion();
        });

        binding.btnFalse.setOnClickListener(view -> {
            checkAnswer(false);
        });

        binding.btnTrue.setOnClickListener(view -> {
            checkAnswer(true);
        });

       // Log.d("Click", "onCreate: " + currentQuestionIndex);


    }

    private void checkAnswer(boolean userChoseCorrect) {

        boolean answer = questionList.get(currentQuestionIndex).isAnswerTrue();
        int snackMessageID = 0;

        if (userChoseCorrect == answer){
            snackMessageID = R.string.correct_answer;
        }else{
            snackMessageID = R.string.incorrect_answer;
        }

        Snackbar.make(binding.cardView, snackMessageID, Snackbar.LENGTH_LONG).show();
    }

    private void updateCounter(ArrayList<Question> questionArrayList) {
        binding.tvQuestionNum.setText("Question: " + currentQuestionIndex + "/"
        + questionArrayList.size());
    }

    private void updateQuestion() {
        String question = questionList.get(currentQuestionIndex).getAnswer();
        binding.questionTv.setText(question);
        updateCounter((ArrayList<Question>) questionList);
    }


}