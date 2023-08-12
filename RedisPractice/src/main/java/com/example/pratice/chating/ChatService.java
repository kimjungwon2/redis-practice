package com.example.pratice.chating;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Service;

@Service
public class ChatService implements MessageListener {

    @Autowired
    private RedisMessageListenerContainer container;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void enter(String chatRoomName){
        container.addMessageListener(this, new ChannelTopic(chatRoomName));

        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String line = in.nextLine();

            if(line.equals("q")){
                System.out.println("종료");
                break;
            }

            redisTemplate.convertAndSend(chatRoomName,line);
        }

        container.removeMessageListener(this);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("message = " + message.toString());
    }
}
