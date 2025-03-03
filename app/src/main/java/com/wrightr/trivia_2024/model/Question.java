package com.wrightr.trivia_2024.model;

import androidx.annotation.NonNull;

public class Question {

    private String answer;
    private boolean answerTrue;

    public Question(){}

    public Question(String answer, boolean answerTrue){

        this.answerTrue = answerTrue;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }

    @NonNull
    @Override
    public String toString() {
        return "Question{" +
                "answer='" + answer + '\'' +
                ", answerTrue=" + answerTrue +
                '}';
    }
}
