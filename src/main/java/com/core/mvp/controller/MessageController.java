package com.core.mvp.controller;

import com.core.mvp.kafka.KafkaJsonProducer;
import com.core.mvp.kafka.KafkaProducer;
import com.core.mvp.kafka.payload.CharacterState;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    public MessageController(KafkaProducer kafkaProducer, KafkaJsonProducer kafkaJsonProducer) {
        this.kafkaProducer = kafkaProducer;
        this.kafkaJsonProducer = kafkaJsonProducer;
    }

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message go to queue");
    }

    @PostMapping("/json")
    public ResponseEntity<String> ApiSendMessage(@RequestBody CharacterState characterState) {
        kafkaJsonProducer.sendCharacterState(characterState);
        return ResponseEntity.ok("Message go to queue");
    }
}
