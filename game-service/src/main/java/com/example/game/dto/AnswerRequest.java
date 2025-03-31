package com.example.game.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerRequest {
    private String question;
    private int selected;
    private int score;

}