package com.example.pratice.caching.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ExternalApiService {


    public String getUserName(String userId){

        try {
            Thread.sleep(500);
        }catch(InterruptedException e){
        }

        log.info("Getting User name from other service");

        if(userId.equals("A")){
            return "Kim";
        }
        if(userId.equals("B")){
            return "Son";
        }

        return "";
    }

    @Cacheable(cacheNames = "userAgeCache",key= "#userId")
    public int getUserAge(String userId){

        try {
            Thread.sleep(500);
        }catch(InterruptedException e){
        }

        log.info("Getting User age from other service");

        if(userId.equals("A")){
            return 28;
        }
        if(userId.equals("B")){
            return 32;
        }

        return 0;
    }


}
