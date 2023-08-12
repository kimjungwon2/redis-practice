//package com.example.pratice;
//
//import com.example.pratice.leaderboard.service.RankingService;
//import java.time.Duration;
//import java.time.Instant;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//@Slf4j
//public class RankingSimpleTest {
//
//    @Autowired
//    private RankingService rankingService;
//
//    @Test
//    @DisplayName("기존 순위 테스트")
//    void inMemorySort(){
//        ArrayList<Integer> list = new ArrayList<>();
//        for(int i=0;i<1000000;i++){
//            int score = (int)(Math.random()*1000000);
//            list.add(score);
//        }
//
//        Instant before = Instant.now();
//        Collections.sort(list);
//        Duration elapsed = Duration.between(before,Instant.now());
//
//        System.out.println("경과 시간 :" + elapsed.getNano()/1000000 +"ms");
//    }
//
//
//    @Test
//    void insertScore(){
//        for(int i=0;i<1000000;i++){
//            int score = (int)(Math.random()*1000000);
//            String userId = "user_"+i;
//            rankingService.setUserScore(userId,score);
//        }
//    }
//
//    @Test
//    void getRanks(){
//        rankingService.getTopRank(1);
//
//        Instant before = Instant.now();
//        Long userRank = rankingService.getUserRanking("user_100");
//        Duration elapsed = Duration.between(before,Instant.now());
//
//        System.out.println(String.format("User_100's Ranking : %d - 경과 시간 %d ms",userRank, elapsed.getNano()/1000000));
//
//        before = Instant.now();
//        List<String> topRankers = rankingService.getTopRank(10);
//        elapsed = Duration.between(before,Instant.now());
//
//        System.out.println(String.format("10명의 Top Rank - 경과 시간 %d ms",elapsed.getNano()/1000000));
//    }
//
//}
