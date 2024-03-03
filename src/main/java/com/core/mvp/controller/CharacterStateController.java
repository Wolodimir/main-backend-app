package com.core.mvp.controller;

import com.core.mvp.webSocket.payload.CharacterState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class CharacterStateController {

    static final Logger log = LoggerFactory.getLogger(CharacterStateController.class);

    @MessageMapping("/character.sendMessage")
    @SendTo("/topic/public")
    public CharacterState sendMessage(@Payload CharacterState characterState) {
        log.info(characterState.toString());
        return new CharacterState();
    }

    @MessageMapping("/character.addUser")
    @SendTo("/topic/public")
    public CharacterState addUser(@Payload CharacterState characterState, SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", characterState.getName());
        return characterState;
    }

}
