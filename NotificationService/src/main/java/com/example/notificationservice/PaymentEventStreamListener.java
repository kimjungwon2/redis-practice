package com.example.notificationservice;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventStreamListener implements
        StreamListener<String, MapRecord<String,String,String>> {

    int paymentProcessId =0;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public void onMessage(MapRecord<String, String, String> message) {
        Map map = message.getValue();

        String userId = (String) map.get("userId");
        String paymentProcessId = (String) map.get("paymentProcessId");

        //결제 완료 건에 대한 SMS 발송 처리
        System.out.println("[Payment consumed] userId: "+userId+" paymentProcessId: "+paymentProcessId);

    }

}
