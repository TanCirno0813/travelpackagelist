package com.example.game.controller;

import com.example.game.dto.AnswerRequest;
import com.example.game.dto.QuestionResponse;
import com.example.game.service.GameService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/question")
    public QuestionResponse getQuestion() {
        return gameService.generateQuestion();
    }

    @PostMapping("/check")
    public boolean checkAnswer(@RequestBody AnswerRequest request) {
        return gameService.checkAnswer(request);
    }
}
