package com.example.game.dto;

import java.util.List;

public class QuestionResponse {
    private String question;
    private List<Integer> options;


    public QuestionResponse(String question, List<Integer> options) {
        this.question = question;
        this.options = options;
    }

    public String getQuestion() {
        return question;
    }

    public List<Integer> getOptions() {
        return options;
    }
}