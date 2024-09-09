package com.wrightr.trivia_2024.data;

import com.wrightr.trivia_2024.model.Question;

import java.util.ArrayList;

public interface AnswerListAsyncResponse {

    void processFinished(ArrayList<Question> questionArrayList);
}
