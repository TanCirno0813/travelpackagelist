package com.example.gatewayservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WebController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "MSA 프로젝트에 오신 것을 환영합니다");
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("message", "로그인");
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("message", "회원 가입");
        return "register";
    }


    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("message", "관리자 페이지");
        return "admin";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("postId", id);
        return "edit";
    }




    @GetMapping("/package")
    public String packageList() {
        return "packagelist"; // templates/packagelist.html
    }



    @GetMapping("/package/detail/{id}")
    public String packageDetailPage(@PathVariable Long id, Model model) {
        model.addAttribute("packageId", id);
        return "packagedetail"; // templates/packagedetail.html
    }






    @GetMapping("/post")
    public String post() {
        return "post"; // templates/post.html
    }

    @GetMapping("/view/{id}")
    public String view() {
        return "view";
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @GetMapping("/game/start")
    public String gameStart(Model model) {
        model.addAttribute("message", "계산력 게임 시작");
        return "game"; // templates/game.html (앞서 만들어준 게임 화면)
    }

    @GetMapping("/game/over")
    public String gameOver(@RequestParam int score, Model model) {
        model.addAttribute("score", score);
        return "game-over"; // templates/game-over.html
    }

    @PostMapping("/game/ranking")
    public String saveRanking(@RequestParam String nickname, @RequestParam int score, Model model) {
        // 나중에 Score-Service 연동 예정
        model.addAttribute("ranking", List.of(
                new Ranking("홍길동", 5),
                new Ranking(nickname, score)
        ));
        return "ranking"; // templates/ranking.html
    }

    static class Ranking {
        private String nickname;
        private int score;
        // 생성자, Getter, Setter
        public Ranking(String nickname, int score) {
            this.nickname = nickname;
            this.score = score;
        }
        public String getNickname() { return nickname; }
        public int getScore() { return score; }
    }
} 