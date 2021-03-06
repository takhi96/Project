package com.realtime.chattingproject.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @MessageMapping("/chat")
    //@SendTo("/topic")
    public void chatEndpoint(@Payload wsMessage wsMessage){
        System.out.println(wsMessage);
        messagingTemplate.convertAndSend("/topic",wsMessage);

    }
}
