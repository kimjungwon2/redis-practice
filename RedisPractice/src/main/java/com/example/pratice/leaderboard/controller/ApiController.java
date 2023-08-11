package com.example.pratice.leaderboard.controller;

import com.example.pratice.leaderboard.service.RankingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    private RankingService rankingService;

    @GetMapping("/setScore")
    public Boolean setScore(
            @RequestParam String userId,
            @RequestParam int score
    ){
        return rankingService.setUserScore(userId,score);
    }

    @GetMapping("/getRank")
    public Long getUserRank(@RequestParam String userId){
        return rankingService.getUserRanking(userId);
    }

    @GetMapping("/getTopRanks")
    public List<String> getTopRanks(){
        return rankingService.getTopRank(3);
    }
}
