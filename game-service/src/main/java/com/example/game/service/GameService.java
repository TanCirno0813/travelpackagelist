package com.example.game.service;

import com.example.game.dto.AnswerRequest;
import com.example.game.dto.QuestionResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class GameService {

    public QuestionResponse generateQuestion() {
        Random random = new Random();
        int a = random.nextInt(5)+1;
        int b = random.nextInt(5)+1;
        int answer = a + b;

        int wrongOption = answer + (random.nextInt(5) + 1);
        if (wrongOption == answer) wrongOption += 1;

        List<Integer> options = Arrays.asList(answer, wrongOption);
        Collections.shuffle(options);

        return new QuestionResponse(a + " + " + b + " = ?", options);
    }

    public boolean checkAnswer(AnswerRequest request) {
        String[] parts = request.getQuestion().split("\\+");
        int a = Integer.parseInt(parts[0].trim());
        int b = Integer.parseInt(parts[1].split("=")[0].trim());
        int result = a + b;

        if (result == 9) {
            return request.getSelected() == 9;
        } else {
            return request.getSelected() != result;
        }
    }
}
