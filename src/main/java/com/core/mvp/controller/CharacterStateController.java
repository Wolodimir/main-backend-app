package com.core.mvp.controller;

import com.core.mvp.kafka.payload.CharacterState;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/characterState")
public class CharacterStateController {

    @MessageMapping("/character.sendMessage")
    @SendTo("/topic/public")
    public CharacterState sendMessage(@Payload CharacterState characterState) {
        return characterState;
    }

    @MessageMapping("/character.addUser")
    @SendTo("/topic/public")
    public CharacterState addUser(@Payload CharacterState characterState, SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", characterState.getUserName());
        return characterState;
    }

}
